package com.BookStore.Service.ServiceImpl;

import com.BookStore.Entities.Book;
import com.BookStore.Entities.Order;
import com.BookStore.Entities.User;
import com.BookStore.Exception.ResourceNotFoundException;
import com.BookStore.Payload.OrderDto;
import com.BookStore.Repository.BookRepository;
import com.BookStore.Repository.OrderRepository;
import com.BookStore.Repository.UserRepository;
import com.BookStore.Service.OrderService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    private BookRepository bookRepository;

    OrderServiceImpl(OrderRepository orderRepository, ModelMapper modelMapper, UserRepository userRepository, BookRepository bookRepository){
        this.orderRepository = orderRepository;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public OrderDto saveOrder(OrderDto orderDto, long userId, long bookId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        Order order = new Order();
        order.setUser(user);
        order.setBook(book);
        order.setQuantity(orderDto.getQuantity());
        Order newOrder = orderRepository.save(order);

        /*Order order = modelMapper.map(orderDto, Order.class);
        Optional<User> user = Optional.ofNullable(userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "userId", userId)));
        User user1 = user.get();
        order.setUser(user1);
        Optional<Book> book = Optional.ofNullable(bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("book", "bookId", bookId)));
        Book book1 = book.get();
        order.setBook(book1);
        Order newOrder = orderRepository.save(order);*/
        return modelMapper.map(newOrder, OrderDto.class);
        }

/*    @Override
    public List<OrderDto> getOrderDetails() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order : orders) {
            OrderDto dto = modelMapper.map(order, OrderDto.class);
            orderDtos.add(dto);
        }
        return orderDtos;
    }*/

    @Override
    public List<OrderDto> getOrderDetails() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order : orders) {
            OrderDto orderDto = new OrderDto();
            orderDto.setId(order.getId());
            orderDto.setUser(order.getUser());
            orderDto.setBook(order.getBook());
            orderDto.setQuantity(order.getQuantity());
            OrderDto dto = modelMapper.map(orders, OrderDto.class);
            orderDtos.add(dto);
        }
        return orderDtos;
    }

    @Override
    public double getTotalPriceByUserId(Long userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
        double totalPrice = 0.0;
        for (Order order : orders) {
            totalPrice += order.getQuantity() * Integer.parseInt(order.getBook().getPrice());
        }
        return totalPrice;
    }

    @Override
    public List<OrderDto> getOrderByUserId(Long userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
        List<OrderDto> orderDtos = new ArrayList<>();
        for (Order order : orders) {
            OrderDto dto = modelMapper.map(orders, OrderDto.class);
            orderDtos.add(dto);
        }
        return orderDtos;
    }

    @Override
    public OrderDto getOrderByOrderId(Long orderId) {
        Optional<Order> order = orderRepository.findById(orderId);
        Order order1 = order.get();
        OrderDto dto = modelMapper.map(order1, OrderDto.class);
        return dto;
    }


}
