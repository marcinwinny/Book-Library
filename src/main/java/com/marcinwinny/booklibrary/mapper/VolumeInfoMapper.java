package com.marcinwinny.booklibrary.mapper;

import com.marcinwinny.booklibrary.dto.volumeinfodto.IndustryIdDto;
import com.marcinwinny.booklibrary.dto.volumeinfodto.ReadingModesDto;
import com.marcinwinny.booklibrary.dto.volumeinfodto.VolumeInfoDto;
import com.marcinwinny.booklibrary.model.volumeinfo.Author;
import com.marcinwinny.booklibrary.model.volumeinfo.IndustryId;
import com.marcinwinny.booklibrary.model.volumeinfo.ReadingModes;
import com.marcinwinny.booklibrary.model.volumeinfo.VolumeInfo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface VolumeInfoMapper {

    VolumeInfoMapper INSTANCE = Mappers.getMapper(VolumeInfoMapper.class);

    VolumeInfo mapDtoToVolumeInfo(VolumeInfoDto volumeInfoDto);

    IndustryId mapDtoToIndustryId(IndustryIdDto industryIdDto);

    ReadingModes mapDtoToReadingModes(ReadingModesDto readingModesDto);

    List<Author> mapDtoToAuthors(List<String> authors);

    Author mapDtoToAuthor(String name);

    default String mapAuthorToString(Author author) {
        return author.getName();
    }
}
