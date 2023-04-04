package com.BookStore.Service;

import com.BookStore.Payload.OrderDto;

import java.util.List;

public interface OrderService {

    public OrderDto saveOrder(OrderDto orderDto, long userId, long bookId);

    public List<OrderDto> getOrderDetails();

    public double getTotalPriceByUserId(Long userId);

    public List<OrderDto> getOrderByUserId(Long userId);

    public OrderDto getOrderByOrderId(Long orderId);

}
