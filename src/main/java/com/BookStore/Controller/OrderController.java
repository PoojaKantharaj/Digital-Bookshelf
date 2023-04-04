package com.BookStore.Controller;

import com.BookStore.Entities.Book;
import com.BookStore.Entities.User;
import com.BookStore.Payload.OrderDto;
import com.BookStore.Service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/onlineBookStore/app")
public class OrderController {

    private OrderService orderService;

    OrderController(OrderService orderService){
        this.orderService = orderService;
    }


    //http://localhost:9090/onlineBookStore/app/order/userId/5/bookId/4
    @PostMapping("/order/userId/{userId}/bookId/{bookId}")
    public ResponseEntity<Object> saveOrder(@RequestBody OrderDto orderDto, @PathVariable("userId") long userId, @PathVariable("bookId") long bookId){
        OrderDto dto = orderService.saveOrder(orderDto, userId, bookId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //http://localhost:9090/onlineBookStore/app/order/getOrders
    @GetMapping("/order/getOrders")
    public ResponseEntity<Object> getOrderDetails(){
        List<OrderDto> dto = orderService.getOrderDetails();
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    //http://localhost:9090/onlineBookStore/app/order/total/userId/5
    @GetMapping("order/total/userId/{userId}")
    public ResponseEntity<Object> getTotalprice(@PathVariable("userId") long userId){
        double totalPrice = orderService.getTotalPriceByUserId(userId);
        return new ResponseEntity<>(totalPrice, HttpStatus.OK);
    }

    //http://localhost:9090/onlineBookStore/app/userId/5
    @GetMapping("userId/{userId}")
    public ResponseEntity<Object> getOrderDetailsByUserId(@PathVariable("userId") long userId) {
        List<OrderDto> dto = orderService.getOrderByUserId(userId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    //http://localhost:9090/onlineBookStore/app/orderId/1
    @GetMapping("orderId/{orderId}")
    public ResponseEntity<Object> getOrderDetailsByOrderId(@PathVariable("orderId") long orderId) {
        OrderDto dto = orderService.getOrderByOrderId(orderId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
