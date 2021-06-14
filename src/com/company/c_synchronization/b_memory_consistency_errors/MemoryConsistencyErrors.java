package com.company.c_synchronization.b_memory_consistency_errors;

public class MemoryConsistencyErrors {

    public static void main(String[] args) {
        int counter = 0;
        counter++;
        System.out.println(counter);

    }
}
