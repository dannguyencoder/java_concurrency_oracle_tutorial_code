package com.company.codejava.b_synchronization.a_problems_unsynchronized_code;

/**
 * TransactionTest.java
 * This is a test program that creates threads to process
 * many transactions concurrently.
 * @author www.codejava.net
 */
public class TransactionTest {
    public static void main(String[] args) {
        Bank bank = new Bank();

        for (int i = 0; i < Bank.MAX_ACCOUNT; i++) {
            Thread t = new Thread(new Transaction(bank, i));
            t.start();
        }
    }
}
