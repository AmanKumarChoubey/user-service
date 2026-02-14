package com.amanchoubey.userservice.controller;

import com.amanchoubey.userservice.entity.User;
import com.amanchoubey.userservice.model.UserRequest;
import com.amanchoubey.userservice.model.UserResponse;
import com.amanchoubey.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
   public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest){
        User user=userService.saveUser(userRequest);
        UserResponse userResponse=new UserResponse(user.getId(),user.getName(),user.getEmail());
//        return ResponseEntity.ok(userResponse);  //Now i am returing a DTO for UserResponse object DTo :- Data Transfer Object
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponse);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable long id){
        UserResponse userResponse=userService.getUserById(id);
//        return ResponseEntity.ok(userResponse);
        return ResponseEntity.status(HttpStatus.OK).body(userResponse);
    }
}
