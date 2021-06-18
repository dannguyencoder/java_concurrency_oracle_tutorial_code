package com.company.codejava.b_synchronization.c_synchronized_keyword;

import com.company.codejava.b_synchronization.a_problems_unsynchronized_code.Account;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Bank.java
 * This class represents a bank that manages accounts and provides
 * money transfer function.
 * It demonstrates how to use the the synchronized keyword to serialize
 * access to methods.
 * @author www.codejava.net
 */
public class Bank {
    public static final int MAX_ACCOUNT = 10;
    public static final int MAX_AMOUNT = 200;
    public static final int INITIAL_BALANCE = 100;

    private Account[] accounts = new Account[MAX_ACCOUNT];

    public Bank() {
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(INITIAL_BALANCE);
        }
    }

    public synchronized void transfer(int from, int to, int amount) {
        try {
            while (accounts[from].getBalance() < amount) {
                wait();
            }

            accounts[from].withdraw(amount);
            accounts[to].deposit(amount);

            String message = "%s transfered %d from %s to %s. Total balance: %d\n";
            String threadName = Thread.currentThread().getName();
            System.out.printf(message, threadName, amount, from, to, getTotalBalance());

            notifyAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized int getTotalBalance() {
        int total = 0;

        for (int i = 0; i < accounts.length; i++) {
            total += accounts[i].getBalance();
        }

        return total;
    }
}
