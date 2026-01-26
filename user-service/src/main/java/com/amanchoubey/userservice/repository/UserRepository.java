package com.amanchoubey.userservice.repository;

import com.amanchoubey.userservice.entity.User;
import com.amanchoubey.userservice.model.UserRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
//    By extending to JPA we get save, delete, update all those db based method
}
