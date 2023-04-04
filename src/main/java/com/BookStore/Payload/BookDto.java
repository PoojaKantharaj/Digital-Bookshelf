package com.BookStore.Payload;

import com.BookStore.Entities.Order;
import lombok.Data;


import java.util.List;

@Data
public class BookDto {

    private Long id;

    private String title;

    private String author;

    private String price;

   /* private List<Order> orders; */
}
