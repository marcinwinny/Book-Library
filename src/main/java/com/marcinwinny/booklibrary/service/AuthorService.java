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

import java.util.ArrayList;
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
        List<Book> books = bookRepository.findAll();
        List<AuthorDto> authorDtos = new ArrayList<>();

        authorRepository.findAll()
                .stream()
                .forEach(author ->{
                    double average = books.stream()
                            .filter(book -> book.getVolumeInfo().getAuthors().contains(author))
                            .filter(book -> book.getVolumeInfo().getAverageRating() != null)
                            .map(Book::getVolumeInfo)
                            .mapToDouble(VolumeInfo::getAverageRating)
                            .average().orElse(0.0);
                    authorDtos.add(new AuthorDto(author.getName(), average));
                });

        return authorDtos.stream()
                .sorted(Comparator.comparingDouble(AuthorDto::getAverageRating)
                        .reversed())
                .collect(Collectors.toList());
    }
}
