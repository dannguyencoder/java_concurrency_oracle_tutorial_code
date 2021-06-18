package com.company.codejava.d_concurrent_collections.c_linkedblockingqueue;

import java.util.*;
import java.util.concurrent.*;

/**
 * A consumer that takes elements from a BlockingQueue
 * @author www.codejava.net
 */
public class Consumer implements Runnable {

    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

//    public void run() {
//
//        try {
//
//            while (true) {
//
//                Integer number = queue.take();
//
//                if (number == -1) {
//                    System.out.println("Consumer: STOPPED.");
//                    break;
//                }
//
//                consume(number);
//            }
//
//
//
//        } catch (InterruptedException ie) {
//
//            ie.printStackTrace();
//        }
//    }

    public void run() {

        try {

            while (true) {

                Integer number = queue.poll(100, TimeUnit.MILLISECONDS);

                if (number != null) {
                    if (number == -1) {
                        System.out.println("Consumer: STOPPED.");
                        break;
                    }

                    consume(number);
                } else {
                    System.out.println("Consumer: gave up");
                }
            }

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    private void consume(Integer number) {
        // fake consuming time
        Random random = new Random();

        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException ie) { ie.printStackTrace(); }

        System.out.println("Consumer: processed " + number);
    }
}
