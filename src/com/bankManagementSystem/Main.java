package com.bankManagementSystem;

import java.io.StringBufferInputStream;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Repository repo = new Repository();
    public static Customer currentCustomer;
    public static void main(String[] args) {

        boolean loop = true;
        while(loop){
//            initiating landing page
            System.out.println("Welcome to Bank Management System\n\n1.Login\n2.Create a New Account\n3.Exit");
            int option = sc.nextInt();
            sc.nextLine();
            switch (option){
                case 1:{
//                    Login code
                    System.out.println("Enter your email");
                    StringBuilder email = new StringBuilder(sc.next());
                    sc.nextLine();
                    while(!email.toString().endsWith("@gmail.com")){
                        System.out.println("Email should end with @gmail.com\nEnter your email again");
                        email.setLength(0);
                        email.append(sc.next());
                    }

                    System.out.println("Enter your password: ");
                    String password = sc.nextLine();
//                    verifying credentials
                    if(repo.verifyCredentials(email.toString(),password)){
                        System.out.println("Logging in");
                        currentCustomer = repo.customers.stream()
                                .filter(customer -> customer.getEmail().equals(email.toString()))
                                .findFirst()
                                .orElseGet(() -> {
                                    System.out.println("Customer not available");
                                        return null;
                                });
//                        fetching login page if credentials are valid
                        loggedIn();
                    }else{
                        System.out.println("credentials wrong");
                    }
                    break;
                }
                case 2:{
//                    creating a new account
                    System.out.print("Enter your name:");
                    String name = sc.nextLine();
                    String accountType = null;
                    boolean accountTypeLoop = true;
//                    checking account type input doesn't mismatch
                    while(accountTypeLoop){
                        System.out.print("Account type[Savings/Checking]: S/C");
                        char accountTypeChar  = sc.nextLine().charAt(0);
                        if (accountTypeChar == 'S' || accountTypeChar == 's'){
                            accountType = "Savings";
                            accountTypeLoop = false;
                        }else if (accountTypeChar == 'C' || accountTypeChar == 'c'){
                            accountType = "Checking";
                            accountTypeLoop = false;
                        }else{
                            System.out.println("Invalid Account Type: ");
                            System.out.println("Enter 'S' for Savings account or 'C' for Checking account");
                        }
                    }
                    System.out.print("Enter your email: ");
                    StringBuilder email = new StringBuilder(sc.next());
                    sc.nextLine();
                    while(!email.toString().endsWith("@gmail.com")){
                        System.out.println("Email should end with @gmail.com\nEnter your email again: ");
                        email.setLength(0);
                        email.append(sc.next());
                        sc.nextLine();
                    }
                    System.out.print("Enter your phno: ");
                    String phoneNumber = sc.nextLine();
                    System.out.print("Enter a password: ");
                    String password = sc.nextLine();

//                    creating a new account
                    Account account = new Account(0.0,accountType);
//                    creating a new customer and assigning account
                    Customer user = new Customer(
                            name,email.toString(),phoneNumber,password,account
                    );
//                    adding the customer to the repo
                    System.out.println(repo.addUser(user));
                    break;
                }
                case 3:
                    loop = false;
                    break;
                default:
                    System.out.println("Wrong option chose");
                    break;
            }

        }
    }

    private static void loggedIn() {
        System.out.println("1.View account details\n2.Deposit money\n3.Withdraw money\n4.Transfer money\n5.View transaction history\n6.Logout");
        int option = sc.nextInt();
        switch (option){
            case 1:
//                View Account Details
                System.out.println(repo.getAccountDetails(currentCustomer));
                loggedIn();
                break;
            case 2:
//                Deposit Money
                double amountToDeposit;
                do{
                    System.out.println("Enter amount to deposit");
                    amountToDeposit = sc.nextDouble();
                }while(amountToDeposit<=0);
                System.out.println(repo.depositAmount(currentCustomer, amountToDeposit));
                loggedIn();
                break;
            case 3:
//                Withdraw money
                System.out.println("Enter amount to withdraw");
                double amountToWithdraw = sc.nextDouble();
                System.out.println(repo.withdrawAmount(currentCustomer, amountToWithdraw));
                loggedIn();
                break;
            case 4:
//              transfer money using email id
                System.out.print("Enter destination email id: ");
                sc.nextLine();
                String destinationEmail = sc.nextLine();
                System.out.print("Enter amount to Transfer: ");
                double amountToTransfer = sc.nextDouble();
                sc.nextLine();
                System.out.println(repo.transferMoney(currentCustomer, destinationEmail, amountToTransfer));
                loggedIn();
                break;
            case 5:
//                Transaction History
                System.out.println(repo.getTransactionHistory(currentCustomer));
                break;
            default:
                System.out.println("Unexpected Error\nMust have chose wrong option");
                break;

        }

    }

}