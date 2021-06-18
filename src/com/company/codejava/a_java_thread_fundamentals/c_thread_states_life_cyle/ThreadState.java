package com.company.codejava.c_thread_states_life_cyle;

public class ThreadState {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            public void run() {
                Thread self = Thread.currentThread();
                System.out.println(self.getName() + "is " + self.getState());// LINE 0
            }
        });

        System.out.println(t.getName() + "is " + t.getState()); // LINE 1

        t.start();

        t.join();

        if (t.getState() == Thread.State.TERMINATED) {
            System.out.println(t.getName() + " is terminated"); // LINE 2
        }
    }
}
