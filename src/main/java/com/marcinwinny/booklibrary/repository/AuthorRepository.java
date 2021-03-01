package com.marcinwinny.booklibrary.repository;

import com.marcinwinny.booklibrary.model.volumeinfo.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
