package com.company.codejava.d_concurrent_collections.a_arrayblockingqueue;

import java.io.*;
import java.util.concurrent.*;

/**
 * This program demonstrates using ArrayBlockingQueue
 * in a producer-consumer application.
 *
 * @author www.codejava.net
 */
public class FileTextSearch {
    public static void main(String[] args) {
        String dirPath = args[0];
        String extension = args[1];
        String keyword = args[2];

        BlockingQueue<File> queue = new ArrayBlockingQueue<>(100);

        DirectoryLister lister = new DirectoryLister(queue, new File(dirPath), extension);
        lister.start();

        for (int i = 0; i < 10; i++) {
            FileParser parser = new FileParser(queue, keyword);
            parser.start();
        }
    }
}