package com.company.codejava.d_concurrent_collections.e_synchronousqueue;

import java.util.*;
import java.util.concurrent.*;

/**
 * A producer that puts elements to a BlockingQueue
 *
 * @author www.codejava.net
 */
public class Producer extends Thread {
    private BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        while (true) {
            try {

                queue.put(produce());

            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    private Integer produce() {
        Random randomer = new Random();
        Integer number = randomer.nextInt(1000);

        try {
            Thread.sleep(randomer.nextInt(1000));
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        System.out.println("Producer: created number: " + number);

        return number;
    }
}
