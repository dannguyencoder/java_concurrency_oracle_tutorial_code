package com.company.codejava.b_synchronization.d_deadlock_livelock_starvation.a_deadlock;

/**
 * BusinessTest2.java
 * This program tests for deadlock situtation.
 * @author www.codejava.net
 */
public class BusinessTest2 {
    public static void main(String[] args) {
        Business business = new Business();

        for (int i = 0; i < 100000; i++) {
            new Thread(new Runnable() {
                public void run() {
                    business.foo();
                }
            }).start();
        }

        for (int i = 0; i < 100000; i++) {
            new Thread(new Runnable() {
                public void run() {
                    business.bar();
                }
            }).start();
        }
    }
}
