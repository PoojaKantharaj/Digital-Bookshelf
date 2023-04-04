package com.BookStore.Repository;

import com.BookStore.Entities.Book;
import com.BookStore.Entities.Order;
import com.BookStore.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUser(User user);

    List<Order> findByBook(Book book);

    List<Order> findByUserId(Long userId);
}
