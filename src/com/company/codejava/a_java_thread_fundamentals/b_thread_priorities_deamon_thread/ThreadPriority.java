package com.company.codejava.b_thread_priorities_deamon_thread;

public class ThreadPriority {

    public static void main(String[] args) {
        Thread t1 = new Thread();
        t1.setPriority(8);
        Thread t2 = new Thread();
        t2.setPriority(Thread.MAX_PRIORITY);

        int priority = Thread.currentThread().getPriority();

        System.out.println(priority);
    }
}
