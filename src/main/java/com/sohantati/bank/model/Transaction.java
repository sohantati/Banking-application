package com.sohantati.bank.model;

import java.time.LocalDateTime;

public class Transaction {
    private Long fromUserID;
    private Long toUserID;
    private double amount;
    private LocalDateTime timestamp;

    public Transaction(){}

    public Transaction(Long fromUserID, Long toUserID, double amount){
        this.fromUserID = fromUserID;
        this.toUserID = toUserID;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    public Long getFromUserId() {
        return fromUserID;
    }

    public Long getToUserId() {
        return toUserID;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
