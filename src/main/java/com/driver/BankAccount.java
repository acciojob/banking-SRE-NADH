package com.driver;

import java.util.Random;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name = name;
        this.balance = balance;
        this.minBalance=minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        if(sum<0 || digits*9<sum){
            throw new Exception("Account Number can not be generated");
        }
    String accNo="";
        int checkno=-1;
        Random rand = new Random();
        while(checkno!=sum) {
            int tmpSum =sum;
            accNo="";
            checkno=0;
            for (int i = 0; i < digits; i++) {
                int m = Math.min(sum + 1, 10);
                int n = rand.nextInt(m);
                accNo += String.valueOf(n);
                checkno+=n;
                tmpSum -= n;
            }
        }
        return accNo;
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
    }

    public void deposit(double amount) {
        balance+=amount;
        //add amount to balance

    }

    public void withdraw(double amount) throws Exception {
        if(balance-amount<minBalance){
            throw new Exception("Insufficient Balance");
        }
        balance-=amount;
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }
}