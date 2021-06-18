package com.company.codejava.d_concurrent_collections.d_priorityblockingqueue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/**
 * This consumer takes a File from the queue, and parses the file
 * to search for the given keyword.
 *
 * @author www.codejava.net
 */
public class FileParser extends Thread {
    private BlockingQueue<File> queue;
    private String keyword;

    public FileParser(BlockingQueue<File> queue, String keyword) {
        this.queue = queue;
        this.keyword = keyword;
    }

    public void run() {
        while (true) {
            try {
                File file = queue.peek();

                if (file != null && !file.getName().equals("END")) {
                    file = queue.take();
                    parseFile(file);
                } else {
                    break;
                }
            } catch (InterruptedException | IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void parseFile(File file) throws IOException {
        List<String> lines = Files.readAllLines(file.toPath());
        int lineCount = 0;

        for (String aLine : lines) {
            lineCount++;
            if (aLine.contains(keyword)) {
                String result = "Found in %s at line %d. Size: %d\n";
                System.out.printf(result,
                        file.getAbsolutePath(), lineCount, file.length());
                break;
            }
        }

    }
}
