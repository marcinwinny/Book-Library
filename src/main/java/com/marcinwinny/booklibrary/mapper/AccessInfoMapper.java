package com.marcinwinny.booklibrary.mapper;

import com.marcinwinny.booklibrary.dto.accessinfodto.AccessInfoDto;
import com.marcinwinny.booklibrary.dto.accessinfodto.FormatDto;
import com.marcinwinny.booklibrary.model.accesinfo.AccessInfo;
import com.marcinwinny.booklibrary.model.accesinfo.Format;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccessInfoMapper {

    AccessInfoMapper INSTANCE = Mappers.getMapper( AccessInfoMapper.class );

    AccessInfo mapDtoToAccessInfo(AccessInfoDto accessInfoDto);

    Format mapDtoToFormat(FormatDto formatDto);

}
