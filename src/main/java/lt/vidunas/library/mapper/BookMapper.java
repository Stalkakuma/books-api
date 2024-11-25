package lt.vidunas.library.mapper;

import lt.vidunas.library.dto.BookCreationDTO;
import lt.vidunas.library.dto.BookResponse;
import lt.vidunas.library.entities.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",
nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface BookMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    Book toBook(BookCreationDTO bookCreationDTO);

    BookResponse toBookResponse(Book book);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    void updateBookFromRequest(BookCreationDTO bookCreationDTO, @MappingTarget Book book);
}
