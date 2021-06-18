package com.company.codejava.b_synchronization.b_lock_condition_objects.a_reentrant_lock;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Clazz {
    private Lock lock = new ReentrantLock();

    public void method() {
        lock.lock();    // 1

        try {

            // 2: code needs to be protected

        } finally {
            lock.unlock();  // 3
        }
    }
}
