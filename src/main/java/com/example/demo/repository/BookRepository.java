package com.example.demo.repository;

import com.example.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
//      Optional<Book> findById(Long bookId);
   // Book findById(Long bookId);

//    List<Book> findAllByYearOfPublication(Integer yop);
//    List<Book> findAllByYearOfPublicationIn(Set<Integer> yop);

    List<Book> findAllByYearOfPublicationInAndBookType(Set<Integer> yop, String bookType);

    // native query method 1
//    String rawQuery = "select * from book where year_of_publication IN ?1";
//
//    @Query(nativeQuery = true, value = rawQuery)
//    List<Book> findAllByYearOfPublicationIn(Set<Integer> yop);

    // native query method 2
    String rawQuery = "select * from book where year_of_publication IN :yop";

    @Query(nativeQuery = true, value = rawQuery)
    List<Book> findAllByYearOfPublicationIn(@Param("yop") Set<Integer> yop);



//    Book delete(Integer bookId);


//    Book deleteById(Integer bookId);


    // Save to db

    // Update

    // Fetch

    //Delete
}
