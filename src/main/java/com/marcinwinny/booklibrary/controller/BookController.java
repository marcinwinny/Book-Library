package com.marcinwinny.booklibrary.controller;

import com.marcinwinny.booklibrary.dto.BookDto;
import com.marcinwinny.booklibrary.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/books/")
public class BookController {

    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAll());
    }

    //get a book details by ISBN_10 or ISBN13
    @GetMapping("/by-isbn/{isbn}")
    public ResponseEntity<BookDto> getBookByIsbn(@PathVariable String isbn) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getByIsbn(isbn));
    }

    //get all books that are assigned to the requested category
    @GetMapping("/by-category/{category}")
    public ResponseEntity<List<BookDto>> getAllBooksByCategory(@PathVariable String category) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllByCategory(category));
    }

    //get first book with number of pages greater than
    @GetMapping("/pages-greater-than/{pages}")
    public ResponseEntity<BookDto> getFirstBookWithMorePagesThan(@PathVariable Long pages) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getFirstWithPagesMoreThan(pages));
    }

    //get list of books based on reading statistics
    @GetMapping("/best-books/{howManyPages}/{howManyHours}")
    public ResponseEntity<List<BookDto>> getBestBooks(@PathVariable Integer howManyPages, @PathVariable Integer howManyHours) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBestBooksToReadInMonth(howManyPages, howManyHours));
    }

    //get five recently viewed books
    @GetMapping("/recently-viewed")
    public ResponseEntity<Collection<BookDto>> getFiveRecentlyViewed() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getRecentlyViewed());
    }
}
