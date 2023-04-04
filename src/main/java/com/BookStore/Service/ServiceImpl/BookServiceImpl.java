package com.BookStore.Service.ServiceImpl;

import com.BookStore.Entities.Book;
import com.BookStore.Exception.BookNotFoundException;
import com.BookStore.Exception.ResourceNotFoundException;
import com.BookStore.Payload.BookDto;
import com.BookStore.Repository.BookRepository;
import com.BookStore.Service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.Optional;


@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    private ModelMapper modelMapper;

    BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper){
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public BookDto updateNewbooks(BookDto bookDto) {
        Book book = modelMapper.map(bookDto, Book.class);
        Book  newBook = bookRepository.save(book);
        BookDto dto = modelMapper.map(newBook, BookDto.class);
        return dto;
    }

    @Override
    public BookDto getBook(long bookId) {
        Book books = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book", "id", bookId));
        BookDto dto = modelMapper.map(books, BookDto.class);
        return dto;
    }

    @Override
    public BookDto getBookByTitle(String title) {
        Optional<Book> byTitle = Optional.ofNullable(bookRepository.findByTitle(title).orElseThrow(() -> new BookNotFoundException("Book", "title", title)));
        Book book = byTitle.get();
        return modelMapper.map(book, BookDto.class);
    }

    @Override
    public BookDto getBookByAuthor(String author) {
        Optional<Book> byAuthor = Optional.ofNullable(bookRepository.findByAuthor(author).orElseThrow(() -> new BookNotFoundException("Book", "author", author)));
        Book book = byAuthor.get();
        return modelMapper.map(book, BookDto.class);
    }

}
