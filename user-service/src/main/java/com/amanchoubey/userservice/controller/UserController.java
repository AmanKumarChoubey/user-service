package com.amanchoubey.userservice.controller;

import com.amanchoubey.userservice.model.UserRequest;
import com.amanchoubey.userservice.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private UserService userService;
    @PostMapping("/users")
    public void createUser(@RequestBody UserRequest userRequest){
        userService.saveUser(userRequest);
    }
}
