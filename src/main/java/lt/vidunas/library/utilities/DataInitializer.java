package lt.vidunas.library.utilities;

import lt.vidunas.library.entities.Book;
import lt.vidunas.library.entities.Category;
import lt.vidunas.library.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class DataInitializer {

    @Autowired
    private CategoryRepository categoryRepository;

    @Bean
    public CommandLineRunner loadData() {
        return (args) -> {
            if (categoryRepository.count() == 0) {
                System.out.println("Populating database...");

                Category sciFi = new Category();
                sciFi.setName("Science Fiction");

                Category fantasy = new Category();
                fantasy.setName("Fantasy");

                Book book1 = new Book();
                book1.setIsbn((long)233135);
                book1.setTitle("The Future");
                book1.setAuthor("Naomi Alderman");
                book1.setDescription("When Martha Einkorn fled her father’s isolated compound in Oregon, she never expected to find herself working for a powerful social media mogul hell-bent on controlling everything. Now she’s surrounded by mega-rich companies designing private weather, predictive analytics, and covert weaponry, while spouting technological prophecy. Martha may have left the cult, but if the apocalyptic warnings in her father’s fox and rabbit sermon—once a parable to her—are starting to come true, how much future is actually left?\n" +
                        "\n" +
                        "Across the world, in a mall in Singapore, Lai Zhen, an internet-famous survivalist, flees from an assassin. She’s cornered, desperate and—worst of all—might die without ever knowing what's going on. Suddenly, a remarkable piece of software appears on her phone telling her exactly how to escape. Who made it? What is it really for? And if those behind it can save her from danger, what do they want from her, and what else do they know about the future?\n" +
                        "\n" +
                        "Martha and Zhen’s worlds are about to collide. An explosive chain of events is set in motion. While a few billionaires assured of their own safety lead the world to destruction, Martha’s relentless drive and Zhen’s insatiable curiosity could lead to something beautiful or the cataclysmic end of civilization.");
                book1.setPages(432);
                book1.setPrice(BigDecimal.valueOf(14.99));
                book1.setCover("https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1678895127i/123163147.jpg");
                book1.setReserved(false);
                book1.setCategory(sciFi);


                Book book2 = new Book();
                book2.setIsbn((long)233112135);
                book2.setTitle("A Deadly Education");
                book2.setAuthor("Naomi Novik");
                book2.setDescription("Lesson One of the Scholomance: Learning has never been this deadly.\n" +
                        "\n" +
                        "A Deadly Education is set at Scholomance, a school for the magically gifted where failure means certain death (for real) — until one girl, El, begins to unlock its many secrets.\n" +
                        "\n" +
                        "There are no teachers, no holidays, and no friendships, save strategic ones. Survival is more important than any letter grade, for the school won’t allow its students to leave until they graduate… or die! The rules are deceptively simple: Don’t walk the halls alone. And beware of the monsters who lurk everywhere.\n" +
                        "\n" +
                        "El is uniquely prepared for the school’s dangers. She may be without allies, but she possesses a dark power strong enough to level mountains and wipe out millions. It would be easy enough for El to defeat the monsters that prowl the school. The problem? Her powerful dark magic might also kill all the other students.");
                book2.setPages(320);
                book2.setPrice(BigDecimal.valueOf(28.00));
                book2.setCover("https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1596909044i/50548197.jpg");
                book2.setReserved(true);
                book2.setCategory(fantasy);

                sciFi.setBooks(List.of(book1));
                fantasy.setBooks(List.of(book2));

                categoryRepository.saveAll(List.of(sciFi, fantasy));
                System.out.println("Database has been populated!");
            }
            else {
                System.out.println("Database already populated. Skipping initialization.");
            }
        };
    }
}
