package com.marcinwinny.booklibrary.mapper;

import com.marcinwinny.booklibrary.dto.searchinfodto.SearchInfoDto;
import com.marcinwinny.booklibrary.model.searchinfo.SearchInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SearchInfoMapper {

    SearchInfoMapper INSTANCE = Mappers.getMapper( SearchInfoMapper.class );

    @Mapping(target = "id", ignore = true)
    SearchInfo mapDtoToSearchInfo(SearchInfoDto searchInfoDto);

}
