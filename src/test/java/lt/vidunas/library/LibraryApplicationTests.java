package lt.vidunas.library;

import lt.vidunas.library.entities.Book;
import lt.vidunas.library.repositories.BookRepository;
import lt.vidunas.library.services.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class LibraryApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BookService bookService;


	@Test
	void testGetBook_whenBookExists() throws Exception {
		Book book = new Book();
		book.setId(1L);
		book.setTitle("Book 1");

		//TODO Learn to mock
//		when(bookService.findBook(1L)).thenReturn(book);

		mockMvc.perform(get("/api/v2/books/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(1));
	}

	@Test
	void testGetBooksEndpoint() throws Exception {
		Book book = new Book();
		book.setId(1L);
		book.setTitle("Book 1");
		Book book2 = new Book();
		book2.setId(2L);
		book2.setTitle("Book 2");
		//mokinti repozitoriją

		bookRepository.save(book);
		bookRepository.save(book2);

		mockMvc.perform(get("/api/v2/books"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.length()").value(2));
	}

	//TODO learn context
	@Test
	void contextLoads() {
	}


}
