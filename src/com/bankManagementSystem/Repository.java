package com.bankManagementSystem;

import java.util.*;

public class Repository {

    Customer customer = new Customer();
    List<Customer> customers = new ArrayList<>();

    public String addUser(Customer user){
        customers.add(user);
        return "Account created successfully";
    }


    public boolean verifyCredentials(String email, String password){
        for (int i=0; i<customers.size(); i++){
            if(customers.get(i).getEmail().trim().equals(email.trim()) && customers.get(i).getPassword().trim().equals(password.trim())){
                return true;
            }
        }
        return false;
    }

    public Account getAccountDetails(Customer currentCustomer){

        return currentCustomer.getAccountDetails();

    }

    public String depositAmount(Customer currentCustomer, double amountToDeposti){

        return currentCustomer.getAccountDetails().depositAmount(amountToDeposti);
    }

    public String withdrawAmount(Customer currentCustomer, double amountToWithdraw){
        return currentCustomer.getAccountDetails().withdrawAmount(amountToWithdraw);
    }

    public String transferMoney(Customer currentCustomer, String destinationEmail, double amountToTransfer){

        Optional <Customer> destinationCust = customers.stream().filter(customer -> {
            return customer.getEmail().equals(destinationEmail);
        }).findFirst();

        Customer destinationCustomer = destinationCust.get();
        depositAmount(destinationCustomer,amountToTransfer);
        withdrawAmount(currentCustomer,amountToTransfer);
        return "Amount of "+amountToTransfer+" has been transferred form "+currentCustomer.getName()+"'s account to "+destinationCustomer.getName()+"'s account.";
    }

    public List<String> getTransactionHistory(Customer customer){
              List<String> transactions = customer.getAccountDetails().getTransactions();
        return transactions;
    }
}

