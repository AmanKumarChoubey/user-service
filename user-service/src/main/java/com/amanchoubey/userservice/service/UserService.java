package com.amanchoubey.userservice.service;

import com.amanchoubey.userservice.entity.User;
import com.amanchoubey.userservice.model.UserRequest;
import com.amanchoubey.userservice.model.UserResponse;
import com.amanchoubey.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    public User saveUser(UserRequest userRequest) {
//        Now, i save user request to DB
        User user = new User(userRequest.email(), userRequest.name());
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public UserResponse getUserById(long id) {
        Optional<User> data = userRepository.findById(id);
        User user=null;
        if(data.isPresent()){
            user=data.get();
        }
        UserResponse userResponse=new UserResponse(user.getId(),user.getName(),user.getEmail());
        return userResponse;
    }
}
