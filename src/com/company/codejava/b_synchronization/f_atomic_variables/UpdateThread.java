package com.company.codejava.b_synchronization.f_atomic_variables;

public class UpdateThread extends Thread {
    private Counter counter;

    public UpdateThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) { ex.printStackTrace(); }

        counter.increment();
    }
}
