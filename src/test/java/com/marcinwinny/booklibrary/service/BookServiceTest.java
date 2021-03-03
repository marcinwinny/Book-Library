package com.marcinwinny.booklibrary.service;

import com.marcinwinny.booklibrary.dto.BookDto;
import com.marcinwinny.booklibrary.model.Book;
import com.marcinwinny.booklibrary.model.volumeinfo.IndustryId;
import com.marcinwinny.booklibrary.model.volumeinfo.Type;
import com.marcinwinny.booklibrary.model.volumeinfo.VolumeInfo;
import com.marcinwinny.booklibrary.repository.BookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.doReturn;

@SpringBootTest
class BookServiceTest {

    @Autowired
    private BookService bookService;
    @MockBean
    private BookRepository bookRepository;

    VolumeInfo volumeInfo1 = VolumeInfo.builder().title("A Hypervista of the Java Landscape").publisher("InfoStrategist.com")
            .id(1L)
            .industryIdentifiers(new ArrayList<>(List.of(
                    new IndustryId(Type.ISBN_13, "9781592432172"),
                    new IndustryId(Type.ISBN_10, "1592432174"))))
            .build();
    Book book1 = Book.builder().volumeInfo(volumeInfo1).build();

    VolumeInfo volumeInfo2 = VolumeInfo.builder().title("Python for beginners").publisher("InfoStrategist.com")
            .id(2L)
            .industryIdentifiers(new ArrayList<>(List.of(
                    new IndustryId(Type.ISBN_13, "9781592432172"),
                    new IndustryId(Type.ISBN_10, "1592432174"))))
            .build();
    Book book2 = Book.builder().volumeInfo(volumeInfo2).build();

    @Test
    void getAll() {
        doReturn(Arrays.asList(book1, book2)).when(bookRepository).findAll();

        List<BookDto> books = bookService.getAll();

        Assertions.assertEquals(2, books.size());
    }
}