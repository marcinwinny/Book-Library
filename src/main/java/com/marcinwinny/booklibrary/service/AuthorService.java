package com.marcinwinny.booklibrary.service;

import com.marcinwinny.booklibrary.dto.volumeinfodto.AuthorDto;
import com.marcinwinny.booklibrary.model.Book;
import com.marcinwinny.booklibrary.model.volumeinfo.Author;
import com.marcinwinny.booklibrary.model.volumeinfo.VolumeInfo;
import com.marcinwinny.booklibrary.repository.AuthorRepository;
import com.marcinwinny.booklibrary.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public List<Author> getAll() {
        return authorRepository.findAll();
    }

    public List<AuthorDto> getAllWithRatings() {
        List<Book> bookList = bookRepository.findAll();
        List<Author> authorList = authorRepository.findAll();
        return authorList.stream()
                .map(author -> groupBooksByAuthor(author, bookList))
                .sorted(Comparator.comparingDouble(AuthorDto::getAverageRating).reversed())
                .collect(Collectors.toList());
    }

    private AuthorDto groupBooksByAuthor(Author author, List<Book> bookList) {
        double average;
        average = bookList.stream()
                .map(Book::getVolumeInfo)
                .filter(volumeInfo -> volumeInfo.getAuthors().contains(author))
                .filter(volumeInfo -> volumeInfo.getAverageRating() != null)
                .mapToDouble(VolumeInfo::getAverageRating)
                .average().orElse(0.0);

        return AuthorDto.builder()
                .id(author.getId())
                .name(author.getName())
                .averageRating(average)
                .build();
    }
}
