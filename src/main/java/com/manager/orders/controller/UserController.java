package com.manager.orders.controller;

import com.manager.orders.models.dto.UserDto;
import com.manager.orders.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/user/{email}")
    public UserDto getUser(@PathVariable String email) {
        return userService.getUser(email);
    }

    @PostMapping(path = "/user", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UserDto addUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }

    @DeleteMapping(path = "/user/{email}")
    public Boolean deleteUser(@PathVariable String email) {
        return userService.deleteUser(email);
    }

    @PutMapping(path = "/user", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UserDto updateUser(@RequestBody UserDto userDto) {
        return userService.updateUser(userDto);
    }


}
