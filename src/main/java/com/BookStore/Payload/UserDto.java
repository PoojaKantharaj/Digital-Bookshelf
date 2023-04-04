package com.BookStore.Payload;

import com.BookStore.Entities.Order;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private Long id;

    private String name;

    private String email;

    private String mobile;

    private List<Order> orders;
}
