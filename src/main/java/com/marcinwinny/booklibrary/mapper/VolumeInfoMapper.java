package com.marcinwinny.booklibrary.mapper;

import com.marcinwinny.booklibrary.dto.volumeinfodto.IndustryIdDto;
import com.marcinwinny.booklibrary.dto.volumeinfodto.ReadingModesDto;
import com.marcinwinny.booklibrary.dto.volumeinfodto.VolumeInfoDto;
import com.marcinwinny.booklibrary.model.volumeinfo.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VolumeInfoMapper {

    VolumeInfoMapper INSTANCE = Mappers.getMapper( VolumeInfoMapper.class );

    @Mapping(target = "id", ignore = true)
    VolumeInfo mapDtoToVolumeInfo(VolumeInfoDto volumeInfoDto);

    @Mapping(target = "id", ignore = true)
    IndustryId mapDtoToIndustryId(IndustryIdDto industryIdDto);

    @Mapping(target = "id", ignore = true)
    ReadingModes mapDtoToReadingModes(ReadingModesDto readingModesDto);


//
//    @Mapping(target = "id", ignore = true)
//    Category mapDtoToCategory(String name);
//
    List<Author> mapDtoToAuthors(List<String> authors);

    List<String> mapAuthorsToDto(List<Author> authors);

    Author mapDtoToAuthor(String name);

    String mapAuthorToDto(Author author);

//
//    List<Category> mapDtoToCategories(List<String> categories);
//
//
//    String mapCategoryToDto(Category category);
//
//
////    List<String> mapCategoriesToDto(List<Category> categories);




}
