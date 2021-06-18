package com.company.codejava.d_concurrent_collections.h_copyonwritearrayset;

import java.util.*;
import java.util.concurrent.*;

/**
 * This program demonstrates how a CopyOnWriteArraySet works
 * in multi-threading context.
 *
 * @author www.codejava.net
 */
public class CopyOnWriteArraySetTest {

    public static void main(String[] args) {

//        Set<Integer> set = new CopyOnWriteArraySet<>();
        Set<Integer> set = new HashSet<>();

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);

        new WriteThread("Writer", set).start();

        new ReadThread("Reader", set).start();

    }
}


class WriteThread extends Thread {

    private Set<Integer> set;

    public WriteThread(String name, Set<Integer> set) {
        this.set = set;
        super.setName(name);
    }

    public void run() {
        int count = 6;

        while (true) {

            try {

                Thread.sleep(5000);

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }

            set.add(count++);

            System.out.println(super.getName() + " done");
        }
    }
}


class ReadThread extends Thread {
    private Set<Integer> set;

    public ReadThread(String name, Set<Integer> set) {
        this.set = set;
        super.setName(name);
    }

    public void run() {

        while (true) {

            String output = "\n" + super.getName() + ":";

            Iterator<Integer> iterator = set.iterator();

            while (iterator.hasNext()) {
                Integer next = iterator.next();
                output += " " + next;

                // fake processing time
                try {

                    Thread.sleep(10);

                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            System.out.println(output);
        }
    }
}
