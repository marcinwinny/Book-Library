package com.marcinwinny.booklibrary.controller;

import com.marcinwinny.booklibrary.dto.BookDto;
import com.marcinwinny.booklibrary.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //get a book by ISBN_10 or ISBN13 depending on length of variable
    @GetMapping("/by-isbn/{isbn}")
    public void getBookByIsbn(@PathVariable Long isbn) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getByIsbn(isbn));
    }

    //return all books that are assigned to the requested category
    @GetMapping("/by-category/{category}")
    public ResponseEntity<List<BookDto>> getAllBooksByCategory(@PathVariable String category) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllByCategory(category));

    }

    @GetMapping("/pages-greater-than/{pages}")
    public ResponseEntity<BookDto> getFirstBookWithMorePagesThan(@PathVariable Long pages) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getFirstWithPagesMoreThan(pages));
    }

}
