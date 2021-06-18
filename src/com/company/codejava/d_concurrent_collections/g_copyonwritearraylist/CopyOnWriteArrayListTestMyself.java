package com.company.codejava.d_concurrent_collections.g_copyonwritearraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListTestMyself {

    public static void main(String[] args) {
//        List<String> unsafeList = new ArrayList<>();
//        List<String> safeList = Collections.synchronizedList(unsafeList);
//
//        safeList.add("Boom");   // safe to use with multiple threads
//
//        String[] fruits = {"Apple", "Banana", "Lemon", "Grape", "Mango"};
//        List<String> list = new CopyOnWriteArrayList<>(fruits);

        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("Apple");
        list.add("Banana");

        if (list.addIfAbsent("Orange")) {
            System.out.println("Orange was added");
        }

        CopyOnWriteArrayList<String> list1 = new CopyOnWriteArrayList<>();

        list1.add("Apple");
        list1.add("Banana");

        List<String> list2 = Arrays.asList("Lemon", "Banana");

        int result = list1.addAllAbsent(list2);

        System.out.println("Elements added: " + result);

    }

}
