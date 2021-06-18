package com.company.codejava.d_concurrent_collections.d_priorityblockingqueue;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class PriorityBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {
//        BlockingQueue<String> queue = new PriorityBlockingQueue<>();
//
//        queue.put("one");
//        queue.put("two");
//        queue.put("three");
//        queue.put("four");
//
//        String element = queue.poll();
//
//        while (element != null) {
//            System.out.println(element);
//            element = queue.poll();
//        }

        List<Integer> list = Arrays.asList(28, 8, 20, 17, 15, 40);
        BlockingQueue<Integer> queue = new PriorityBlockingQueue<>(list);
        System.out.println(queue);

    }

}
