package com.bankManagementSystem;

import java.util.Date;

public class Transactions {

    private static int counter = 1;
    private int transactionId;
    private double amount;
    private String transactionType;
    private Date timeStamp;

    public Transactions() {
    }

    public Transactions(double amount, String transactionType) {
        this.transactionId = counter++;
        this.amount = amount;
        this.transactionType = transactionType;
        this.timeStamp = new Date();
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        Transactions.counter = counter;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "ID: "+transactionId +" || "+ amount +" "+ transactionType +" ON "+ timeStamp;
    }
}
