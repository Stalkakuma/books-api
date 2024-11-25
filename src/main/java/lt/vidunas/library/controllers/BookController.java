package lt.vidunas.library.controllers;

import jakarta.validation.Valid;
import lt.vidunas.library.dto.BookCreationDTO;
import lt.vidunas.library.dto.BookResponse;
import lt.vidunas.library.entities.Book;
import lt.vidunas.library.entities.Category;
import lt.vidunas.library.mapper.BookMapper;
import lt.vidunas.library.services.BookService;
import lt.vidunas.library.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/books")
@CrossOrigin("*")
@Validated
public class BookController {

    private final BookService bookService;
    private final CategoryService categoryService;
    private final BookMapper bookMapper;

    public BookController(BookService bookService, CategoryService categoryService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.categoryService = categoryService;
        this.bookMapper = bookMapper;
    }


    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{categoryId}")
    public BookResponse createBook(@Valid @RequestBody BookCreationDTO bookCreationDTO, @PathVariable Long categoryId) {
        Category category = categoryService.findById(categoryId);
        Book book = bookMapper.toBook(bookCreationDTO);
        book.addCategory(category);
        book = bookService.addBook(book);
        return bookMapper.toBookResponse(book);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @Valid @RequestBody BookCreationDTO bookCreationDTO) {
            return ResponseEntity.ok(bookService.updateBook(id, bookCreationDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok("Book successfully deleted");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        Book book = bookService.findBook(id);
        return ResponseEntity.ok(book);
    }
}
