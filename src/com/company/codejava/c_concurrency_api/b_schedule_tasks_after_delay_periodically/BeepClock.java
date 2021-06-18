package com.company.codejava.c_concurrency_api.b_schedule_tasks_after_delay_periodically;

import java.util.concurrent.*;

/**
 * BeepClock.java
 *
 * This program demonstrates how to schedule a task to execute after
 * an initial delay, and repeat after a fixed rate.
 *
 * @author www.codejava.net
 */
public class BeepClock implements Runnable {

    public void run() {
        System.out.print("\007");
    }

    public static void main(String[] args) {
        ScheduledExecutorService scheduler
                = Executors.newSingleThreadScheduledExecutor();


        Runnable task = new BeepClock();
        int initialDelay = 4;
        int periodicDelay = 2;

        scheduler.scheduleAtFixedRate(task, initialDelay, periodicDelay,
                TimeUnit.SECONDS);
    }
}
