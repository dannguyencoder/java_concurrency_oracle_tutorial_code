package com.company.codejava.b_synchronization.c_synchronized_keyword;


/**
 * Transaction.java
 * This class represents a transaction task that can be executed by a thread.
 * @author www.codejava.net
 */
public class Transaction implements Runnable {
    private Bank bank;
    private int fromAccount;

    public Transaction(Bank bank, int fromAccount) {
        this.bank = bank;


        this.fromAccount = fromAccount;
    }

    public void run() {

        while (true) {
            int toAccount = (int) (Math.random() * Bank.MAX_ACCOUNT);

            if (toAccount == fromAccount) continue;

            int amount = (int) (Math.random() * Bank.MAX_AMOUNT);

            if (amount == 0) continue;

            bank.transfer(fromAccount, toAccount, amount);

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}