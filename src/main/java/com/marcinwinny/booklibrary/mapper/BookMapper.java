package com.marcinwinny.booklibrary.mapper;

import com.marcinwinny.booklibrary.dto.BookDto;
import com.marcinwinny.booklibrary.model.Book;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(
        uses = {AccessInfoMapper.class, SaleInfoMapper.class, SearchInfoMapper.class, VolumeInfoMapper.class},
        injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper( BookMapper.class );

    @Mapping(target = "bookId", source = "id")
    @Mapping(target = "id", source = "genId")
    Book mapDtoToBook(BookDto bookDto);

    @InheritInverseConfiguration
    BookDto mapBookToDto(Book book);
}
