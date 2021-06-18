package com.company.codejava.d_concurrent_collections.d_priorityblockingqueue;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

/**
 * A file text search program uses PriorityBlockingQueue
 * @author www.codejava.net
 */
public class FileTextSearch {
    public static void main(String[] args) {
        String dirPath = args[0];
        String extension = args[1];
        String keyword = args[2];

        BlockingQueue<File> queue = new PriorityBlockingQueue<>(100, new FileComparator());

        DirectoryLister lister = new DirectoryLister(queue, new File(dirPath), extension);
        lister.start();

        for (int i = 0; i < 10; i++) {
            FileParser parser = new FileParser(queue, keyword);
            parser.start();
        }
    }
}