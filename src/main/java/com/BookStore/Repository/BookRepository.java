package com.BookStore.Repository;

import com.BookStore.Entities.Book;
import com.BookStore.Payload.BookDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByTitle(String title);
    Optional<Book> findByAuthor(String author);


}
