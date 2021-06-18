package com.company.codejava.a_java_thread_fundamentals.a_how_to_use_threads;

public class ThreadJoinExample implements Runnable {

    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName()  + ": " + "This is message #" + i);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                System.out.println("I'm about to stop");
                return;
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadJoinExample());
        t1.start();
        Thread t2 = new Thread(new ThreadJoinExample());
        t2.start();
        Thread t3 = new Thread(new ThreadJoinExample());
        t3.start();

        try {

            t1.join();
            t2.join();
            t3.join();

        } catch (InterruptedException ex) {
            // do nothing
        }

        System.out.println("I'm " + Thread.currentThread().getName());

        /**
         * Note that the join() method throws InterruptedException
         * if the current thread is interrupted, so you need to catch it.
         * */

        /**
         * There are 2 overloads of join() method:
         * - join(milliseconds)
         *
         * - join(milliseconds,  nanoseconds)
         *
         * These methods cause the current thread to wait at most for the specified time.
         * That means if the time expires and the joined thread has not completed,
         * the current thread continues running normally.
         * */

        /**
         * You can also join multiple threads with the current thread, for example:
         * t1.join();
         * t2.join();
         * t3.join();
         * In this case, the current thread has to
         * wait for all three threads t1, t2 and t3 completes before it can resume running.
         * */

        /**
         * That’s the fundamentals of using threads in Java.
         * You are now able to create, start, interrupt (to stop or resume) and join (to wait) threads.
         * */




    }
}
