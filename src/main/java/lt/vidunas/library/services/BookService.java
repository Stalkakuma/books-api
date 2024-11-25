package lt.vidunas.library.services;

import lt.vidunas.library.dto.BookCreationDTO;
import lt.vidunas.library.entities.Book;
import lt.vidunas.library.exceptions.BookNotFoundException;
import lt.vidunas.library.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findBook(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book by Id "+id+" not found. Try a different id"));
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book updateBook(Long id, BookCreationDTO bookCreationDTO) {
        Book book = findBook(id);
        bookRepository.save(bookFieldsUpdate(book, bookCreationDTO));
        return book;
    }

    public Book bookFieldsUpdate(Book book, BookCreationDTO bookCreationDTO) {
        book.setTitle(bookCreationDTO.getTitle());
        book.setAuthor(bookCreationDTO.getAuthor());
        book.setPrice(bookCreationDTO.getPrice());
        book.setCover(bookCreationDTO.getCover());
        book.setReserved(bookCreationDTO.isReserved());
        return book;
    }

    public void deleteBook(Long id) {
        Book book = findBook(id);
        bookRepository.delete(book);
    }



}
