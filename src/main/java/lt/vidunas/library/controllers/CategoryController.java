package lt.vidunas.library.controllers;


import lombok.RequiredArgsConstructor;
import lt.vidunas.library.dto.CategoryCreationDTO;
import lt.vidunas.library.dto.CategoryResponse;
import lt.vidunas.library.entities.Category;
import lt.vidunas.library.mapper.CategoryMapper;
import lt.vidunas.library.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin("*")
@RequestMapping("/api/v2/categories")
public class CategoryController {
    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @GetMapping("/{categoryId}")
    public CategoryResponse getCategory(@PathVariable Long categoryId) {
        Category category = categoryService.findById(categoryId);
        return categoryMapper.toCategoryResponse(category);
    }


    @GetMapping
    public List<CategoryCreationDTO> getAllCategories() {
        return categoryService.getCategoriesAsDTOs();
    }

    @GetMapping("/with-books")
    public List<Category> getAllCategoriesWithBooks() {
       return categoryService.getAllCategoriesWithBooks();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse createCategory(@RequestBody CategoryCreationDTO categoryCreationDTO) {
        Category category = categoryMapper.toCategory(categoryCreationDTO);
        category = categoryService.saveCategory(category);
        return categoryMapper.toCategoryResponse(category);
    }
}
