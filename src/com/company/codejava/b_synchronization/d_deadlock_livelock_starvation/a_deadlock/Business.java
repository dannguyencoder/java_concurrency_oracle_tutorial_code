package com.company.codejava.b_synchronization.d_deadlock_livelock_starvation.a_deadlock;

/**
 * Business.java
 * This class is used to illustrate a deadlock situtation.
 * @author www.codejava.net
 */
public class Business {

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void foo() {
        synchronized (lock1) {
            synchronized (lock2) {
                System.out.println("foo");
            }
        }
    }

    public void bar() {
        synchronized (lock2) {
            synchronized (lock1) {
                System.out.println("bar");
            }
        }
    }

//    public void foo() {
//        synchronized (lock1) {
//            synchronized (lock2) {
//                System.out.println("foo");
//            }
//        }
//    }
//
//    public void bar() {
//        synchronized (lock1) {
//            synchronized (lock2) {
//                System.out.println("bar");
//            }
//        }
//    }
}
