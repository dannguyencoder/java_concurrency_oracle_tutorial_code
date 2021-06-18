package com.company.codejava.a_java_thread_fundamentals.a_how_to_use_threads;

public class ThreadInterruptExample implements Runnable {

    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("This is message #" + i);

//            try {
//                Thread.sleep(2000);
//                continue;
//            } catch (InterruptedException ex) {
//                System.out.println("I'm resumed");
//            }

//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException ex) {
//                System.out.println("I'm resumed");
//                continue;
//            }

//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException ex) {
//                System.out.println("I'm about to stop");
//                return;
//            }

            if (Thread.interrupted()) {
                System.out.println("I'm about to stop");
                return;
            }

            /**
             * However this version doesn’t behave the same as the previous one
             * because the thread t1 terminates very quickly as it doesn’t sleep
             * and the print statements are executed very fast.
             * So this example is just to show you how it is used. In practice,
             * this kind of checking on interrupt status should be applied for long-running operations
             * such as IO, network, database, etc.
             * And remember that when the InterruptedException is thrown,
             * the interrupt status is cleared.
             * */

            /**
             * If you look at the Thread class in Javadocs, you will see there are 4 methods:
             * 1
             * destroy() - stop() - suspend() - resume()
             * However all these methods are deprecated,
             * meaning that you shouldn’t use them.
             * Let use the interruption mechanism I have described so far.
             * */
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new ThreadInterruptExample());
        t1.start();

        try {
            Thread.sleep(5000);
            t1.interrupt();

        } catch (InterruptedException ex) {
            // do nothing
        }

    }
}
