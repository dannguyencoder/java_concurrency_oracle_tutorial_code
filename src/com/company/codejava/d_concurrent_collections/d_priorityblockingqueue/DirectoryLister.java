package com.company.codejava.d_concurrent_collections.d_priorityblockingqueue;

import java.io.File;
import java.io.FileFilter;
import java.util.concurrent.BlockingQueue;

/**
 * This producer enumerates files of a specific type in a given directory
 * and then put the files on the queue.
 *
 * @author www.codejava.net
 */
public class DirectoryLister extends Thread {
    private BlockingQueue<File> queue;
    private File directory;
    private String extension;

    public DirectoryLister(BlockingQueue<File> queue,
                           File directory, String extension) {
        this.queue = queue;
        this.directory = directory;
        this.extension = extension;
    }

    public void run() {

        try {

            listDirectory(directory);
            queue.put(new File("END"));

        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }

    private void listDirectory(File dir) throws InterruptedException {
        File[] files = dir.listFiles(new FileFilter() {
            public boolean accept(File file) {
                return file.getName().endsWith(extension);
            }
        });

        if (files != null && files.length > 0) {
            for (File aFile : files) {
                if (aFile.isDirectory()) {
                    listDirectory(aFile);
                } else {
                    queue.put(aFile);
                }
            }
        }
    }
}
