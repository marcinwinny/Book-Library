package com.marcinwinny.booklibrary.service;

import com.google.common.cache.LoadingCache;
import com.marcinwinny.booklibrary.dto.BookDto;
import com.marcinwinny.booklibrary.exception.BookNotFoundException;
import com.marcinwinny.booklibrary.mapper.BookMapper;
import com.marcinwinny.booklibrary.model.Book;
import com.marcinwinny.booklibrary.model.volumeinfo.Author;
import com.marcinwinny.booklibrary.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
//@AllArgsConstructor
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private LoadingCache<Long, BookDto> cache;

    private BookMapper bookMapper = BookMapper.INSTANCE;

    public List<BookDto> getAll() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::mapBookToDto)
                .collect(Collectors.toList());
    }

    public BookDto getByIsbn(String isbn) {
        int isbnLength = isbn.length();
        Book book = bookRepository.findByVolumeInfo_IndustryIdentifiers_Identifier(isbn)
                .orElseThrow(() -> new BookNotFoundException("Book not found"));
        BookDto bookDto = bookMapper.mapBookToDto(book);
        Long genId = bookDto.getGenId();
        cache.put(genId, bookDto);
        return bookDto;
    }

    public List<BookDto> getAllByCategory(String category) {
        return bookRepository.findAll()
                .stream()
                .filter(book -> book.getVolumeInfo().getCategories().stream()
                        .anyMatch(cat -> cat.equals(category)))
                .map(bookMapper::mapBookToDto)
                .collect(Collectors.toList());
    }

    public BookDto getFirstWithPagesMoreThan(Long pages) {
        Book book = bookRepository.findAll()
                .stream()
                .filter(bk -> bk.getVolumeInfo().getPageCount() != null)
                .filter(bk -> bk.getVolumeInfo().getPageCount() > pages)
                .findFirst()
                .orElseThrow(() -> new BookNotFoundException("Book not found"));
        return bookMapper.mapBookToDto(book);
    }

    public List<BookDto> findAllByAuthor(Author author) {
        return bookRepository.findAll()
                .stream()
                .filter(book -> book.getVolumeInfo().getAuthors().contains(author))
                .map(bookMapper::mapBookToDto)
                .collect(Collectors.toList());
    }

    //TODO: REVERSE ORDER
    public List<BookDto> getBestBooksToReadInMonth(Integer howManyPages, Integer howManyHours) {
        int daysInMonth = 30;
        int pagesInMonth = howManyPages * howManyHours * daysInMonth;

        return bookRepository.findAll().stream()
                .filter(book -> book.getVolumeInfo().getPageCount() != null)
                .filter(book -> book.getVolumeInfo().getPageCount() >= pagesInMonth)
//                .sorted(Comparator.comparingDouble(Book::getVolumeInfo::getAverageRating))
                .map(bookMapper::mapBookToDto)
                .collect(Collectors.toList());
    }

    public Collection<BookDto> getRecentlyViewed() {
        return cache.asMap().values();
    }

    public BookDto getById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id= " + id));
        return bookMapper.mapBookToDto(book);
    }
}

