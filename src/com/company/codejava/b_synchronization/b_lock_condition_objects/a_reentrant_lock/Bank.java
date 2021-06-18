package com.company.codejava.b_synchronization.b_lock_condition_objects.a_reentrant_lock;

import com.company.codejava.b_synchronization.a_problems_unsynchronized_code.Account;

import java.util.concurrent.locks.*;

/**
 * Bank.java
 * This class represents a bank that manages accounts and provides
 * money transfer function.
 * It demonstrates how to use the locking mechanism with a ReentrantLock object.
 * @author www.codejava.net
 */
public class Bank {
    public static final int MAX_ACCOUNT = 10;
    public static final int MAX_AMOUNT = 10;
    public static final int INITIAL_BALANCE = 100;

    private Account[] accounts = new Account[MAX_ACCOUNT];

    private Lock bankLock;

    public Bank() {
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(INITIAL_BALANCE);
        }

        bankLock = new ReentrantLock();
    }

    public void transfer(int from, int to, int amount) {
        bankLock.lock();

        try {
            if (amount <= accounts[from].getBalance()) {
                accounts[from].withdraw(amount);
                accounts[to].deposit(amount);

                String message = "%s transfered %d from %s to %s. Total balance: %d\n";
                String threadName = Thread.currentThread().getName();
                System.out.printf(message, threadName, amount, from, to, getTotalBalance());
            }
        } finally {
            bankLock.unlock();
        }
    }

    public int getTotalBalance() {
        bankLock.lock();

        try {
            int total = 0;

            for (int i = 0; i < accounts.length; i++) {
                total += accounts[i].getBalance();
            }

            return total;
        } finally {
            bankLock.unlock();
        }
    }
}
