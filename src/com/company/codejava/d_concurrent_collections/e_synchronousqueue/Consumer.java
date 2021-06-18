package com.company.codejava.d_concurrent_collections.e_synchronousqueue;

import java.util.concurrent.*;

/**
 * A consumer that takes elements from a BlockingQueue
 *
 * @author www.codejava.net
 */
public class Consumer extends Thread {
    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        while (true) {
            try {

                Integer number = queue.take();
                consume(number);

            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    private void consume(Integer number) {
        String message = "Consumer [" + getName() + "]: ";
        message += " processed number: " + number;
        System.out.println(message);
    }
}
