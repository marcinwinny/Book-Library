package com.marcinwinny.booklibrary.mapper;

import com.marcinwinny.booklibrary.dto.BookDto;
import com.marcinwinny.booklibrary.dto.accessinfodto.AccessInfoDto;
import com.marcinwinny.booklibrary.dto.accessinfodto.FormatDto;
import com.marcinwinny.booklibrary.dto.saleinfodto.SaleInfoDto;
import com.marcinwinny.booklibrary.dto.searchinfodto.SearchInfoDto;
import com.marcinwinny.booklibrary.dto.volumeinfodto.ImageLinksDto;
import com.marcinwinny.booklibrary.dto.volumeinfodto.IndustryIdDto;
import com.marcinwinny.booklibrary.dto.volumeinfodto.ReadingModesDto;
import com.marcinwinny.booklibrary.dto.volumeinfodto.VolumeInfoDto;
import com.marcinwinny.booklibrary.model.Book;
import lombok.AllArgsConstructor;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookMapperTest {

    @Test
    void mapDtoToBook() {
        VolumeInfoDto volumeInfoDto = VolumeInfoDto.builder()
                .title("A Hypervista of the Java Landscape")
                .publisher("InfoStrategist.com")
                .industryIdentifiers(new ArrayList<>(List.of(
                    new IndustryIdDto("ISBN_13", "9781592432172"),
                    new IndustryIdDto("ISBN_10", "1592432174"))))
                .readingModes(new ReadingModesDto(true, true))
                .printType("BOOK")
                .maturityRating("NOT_MATURE")
                .allowAnonLogging(false)
                .contentVersion("1.0.1.0.preview.3")
                .imageLinks(new ImageLinksDto("xxx","yyy"))
                .language("en")
                .previewLink("qqq")
                .infoLink("www")
                .canonicalVolumeLink("eee")
                .build();

        SaleInfoDto saleInfoDto = SaleInfoDto.builder()
                .country("PL")
                .saleability("NOT_FOR_SALE")
                .isEbook(false)
                .build();

        SearchInfoDto searchInfoDto = SearchInfoDto.builder()
                .textSnippet("xxx")
                .build();

        AccessInfoDto accessInfoDto = AccessInfoDto.builder()
                .country("PL")
                .viewability("PARTIAL")
                .embeddable(true)
                .publicDomain(true)
                .textToSpeechPermission("ALLOWED")
                .epub(new FormatDto(true, "epub link"))
                .pdf(new FormatDto(true, "pdf link"))
                .webReaderLink("rrrr")
                .accessViewStatus("SAMPLE")
                .quoteSharingAllowed(false)
                .build();

        BookDto bookDto = BookDto.builder()
                .kind("books#volume")
                .id("7tkN1CYzn2cC")
                .etag("pfjjxSpetIM")
                .selfLink("https://www.googleapis.com/books/v1/volumes/7tkN1CYzn2cC")
                .volumeInfo(volumeInfoDto)
                .saleInfo(saleInfoDto)
                .searchInfo(searchInfoDto)
                .accessInfo(accessInfoDto)
                .build();

        Book book = BookMapper.INSTANCE.mapDtoToBook(bookDto);

        assertEquals("books#volume", book.getKind());
        assertEquals("7tkN1CYzn2cC", book.getBookId());
        assertEquals("pfjjxSpetIM", book.getEtag());
        assertEquals("https://www.googleapis.com/books/v1/volumes/7tkN1CYzn2cC", book.getSelfLink());
        assertEquals("A Hypervista of the Java Landscape", book.getVolumeInfo().getTitle());

    }
}