package com.company.codejava.a_java_thread_fundamentals.a_how_to_use_threads;

public class ThreadExample2 implements Runnable {

    public void run() {
        System.out.println("My name is: " + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Runnable task = new ThreadExample2();
        Thread t2 = new Thread(task);
        t2.start();

        System.out.println("My name is: " + Thread.currentThread().getName());

        /**
         * One interesting point is that, if you run this program again for several times,
         * you will see sometimes the thread Thread-0 runs first,
         * sometimes the thread main runs first.
         * This can be recognized by the order of thread names in the output changes randomly.
         * That means there’s no guarantee of which thread runs first as they are both started concurrently.
         * You should bear in mind this behavior with regard to multi-threading context.
         * */
    }

}

