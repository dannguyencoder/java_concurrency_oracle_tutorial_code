package com.company.codejava.d_concurrent_collections.a_arrayblockingqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQueueTest {
    public static void main(String[] args) {
        BlockingQueue<String> queue1 = new ArrayBlockingQueue<>(100);
        BlockingQueue<Integer> queue2 = new ArrayBlockingQueue<>(50, true);
        List<String> list = Arrays.asList("One", "Two", "Three");
        BlockingQueue<String> queue3 = new ArrayBlockingQueue<>(50, true, list);

        BlockingQueue<String> queue = new ArrayBlockingQueue<>(100);

        try {
            queue.put("Four");
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        try {
            long timeout = 1000;
            boolean success = queue.offer("Five", timeout, TimeUnit.MILLISECONDS);

            if (!success) {
                System.out.println("Queue is full and timeout elapsed");
            }

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        try {
            String head = queue.take();
            System.out.println("Head element: " + head);

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        try {
            long timeout = 1000;
            String head = queue.poll(timeout, TimeUnit.MILLISECONDS);
            System.out.println("Head element: " + head);

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

//        BlockingQueue<String> queue = new ArrayBlockingQueue<>(100);
//
//        //...
//        // insertion and removal operations by threads
//        //...
//
//        List<String> list = new ArrayList<>();
//
//        queue.drainTo(list);




    }
}
