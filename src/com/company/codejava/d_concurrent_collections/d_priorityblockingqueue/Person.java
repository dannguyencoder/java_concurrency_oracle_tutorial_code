package com.company.codejava.d_concurrent_collections.d_priorityblockingqueue;

/**
 * A model class that implements the Comparable interface
 * so its objects can be hold in a PriorityBlockingQueue
 * @author www.codejava.net
 */
public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private int income;

    public Person(String name, int age, int income) {
        this.name = name;
        this.age = age;
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public int compareTo(Person another) {
        return this.name.compareTo(another.name);
    }

    public String toString() {
        return this.name + "\t" + this.age + "\t" + this.income;
    }
}
