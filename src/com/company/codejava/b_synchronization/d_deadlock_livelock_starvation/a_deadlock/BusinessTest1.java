package com.company.codejava.b_synchronization.d_deadlock_livelock_starvation.a_deadlock;

/**
 * BusinessTest1.java
 * This program tests for deadlock situtation.
 * @author www.codejava.net
 */
public class BusinessTest1 {
    public static void main(String[] args) {
        Business business = new Business();

        Thread t1 = new Thread(new Runnable() {
            public void run() {
                business.foo();
            }
        });

        t1.start();

        Thread t2 = new Thread(new Runnable() {
            public void run() {
                business.bar();
            }
        });

        t2.start();
    }
}
