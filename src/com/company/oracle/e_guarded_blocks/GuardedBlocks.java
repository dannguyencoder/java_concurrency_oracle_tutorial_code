package com.company.e_guarded_blocks;

public class GuardedBlocks {

    public static void main(String[] args) {

    }
//    public void guardedJoy() {
//        // Simple loop guard. Wastes
//        // processor time. Don't do this!
//        while(!joy) {}
//        System.out.println("Joy has been achieved!");
//    }
//
//    public synchronized void guardedJoy() {
//        // This guard only loops once for each special event, which may not
//        // be the event we're waiting for.
//        while(!joy) {
//            try {
//                wait();
//            } catch (InterruptedException e) {}
//        }
//        System.out.println("Joy and efficiency have been achieved!");
//    }
//
//    public synchronized notifyJoy() {
//        joy = true;
//        notifyAll();
//    }

}
