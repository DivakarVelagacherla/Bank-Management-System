package com.bankManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    private static int customerIdCounter = 1;
    private int customerId;
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private Account accountDetails;

    public Customer() {
    }

    public Customer(String name, String email, String phoneNumber, String password, Account account) {
        this.customerId = customerIdCounter++;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.accountDetails = account;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account getAccountDetails() {
        return this.accountDetails;
    }

    public void setAccountDetails(Account accountDetails) {
        this.accountDetails = accountDetails;
    }

    public String createAccount(){

        return "";
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", accountDetails=" + accountDetails +
                '}';
    }
}
