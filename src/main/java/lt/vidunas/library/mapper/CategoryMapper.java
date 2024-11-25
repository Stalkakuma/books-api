package lt.vidunas.library.mapper;

import lt.vidunas.library.dto.CategoryCreationDTO;
import lt.vidunas.library.dto.CategoryResponse;
import lt.vidunas.library.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CategoryMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "books", ignore = true)
    Category toCategory(CategoryCreationDTO categoryCreationDTO);

    CategoryResponse toCategoryResponse(Category category);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "books", ignore = true)
    void updateCategory(CategoryCreationDTO categoryCreationDTO, @MappingTarget Category category);
}
