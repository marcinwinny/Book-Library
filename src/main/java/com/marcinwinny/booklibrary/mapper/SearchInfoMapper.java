package com.marcinwinny.booklibrary.mapper;

import com.marcinwinny.booklibrary.dto.searchinfodto.SearchInfoDto;
import com.marcinwinny.booklibrary.model.searchinfo.SearchInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SearchInfoMapper {

    SearchInfoMapper INSTANCE = Mappers.getMapper(SearchInfoMapper.class);

    SearchInfo mapDtoToSearchInfo(SearchInfoDto searchInfoDto);

}
