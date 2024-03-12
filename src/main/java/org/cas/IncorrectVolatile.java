package org.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class IncorrectVolatile {

    static volatile int voInt = 0;
    static AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new IncrementTask());
        Thread thread2 = new Thread(new IncrementTask());

        thread1.start();
        thread2.start();

        //主线程等待子线程执行完毕。
        thread1.join();
        thread2.join();

        //并非线程安全，只能保证可见性。
        System.out.println("Volatile: " + voInt);
        System.out.println("Atomic: " + atomicInteger.get());

        voInt = 0;
        atomicInteger.set(0);

        Thread thread3 = new Thread(new IncrementSafeTask());
        Thread thread4 = new Thread(new IncrementSafeTask());

        thread3.start();
        thread4.start();

        //join方法用于保证线程的执行顺序，主线程等待子线程执行完毕。
        thread3.join();
        thread4.join();

        //并非线程安全，只能保证可见性。
        System.out.println("Volatile After Thread Safe Refactor: " + voInt);
        System.out.println("Atomic: " + atomicInteger.get());

    }

    public static class IncrementSafeTask implements Runnable {
        //Only one obj instance using for lock.
        static private final Object lock = new Object();
        @Override
        public void run() {
            synchronized (lock) {
                for (int i = 0; i < 10000; i++) {
                    voInt++;
                    //通过cas来实现的。
                    atomicInteger.getAndIncrement();
                }
            }

        }
    }

    public static class IncrementTask implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                voInt++;
                //通过cas来实现的。
                atomicInteger.getAndIncrement();
            }
        }
    }
}
