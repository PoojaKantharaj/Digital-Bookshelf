package com.BookStore.Payload;

import com.BookStore.Entities.Book;
import com.BookStore.Entities.User;
import lombok.Data;


@Data
public class OrderDto {


    private Long id;

    private User user;

    private Book book;

    private int quantity;

}
