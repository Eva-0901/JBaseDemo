package org.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class H2O {


    final ReentrantLock lock = new ReentrantLock();

    private final Condition h2 = lock.newCondition();

    private final Condition o1 = lock.newCondition();


    List<String> water = new ArrayList<>(3);
    Semaphore h = new Semaphore(2);
    Semaphore o = new Semaphore(0);

    volatile int num = 0;


    public void hydrogen(Runnable releaseHydrogen) {

        try {
            lock.lock();
            if (water.size() == 3) {
                water.clear();
            }
            long hs = water.stream().filter(it -> it.equals("H")).count();
            if (hs == 2L) {
                o1.notifyAll();
                h2.await();

            } else {
                // print H
                releaseHydrogen.run();
                water.add("H");
                o1.notifyAll();
            }


        } catch (Exception e) {
//            throw new RuntimeException(e);
        } finally {

            lock.unlock();
        }
    }

    public void oxygen(Runnable releaseOxygen) {
        try {
            lock.lock();
            if (water.size() == 3) {
                water.clear();
            }
            boolean contains = water.contains("O");
            if (contains) {
                h2.notifyAll();
                o1.await();
            } else {

                releaseOxygen.run();
                water.add("O");
                h2.notifyAll();
                o1.await();
            }
//            //reset
//            num = 0;

        } catch (Exception e) {
//            throw new RuntimeException(e);
        } finally {

            lock.unlock();
        }
    }

}
