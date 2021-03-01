package com.marcinwinny.booklibrary.service;

import com.marcinwinny.booklibrary.dto.BookDto;
import com.marcinwinny.booklibrary.exception.BookNotFoundException;
import com.marcinwinny.booklibrary.mapper.BookMapper;
import com.marcinwinny.booklibrary.model.Book;
import com.marcinwinny.booklibrary.model.volumeinfo.Author;
import com.marcinwinny.booklibrary.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public List<BookDto> getAll() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::mapBookToDto)
                .collect(Collectors.toList());
    }

    public List<BookDto> getAllByCategory(String category) {
        return bookRepository.findAll()
                .stream()
                .filter(book -> book.getVolumeInfo().getCategories().stream()
                        .anyMatch(cat -> cat.equals(category)))
                .map(bookMapper::mapBookToDto)
                .collect(Collectors.toList());

    }

    //TODO: Make it more rebust if there is any???
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

    public Object getByIsbn(Long isbn) {
        int isbnLength = isbn.toString().length();
        if (isbnLength == 13) {

        }
        else if (isbnLength == 10){

        }
    }
}
