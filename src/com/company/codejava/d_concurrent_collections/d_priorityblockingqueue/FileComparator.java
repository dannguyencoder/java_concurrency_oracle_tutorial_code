package com.company.codejava.d_concurrent_collections.d_priorityblockingqueue;

import java.io.File;
import java.util.Comparator;

/**
 * A comparator that compares two Files based on their length.
 * @author www.codejava.net
 */
class FileComparator implements Comparator<File> {

    public int compare(File file1, File file2) {
        long file1Length = file1.length();
        long file2Length = file2.length();

        if (file1Length > file2Length) {
            return -1;
        } else {
            return 1;
        }
    }
}
