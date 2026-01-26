package com.amanchoubey.userservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {
    //    This class will get map to my database columns
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String email;

    public User() {
    }
    public User(String name,String email) {
        this.name=name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
