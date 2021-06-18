package com.company.codejava.d_concurrent_collections.e_synchronousqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueTestMyself {

    public static void main(String[] args) {
//        BlockingQueue<String> syncQueue = new SynchronousQueue<>();
        BlockingQueue<Integer> syncQueue = new SynchronousQueue<>(true);

//        try {
//            syncQueue.put("Element");
//        } catch (InterruptedException ie) {
//            ie.printStackTrace();
//        }
//
//        try {
//            String element = syncQueue.take();
//        } catch (InterruptedException ie) {
//            ie.printStackTrace();
//        }



    }

}
