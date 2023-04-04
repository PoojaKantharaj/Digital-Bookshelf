package com.BookStore.Controller;

import com.BookStore.Payload.BookDto;
import com.BookStore.Service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/onlineBookStore/app")
public class BookController {


    private BookService bookService;

    BookController(BookService bookService ){
        this.bookService = bookService;
    }


    //http://localhost:9090/onlineBookStore/app/books/newEdition
    @PostMapping("/books/newEdition")
    public ResponseEntity<Object> addBooks(@RequestBody BookDto bookDto){
        BookDto dto = bookService.updateNewbooks(bookDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Object> getBook(@PathVariable("id") long bookId){
        BookDto dto = bookService.getBook(bookId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    //http://localhost:9090/onlineBookStore/app/books/title/The Alchemist
    @GetMapping("/books/title/{title}")
    public ResponseEntity<Object> getBookByTitle(@PathVariable("title") String title){
        BookDto dto = bookService.getBookByTitle(title);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    //http://localhost:9090/onlineBookStore/app/books/author/Paulo Coelho
    @GetMapping("/books/author/{author}")
    public ResponseEntity<Object> getBookByAuthor(@PathVariable("author") String author){
        BookDto dto = bookService.getBookByAuthor(author);
        return new ResponseEntity<Object>(dto, HttpStatus.OK);
    }
}
