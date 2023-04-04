package com.BookStore.Service;

import com.BookStore.Payload.BookDto;
import org.springframework.stereotype.Service;


public interface BookService {

    public BookDto updateNewbooks(BookDto bookDto);

    public BookDto getBook(long bookId);

    public BookDto getBookByTitle(String title);

    public BookDto getBookByAuthor(String author);

}


