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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BookMapperTest {

    @Test
    void mapDtoToBook() {
        BookDto bookDto = new BookDto();
        bookDto.setKind("books#volume");
//        bookDto.setId("7tkN1CYzn2cC");
        bookDto.setEtag("pfjjxSpetIM");
        bookDto.setSelfLink("https://www.googleapis.com/books/v1/volumes/7tkN1CYzn2cC");

        VolumeInfoDto volumeInfoDto = new VolumeInfoDto();
        volumeInfoDto.setTitle("A Hypervista of the Java Landscape");
        volumeInfoDto.setPublisher("InfoStrategist.com");
        ArrayList<IndustryIdDto> industryIdDtos = new ArrayList<>();
        industryIdDtos.add(new IndustryIdDto("ISBN_13", "9781592432172"));
        industryIdDtos.add(new IndustryIdDto("ISBN_10", "1592432174"));
        volumeInfoDto.setIndustryIdentifiers(industryIdDtos);
        volumeInfoDto.setReadingModes(new ReadingModesDto(true, true));
        volumeInfoDto.setPrintType("BOOK");
        volumeInfoDto.setMaturityRating("NOT_MATURE");
        volumeInfoDto.setAllowAnonLogging(false);
        volumeInfoDto.setContentVersion("1.0.1.0.preview.3");
        volumeInfoDto.setImageLinks(new ImageLinksDto("xxx","yyy"));
        volumeInfoDto.setLanguage("en");
        volumeInfoDto.setPreviewLink("qqq");
        volumeInfoDto.setInfoLink("www");
        volumeInfoDto.setCanonicalVolumeLink("eee");
        bookDto.setVolumeInfo(volumeInfoDto);

        SaleInfoDto saleInfoDto = new SaleInfoDto();
        saleInfoDto.setCountry("PL");
        saleInfoDto.setSaleability("NOT_FOR_SALE");
        saleInfoDto.setIsEbook(false);
        bookDto.setSaleInfo(saleInfoDto);

        SearchInfoDto searchInfoDto = new SearchInfoDto("xxx");
        bookDto.setSearchInfo(searchInfoDto);

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
        bookDto.setAccessInfo(accessInfoDto);

        Book book = BookMapper.INSTANCE.mapDtoToBook(bookDto);

        Assertions.assertEquals(book.getKind(), "books#volume");
        Assertions.assertEquals(book.getEtag(), "pfjjxSpetIM");
        Assertions.assertEquals(book.getSelfLink(), "https://www.googleapis.com/books/v1/volumes/7tkN1CYzn2cC");
        Assertions.assertEquals(book.getVolumeInfo().getTitle(), "A Hypervista of the Java Landscape");

    }
}