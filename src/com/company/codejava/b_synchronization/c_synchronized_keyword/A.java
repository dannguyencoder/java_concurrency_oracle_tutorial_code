package com.company.codejava.b_synchronization.c_synchronized_keyword;

public class A {
    public synchronized void update() {
        // code needs to be serialized for access
//        synchronized (obj) {
//            // code block
//        }

//        synchronized (obj) {
//            if (!condition) {
//                obj.wait();
//            }
//
//            // code block
//
//            obj.notify();
//
//            // or:
//
//            obj.notifyAll();
//        }


    }

    private Object lock = new Object();

    public void write() {
        synchronized (lock) {
            // code to write
        }
    }

    public void read() {
        // code to read
    }

//    public void update() {
//        synchronized (this) {
//            // code block
//        }
//    }

//    public void update() {
//        this.intrinsicLock.lock();
//
//        try {
//
//            // code needs to be serialized for access
//
//        } finally {
//            this.intrinsicLock.unlock();
//        }
//    }

//    public synchronized void update() {
//        if (!condition) {
//            this.wait();
//        }
//
//        // code needs to be serialized for access
//
//        this.notify();
//
//        // or:
//
//        this.notifyAll();
//    }

//    public static synchronized void update() {
//        // code
//    }

//    public static void update() {
//        synchronized (A.class) {
//            // code
//        }
//    }

    /**
     * So when a thread is executing a synchronized static method,
     * it also blocks access to all other synchronized static methods.
     * The synchronized non-static methods are still executable by other threads.
     * It’s because synchronized static methods and synchronized non-static methods
     * work on different locks: class lock and instance lock.
     * */

    /**
     * In other words, a synchronized static method and a non-static synchronized method will not block each other.
     * They can run at the same time.
     * */

}
