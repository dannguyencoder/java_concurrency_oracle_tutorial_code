package com.company.codejava.d_concurrent_collections.d_priorityblockingqueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public class PriorityBlockingQueueTest2 {

    public static void main(String[] args) throws InterruptedException {
//        BlockingQueue<Person> queue = new PriorityBlockingQueue<>();
//
//        queue.put(new Person("Tony", 30, 50000));
//        queue.put(new Person("John", 25, 60000));
//        queue.put(new Person("Alex", 35, 80000));
//        queue.put(new Person("Garry", 23, 99000));
//
//        Person person = queue.poll();
//
//        while (person != null) {
//            System.out.println(person);
//            person = queue.poll();
//        }

//        Comparator<Person> ageComparator = new Comparator<Person>() {
//            public int compare(Person person1, Person person2) {
//                return person1.getAge() - person2.getAge();
//            }
//        };
//
//        BlockingQueue<Person> queue = new PriorityBlockingQueue<>(10, ageComparator);
//
//        queue.put(new Person("Tony", 30, 50000));
//        queue.put(new Person("John", 25, 60000));
//        queue.put(new Person("Alex", 35, 80000));
//        queue.put(new Person("Garry", 23, 99000));
//
//        Person person = queue.poll();
//
//        while (person != null) {
//            System.out.println(person);
//            person = queue.poll();
//        }

        BlockingQueue<Person> queue = new PriorityBlockingQueue<>();

        Person person = new Person("Tom", 48, 120000);

        // this never returns false:
        boolean success = queue.offer(person);

        // this never returns false or block:
        boolean result = queue.offer(person, 1, TimeUnit.SECONDS);

        // this never blocks:
        queue.put(person);

        // this will block if the queue is empty,
        // waiting until an element becomes available
        Person firstOne = queue.take();

        // this will block if the queue is empty,
        // waiting up to the specified timeout
        Person nextOne = queue.poll(2, TimeUnit.SECONDS);


    }

}
