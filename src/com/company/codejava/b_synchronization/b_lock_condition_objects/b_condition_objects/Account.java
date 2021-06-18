package com.company.codejava.b_synchronization.b_lock_condition_objects.b_condition_objects;

/**
 * Account.java
 * This class represents an account in the bank
 * @author www.codejava.net
 */
public class Account {
    private int balance = 0;

    public Account(int balance) {
        this.balance = balance;
    }

    public void withdraw(int amount) {
        this.balance -= amount;
    }

    public void deposit(int amount) {
        this.balance += amount;
    }

    public int getBalance() {
        return this.balance;
    }
}
