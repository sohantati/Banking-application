package com.sohantati.bank.service;

import com.sohantati.bank.model.User;
import com.sohantati.bank.model.Account;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong; // for generating unique IDs


public class UserService {
    private List<User> users = new ArrayList<>();
    private AtomicLong idCounter = new AtomicLong(1); // every new user gets next ID

    public User register(User user) {
        User new_u = new User (
                idCounter.getAndIncrement(),
                user.getEmail(),
                user.getPassword()
        );
        users.add(new_u);
        return new_u;
    }

    public User login(User loginRequest){
        for (User user: users) {
            if (user.getEmail().equals(loginRequest.getEmail())
                    && user.getPassword().equals(loginRequest.getPassword())) {
                return user;
            }
        }
        throw new RuntimeException("Invalid credentials");
    }

    public List<User> getUsers(){
        return this.users;
    }
}
