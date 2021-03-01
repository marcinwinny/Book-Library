package com.marcinwinny.booklibrary.mapper;

import com.marcinwinny.booklibrary.dto.BookDto;
import com.marcinwinny.booklibrary.dto.accessinfodto.AccessInfoDto;
import com.marcinwinny.booklibrary.dto.saleinfodto.SaleInfoDto;
import com.marcinwinny.booklibrary.dto.searchinfodto.SearchInfoDto;
import com.marcinwinny.booklibrary.dto.volumeinfodto.VolumeInfoDto;
import com.marcinwinny.booklibrary.model.Book;
import com.marcinwinny.booklibrary.model.accesinfo.AccessInfo;
import com.marcinwinny.booklibrary.model.saleinfo.SaleInfo;
import com.marcinwinny.booklibrary.model.searchinfo.SearchInfo;
import com.marcinwinny.booklibrary.model.volumeinfo.VolumeInfo;
import lombok.NoArgsConstructor;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {AccessInfoMapper.class, SaleInfoMapper.class, SearchInfoMapper.class, VolumeInfoMapper.class})
public interface BookMapper {

    BookMapper INSTANCE = Mappers.getMapper( BookMapper.class );

    @Mapping(target = "id", ignore = true)
    Book mapDtoToBook(BookDto bookDto);

    BookDto mapBookToDto(Book book);
}
