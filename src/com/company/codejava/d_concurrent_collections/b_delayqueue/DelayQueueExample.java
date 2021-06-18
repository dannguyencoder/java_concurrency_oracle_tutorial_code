package com.company.codejava.d_concurrent_collections.b_delayqueue;

import java.util.List;
import java.util.concurrent.DelayQueue;

public class DelayQueueExample {

    public static void main(String[] args) {
        DelayQueue<DelayTask> queue = new DelayQueue<>();
//        List<DelayTask> listTask = ... // a list of DelayTask objects
//        DelayQueue<DelayTask> queue = new DelayQueue<>(listTask);
        DelayTask task1 = new DelayTask("Learn Java", 20_000);
        DelayTask task2 = new DelayTask("Code Java", 100_000);
        DelayTask task3 = new DelayTask("Do Project", 200_000);

        queue.put(task1);
        queue.put(task2);
        queue.put(task3);

        DelayTask task = queue.poll();

        if (task != null) {
            System.out.println("Process: " + task);
        } else {
            System.out.println("No expired task");
        }

//        try {
//            DelayTask task = queue.take();
//            System.out.println("Process: " + task);
//        } catch (InterruptedException ie) {
//            ie.printStackTrace();
//        }

//        DelayTask task = queue.peek();
//
//        if (task != null) {
//            System.out.println("Process: " + task);
//        } else {
//            System.out.println("Queue is empty");
//        }


    }

}
