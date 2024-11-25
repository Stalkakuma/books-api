package lt.vidunas.library.dto;

import java.math.BigDecimal;

public record BookResponse(Long id, String title,
                           String author, String isbn,
                           String description, int pages,
                           BigDecimal price, String cover,
                           boolean reserved) {
}
