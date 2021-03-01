package com.marcinwinny.booklibrary.mapper;

import com.marcinwinny.booklibrary.dto.volumeinfodto.ImageLinksDto;
import com.marcinwinny.booklibrary.dto.volumeinfodto.IndustryIdDto;
import com.marcinwinny.booklibrary.dto.volumeinfodto.ReadingModesDto;
import com.marcinwinny.booklibrary.dto.volumeinfodto.VolumeInfoDto;
import com.marcinwinny.booklibrary.model.Country;
import com.marcinwinny.booklibrary.model.volumeinfo.MaturityRating;
import com.marcinwinny.booklibrary.model.volumeinfo.PrintType;
import com.marcinwinny.booklibrary.model.volumeinfo.VolumeInfo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
                .imageLinks(new ImageLinksDto("xx","yy"))
                .language("pl")
                .previewLink("XX")
                .infoLink("ss")
                .canonicalVolumeLink("dd")
                .build();

        VolumeInfo volumeInfo = VolumeInfoMapper.INSTANCE.mapDtoToVolumeInfo(volumeInfoDto);

        Assertions.assertNotNull(volumeInfo);
        Assertions.assertEquals(volumeInfo.getTitle(), "title");
        Assertions.assertEquals(volumeInfo.getPublisher(), "Helion");
        Assertions.assertEquals(volumeInfo.getPublishedDate(), "2013-12-09");
        Assertions.assertEquals(volumeInfo.getDescription(), "tick");
        Assertions.assertEquals(volumeInfo.getReadingModes().getText(), true);
        Assertions.assertEquals(volumeInfo.getReadingModes().getImage(), true);
        Assertions.assertEquals(volumeInfo.getPageCount(), 864L);
        Assertions.assertEquals(volumeInfo.getPrintType(), PrintType.BOOK);
        Assertions.assertEquals(volumeInfo.getMaturityRating(), MaturityRating.NOT_MATURE);
        Assertions.assertEquals(volumeInfo.getAllowAnonLogging(), true);
        Assertions.assertEquals(volumeInfo.getContentVersion(), "2.4.5");
        Assertions.assertEquals(volumeInfo.getImageLinks().getSmallThumbnail(), "xx");
        Assertions.assertEquals(volumeInfo.getImageLinks().getThumbnail(), "yy");
        Assertions.assertEquals(volumeInfo.getLanguage(), "pl");
        Assertions.assertEquals(volumeInfo.getPreviewLink(), "XX");
        Assertions.assertEquals(volumeInfo.getInfoLink(), "ss");
        Assertions.assertEquals(volumeInfo.getCanonicalVolumeLink(), "dd");
        Assertions.assertEquals(volumeInfo.getAuthors().get(0), "Lionel Messi");
        Assertions.assertEquals(volumeInfo.getAuthors().get(1), "Ben Simmons");
        Assertions.assertEquals(volumeInfo.getCategories().get(0), "Computers");
    }
}