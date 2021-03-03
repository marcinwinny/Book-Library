package com.marcinwinny.booklibrary.mapper;

import com.marcinwinny.booklibrary.dto.volumeinfodto.ImageLinksDto;
import com.marcinwinny.booklibrary.dto.volumeinfodto.IndustryIdDto;
import com.marcinwinny.booklibrary.dto.volumeinfodto.ReadingModesDto;
import com.marcinwinny.booklibrary.dto.volumeinfodto.VolumeInfoDto;
import com.marcinwinny.booklibrary.model.volumeinfo.MaturityRating;
import com.marcinwinny.booklibrary.model.volumeinfo.PrintType;
import com.marcinwinny.booklibrary.model.volumeinfo.VolumeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class VolumeInfoMapperTest {

    @Test
    void mapDtoToVolumeInfo() {
        VolumeInfoDto volumeInfoDto = VolumeInfoDto.builder()
                .title("title")
                .authors(new ArrayList<>(List.of("Lionel Messi", "Ben Simmons")))
                .publisher("Helion")
                .publishedDate("2013-12-09")
                .description("tick")
                .industryIdentifiers(new ArrayList<>(List.of(
                        new IndustryIdDto("ISBN_13", "1111"),
                        new IndustryIdDto("ISBN_10", "111122"))))
                .readingModes(new ReadingModesDto(true, true))
                .pageCount(864L)
                .printType("BOOK")
                .categories(new ArrayList<>(List.of("Computers")))
                .maturityRating("NOT_MATURE")
                .allowAnonLogging(true)
                .contentVersion("2.4.5")
                .imageLinks(new ImageLinksDto("xx", "yy"))
                .language("pl")
                .previewLink("XX")
                .infoLink("ss")
                .canonicalVolumeLink("dd")
                .build();

        VolumeInfo volumeInfo = VolumeInfoMapper.INSTANCE.mapDtoToVolumeInfo(volumeInfoDto);

        Assertions.assertNotNull(volumeInfo);
        Assertions.assertEquals("title", volumeInfo.getTitle());
        Assertions.assertEquals("Helion", volumeInfo.getPublisher());
        Assertions.assertEquals("2013-12-09", volumeInfo.getPublishedDate());
        Assertions.assertEquals("tick", volumeInfo.getDescription());
        Assertions.assertEquals(true, volumeInfo.getReadingModes().getText());
        Assertions.assertEquals(true, volumeInfo.getReadingModes().getImage());
        Assertions.assertEquals(864L, volumeInfo.getPageCount());
        Assertions.assertEquals(PrintType.BOOK, volumeInfo.getPrintType());
        Assertions.assertEquals(MaturityRating.NOT_MATURE, volumeInfo.getMaturityRating());
        Assertions.assertEquals(true, volumeInfo.getAllowAnonLogging());
        Assertions.assertEquals("2.4.5", volumeInfo.getContentVersion());
        Assertions.assertEquals("xx", volumeInfo.getImageLinks().getSmallThumbnail());
        Assertions.assertEquals("yy", volumeInfo.getImageLinks().getThumbnail());
        Assertions.assertEquals("pl", volumeInfo.getLanguage());
        Assertions.assertEquals("XX", volumeInfo.getPreviewLink());
        Assertions.assertEquals("ss", volumeInfo.getInfoLink());
        Assertions.assertEquals("dd", volumeInfo.getCanonicalVolumeLink());
        Assertions.assertEquals("Lionel Messi", volumeInfo.getAuthors().get(0).getName());
        Assertions.assertEquals("Ben Simmons", volumeInfo.getAuthors().get(1).getName());
        Assertions.assertEquals("Computers", volumeInfo.getCategories().get(0));
    }
}