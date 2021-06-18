package com.company.codejava.c_concurrency_api.a_thread_pool_executors.b_cached_thread_pool_executor;

/**
 * CountDownClock.java
 * This class represents a coutdown clock.
 * @author www.codejava.net
 */
public class CountDownClock extends Thread {
    private String clockName;

    public CountDownClock(String clockName) {
        this.clockName = clockName;
    }

    public void run() {
        String threadName = Thread.currentThread().getName();

        for (int i = 5; i >= 0; i--) {

            System.out.printf("%s -> %s: %d\n", threadName, clockName, i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
