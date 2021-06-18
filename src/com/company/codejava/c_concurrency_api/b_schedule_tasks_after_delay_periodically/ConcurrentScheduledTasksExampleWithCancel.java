package com.company.codejava.c_concurrency_api.b_schedule_tasks_after_delay_periodically;

import java.util.concurrent.*;

/**
 * ConcurrentScheduledTasksExampleWithCancel.java
 *
 * This program demonstrates how to schedule multiple tasks to execute after
 * an initial delay, and repeat after a fixed delay.
 * And all tasks are cancelled after a specified time.
 *
 * @author www.codejava.net
 */
public class ConcurrentScheduledTasksExampleWithCancel {
    public static void main(String[] args) {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(3);

        CountDownClock clock1 = new CountDownClock("A");
        CountDownClock clock2 = new CountDownClock("B");
        CountDownClock clock3 = new CountDownClock("C");

        Future<?> f1 = scheduler.scheduleWithFixedDelay(clock1, 3, 10, TimeUnit.SECONDS);
        Future<?> f2 = scheduler.scheduleWithFixedDelay(clock2, 3, 15, TimeUnit.SECONDS);
        Future<?> f3 = scheduler.scheduleWithFixedDelay(clock3, 3, 20, TimeUnit.SECONDS);

        Runnable cancelTask = new Runnable() {
            public void run() {
                f1.cancel(true);
                f2.cancel(true);
                f3.cancel(true);
            }
        };

        scheduler.schedule(cancelTask, 120, TimeUnit.SECONDS);

    }
}
