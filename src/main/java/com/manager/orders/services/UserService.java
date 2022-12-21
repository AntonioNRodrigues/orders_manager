package com.manager.orders.services;

import com.manager.orders.converter.UserConverter;
import com.manager.orders.models.dto.UserDto;
import com.manager.orders.models.entities.User;
import com.manager.orders.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private final Logger logger = LoggerFactory.getLogger(UserService.class);
    private final UserRepository userRepository;

    private final UserConverter userConverter;

    @Autowired
    public UserService(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }


    public UserDto getUser(String email) {
        User user = userRepository.getUserByEmail(email);
        if (user != null) {
            return userConverter.entityToDto(user);
        }
        return null;
    }

    public boolean deleteUser(String email) {
        boolean actionReturn = false;
        User user = userRepository.getUserByEmail(email);
        if (user != null) {
            userRepository.delete(user);
            actionReturn = true;
        }
        return actionReturn;
    }

    public UserDto updateUser(UserDto userDto) {
        User user = userRepository.getUserByEmail(userDto.getEmail());
        if (user != null) {
            user.setName(userDto.getName());
            user = userRepository.save(user);
            return userConverter.entityToDto(user);
        } else {
            return null;
        }
    }

    public UserDto addUser(UserDto userDto) {
        User user = userRepository.save(userConverter.dtoToEntity(userDto));
        return userConverter.entityToDto(user);

    }


}
