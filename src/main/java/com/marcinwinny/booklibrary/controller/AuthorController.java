package com.marcinwinny.booklibrary.controller;

import com.marcinwinny.booklibrary.dto.volumeinfodto.AuthorDto;
import com.marcinwinny.booklibrary.model.volumeinfo.Author;
import com.marcinwinny.booklibrary.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/authors/")
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping("/ratings")
    public ResponseEntity<List<AuthorDto>> getAllAuthorsWithRatings() {
        return ResponseEntity.status(HttpStatus.OK).body(authorService.getAllWithRatings());
    }

 }
