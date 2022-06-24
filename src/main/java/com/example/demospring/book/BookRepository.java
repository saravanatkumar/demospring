package com.example.demospring.book;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findAllByOrderByNameAsc();

    List<Book> findAllByNameContainsIgnoreCaseOrAuthorNameContainsIgnoreCaseOrderByNameAsc(String bookOrAuthorName, String bookOrAuthorName1);
}
