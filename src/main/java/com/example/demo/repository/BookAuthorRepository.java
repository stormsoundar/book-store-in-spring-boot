package com.example.demo.repository;

import com.example.demo.entity.BookAuthor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookAuthorRepository extends CrudRepository<BookAuthor, Long> {

    List<BookAuthor> findAllByBookId(Long bookId);
}
