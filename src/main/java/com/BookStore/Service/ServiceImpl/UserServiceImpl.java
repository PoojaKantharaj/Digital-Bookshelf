package com.BookStore.Service.ServiceImpl;

import com.BookStore.Entities.User;
import com.BookStore.Payload.UserDto;
import com.BookStore.Repository.UserRepository;
import com.BookStore.Service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper){
      this.modelMapper = modelMapper;
      this.userRepository = userRepository;
    }


    @Override
    public UserDto registerUser(UserDto userDto) {
        User newUser = modelMapper.map(userDto, User.class);
        User user = userRepository.save(newUser);
        UserDto Dto = modelMapper.map(user, UserDto.class);
        return Dto;
    }
}
