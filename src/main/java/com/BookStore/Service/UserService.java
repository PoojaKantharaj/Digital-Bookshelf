package com.BookStore.Service;

import com.BookStore.Payload.UserDto;
import org.springframework.stereotype.Service;

public interface UserService {

    public UserDto registerUser(UserDto userDto);
}
