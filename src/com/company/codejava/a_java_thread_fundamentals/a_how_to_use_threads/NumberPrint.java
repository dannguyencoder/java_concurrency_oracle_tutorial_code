package com.company.codejava.a_java_thread_fundamentals.a_how_to_use_threads;

public class NumberPrint implements Runnable {

    public void run() {

        for (int i = 1; i <= 5; i++) {

            System.out.println(i);

            try {

                Thread.sleep(2000);

            } catch (InterruptedException ex) {
                System.out.println("I'm interrupted");
            }
        }
    }

    public static void main(String[] args) {
        Runnable task = new NumberPrint();
        Thread thread = new Thread(task);
        thread.start();

        /**
         * Note that you can’t pause a thread from another thread.
         * Only the thread itself can pause its execution.
         * And there’s no guarantee that the thread always sleep exactly for the specified time
         * because it can be interrupted by another thread,
         * which is described in the next section.
         * */
    }

}
