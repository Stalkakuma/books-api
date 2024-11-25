package lt.vidunas.library.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@NotEmpty
@Data
@Getter
@Valid
@AllArgsConstructor
public class CategoryCreationDTO {
    private Long id;
    @NotEmpty(message = "Name cannot be empty")
    private String name;
}
