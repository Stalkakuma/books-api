package lt.vidunas.library.repositories;

import lt.vidunas.library.dto.CategoryCreationDTO;
import lt.vidunas.library.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT new lt.vidunas.library.dto.CategoryCreationDTO(c.id, c.name) FROM Category c")
    List<CategoryCreationDTO> getCategoriesDTO();
}
