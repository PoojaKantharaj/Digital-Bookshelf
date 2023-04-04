package com.BookStore.Controller;

import com.BookStore.Payload.UserDto;
import com.BookStore.Repository.UserRepository;
import com.BookStore.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/onlineBookStore/app")
public class UserController {


    private UserService userService;

    UserController(UserService userService){
        this.userService = userService;
    }

    //http://localhost:9090/onlineBookStore/app
    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody UserDto userDto){
        UserDto dto = userService.registerUser(userDto);
        return new ResponseEntity<Object>(dto, HttpStatus.CREATED);
    }


}
