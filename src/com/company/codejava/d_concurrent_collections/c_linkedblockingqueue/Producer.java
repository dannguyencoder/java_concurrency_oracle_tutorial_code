package com.company.codejava.d_concurrent_collections.c_linkedblockingqueue;

import java.util.*;
import java.util.concurrent.*;

/**
 * A producer that puts elements on a BlockingQueue
 * @author www.codejava.net
 */
public class Producer implements Runnable {

    private BlockingQueue<Integer> queue;

    public Producer (BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

//    public void run() {
//
//        try {
//
//            for (int i = 0; i < 50; i++) {
//
//                Integer number = produce();
//
//                queue.put(number);
//
//                System.out.println("PRODUCER: created " + number);
//
//            }
//
//            queue.put(-1);       // indicates end of producing
//
//            System.out.println("PRODUCER: STOPPED.");
//
//        } catch (InterruptedException ie) {
//
//            ie.printStackTrace();
//
//        }
//    }

    public void run() {
        try {

            for (int i = 0; i < 50; i++) {

                Integer number = produce();

                boolean success = queue.offer(number, 100, TimeUnit.MILLISECONDS);

                if (success) {
                    System.out.println("PRODUCER: created " + number);
                } else {
                    System.out.println("PRODUCER: gave up");
                }
            }

            queue.put(-1);       // indicates end of producing

            System.out.println("PRODUCER: STOPPED.");

        } catch (InterruptedException ie) {

            ie.printStackTrace();
        }
    }

    private Integer produce() {
        Random random = new Random();

        Integer number = random.nextInt(100);

        // fake producing time
        try {
            Thread.sleep(random.nextInt(1000));
        } catch (InterruptedException ie) { ie.printStackTrace(); }


        return number;
    }
}
