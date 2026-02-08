package com.sohantati.bank.controller;

import com.sohantati.bank.model.User;
import com.sohantati.bank.model.Account;
import com.sohantati.bank.service.AccountService;
import com.sohantati.bank.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import com.sohantati.bank.model.Account;
import java.util.HashMap;
import java.util.Map;

import com.sohantati.bank.model.Transaction;



@RestController  // meaning this class handles HTTP requests, every method becomes an API endpoint
@RequestMapping("/api/auth") // adds prefix to all routes, ex: /register -> /api/auth/register etc...
@CrossOrigin(origins = "*")


public class AuthController {
    private UserService userService = new UserService();
    private AccountService accountService = new AccountService();

    @PostMapping("/register") // responds to HTTP POST
    public User register(@RequestBody User user) {
        User newUser =  userService.register(user);
        accountService.createAccount(newUser.getId());
        return newUser;
    }

    @PostMapping("/login")
    public User login(@RequestBody User loginRequest){
        return userService.login(loginRequest);
    }

    @GetMapping("/users")
    public List<User> getUsers(){ return userService.getUsers(); }

    @GetMapping("/balance/{userID}")
    public Account getBalance(@PathVariable long userID) {
        return accountService.getAccount(userID);
    }

    @PostMapping("/deposit/{userID}")
    public Account deposit(@PathVariable Long userID, @RequestBody Map<String, Double>body) {

        accountService.deposit(userID, body.get("amount"));
        return accountService.getAccount(userID); // return the updated account
    }

    @PostMapping("/transfer")
    public Transaction transfer(@RequestBody Map<String, Double> body) {
        Long fromUser = body.get("fromUser").longValue();
        Long toUser = body.get("toUser").longValue();
        double amount = body.get("amount");
        return accountService.transfer(fromUser, toUser, amount);
    }

    @GetMapping("/transactions")
    public List<Transaction> getTransactions(){ return accountService.getTransactions(); }
}
