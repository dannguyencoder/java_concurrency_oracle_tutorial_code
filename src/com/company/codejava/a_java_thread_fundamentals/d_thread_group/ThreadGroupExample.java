package com.company.codejava.d_thread_group;

public class ThreadGroupExample {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup group = new ThreadGroup("GroupA");

        new Task(group, "A").start();
        new Task(group, "B").start();
        new Task(group, "C").start();
        new Task(group, "D").start();

        Thread.sleep(10000);

        group.interrupt();

    }
}
