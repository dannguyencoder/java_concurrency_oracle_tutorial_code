package com.company.codejava.b_synchronization.d_deadlock_livelock_starvation.c_starvation;

/**
 * StarvationExample.java
 * This class is used to demonstrate starvation situation.
 * @author www.codejava.net
 */
public class StarvationExample {

    public static void main(String[] args) {
        Worker worker = new Worker();

        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                public void run() {
                    worker.work();
                }
            }).start();
        }
    }
}
