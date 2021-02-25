package com.marcinwinny.booklibrary.repository;

import com.marcinwinny.booklibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByIsbn13(Long id);

    Optional<Book> findByIsbn10(Long id);

}
