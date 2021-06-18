package com.company.codejava.b_synchronization.f_atomic_variables;

import java.util.concurrent.locks.*;
import java.util.concurrent.atomic.*;

public class Counter {
//    private int value;
//
//    public void increment() {
//        value++;
//    }
//
//    public void decrement() {
//        value--;
//    }
//
//    public int get() {
//        return value;
//    }

//    private int value;
//
//    public synchronized void increment() {
//        value++;
//    }
//
//    public synchronized void decrement() {
//        value--;
//    }
//
//    public synchronized int get() {
//        return value;
//    }

//    private int value;
//    private Lock lock = new ReentrantLock();
//
//    public void increment() {
//        lock.lock();
//        value++;
//        lock.unlock();
//    }
//
//    public void decrement() {
//        lock.lock();
//        value--;
//        lock.unlock();
//    }
//
//    public synchronized int get() {
//        return value;
//    }

    private AtomicInteger value = new AtomicInteger();

    public void increment() {
        value.incrementAndGet();
    }

    public void decrement() {
        value.decrementAndGet();
    }

    public int get() {
        return value.get();
    }
}
