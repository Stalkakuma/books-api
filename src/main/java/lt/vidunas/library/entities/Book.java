package lt.vidunas.library.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = "category")
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @JsonBackReference
    private Category category;

    private Long Isbn;
    private String title;
    private String author;

    @Column( length = 100000 )
    private String description;
    private int pages;
    private BigDecimal price;
    private String cover;
    private boolean reserved;

    public void addCategory(Category category) {
        this.category = category;
        category.getBooks().add(this);
    }

    public void removeCategory(Category category) {
        this.category = category;
        this.category = null;
    }
}
