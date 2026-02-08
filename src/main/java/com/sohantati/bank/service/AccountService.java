package com.sohantati.bank.service;

import com.sohantati.bank.model.Account;
import com.sohantati.bank.model.Transaction;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

public class AccountService {
    private Map<Long, Account> accounts = new HashMap<>();
    private List<Transaction> transactions = new ArrayList<>();

    public void createAccount(Long userID){
        accounts.put(userID, new Account(userID, 0.0));
    }

    public Account getAccount(Long userID){
        return accounts.get(userID);
    }

    public void deposit(Long userId, double amount) {
        Account account = accounts.get(userId);
        if (account == null) {
            throw new RuntimeException("Account not found.");
        }

        account.setBalance(account.getBalance() + amount);
    }

    public List<Transaction> getTransactions() {
        return this.transactions;
    }

    public Transaction transfer(Long fromUser, Long toUser, double amount) {
        Account fromAccount = accounts.get(fromUser);
        Account toAccount = accounts.get(toUser);

        if (fromAccount.getBalance() < amount) {
            throw new RuntimeException("Insufficient Funds");
        }

        fromAccount.setBalance(fromAccount.getBalance()-amount);
        toAccount.setBalance(toAccount.getBalance()+amount);

        Transaction tx = new Transaction(fromUser, toUser, amount);
        transactions.add(tx);

        return tx;
    }


}
