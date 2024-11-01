package com.bankManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Account {

    private static long counter = 1284787253L;
    private long accountNumber;
    private double balance;
    private String accountType;
    private List<String> transactions;

    public Account() {
    }

    public Account(double balance, String accountType) {
        this.accountNumber = counter++;
        this.balance = balance;
        this.accountType = accountType;
        this.transactions = new ArrayList<>();
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public List<String> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return  "AccountNumber=" + accountNumber +
                "\nBalance=" + balance +
                "\nAccountType=" + accountType;
    }

    public String depositAmount(double amount){
        this.balance += amount;
        transactions.add(new Transactions(amount,"Deposited").toString());
        return "Amount deposited.";
    }

    public String withdrawAmount(double amount){
        if(amount>this.balance){
            return "Insufficient Balance";
        }else{
            this.balance -= amount;
            transactions.add(new Transactions(amount,"Withdrawn").toString());
            return "Amount withdrawn.";
        }
    }

    public String transferMoney(){
        return "";
    }


}
