package lt.vidunas.library.services;


import lombok.RequiredArgsConstructor;
import lt.vidunas.library.dto.CategoryCreationDTO;
import lt.vidunas.library.entities.Category;
import lt.vidunas.library.exceptions.CategoryNotFoundException;
import lt.vidunas.library.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category findById(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException("Category not found, try a different id"));
    }

    public List<CategoryCreationDTO> getCategoriesAsDTOs() {
        return categoryRepository.getCategoriesDTO();
    }

    public List<Category> getAllCategoriesWithBooks() {
        return categoryRepository.findAll();
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteCategory(Category category) {
        categoryRepository.delete(category);
    }

}
