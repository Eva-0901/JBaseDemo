package org.leetcode;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class LcExecutor1117 {
    public static void main(String[] args) throws InterruptedException {
        H2O h2O = new H2O();
        AtomicInteger hcount = new AtomicInteger(6);
        AtomicInteger ocount = new AtomicInteger(3);
        new Thread(() -> {
            while (hcount.get() > 0) {
                h2O.hydrogen(newRunner("H"));
                hcount.decrementAndGet();
            }
        }).start();

        new Thread(() -> {
            while (ocount.get() > 0) {
                h2O.oxygen(newRunner("O"));
                ocount.decrementAndGet();
            }
        }).start();
//        for (int i = 0; i < 6; i++) {
//            new Thread(() -> h2O.hydrogen(() -> System.out.println("H"))).start();
//        }
//        for (int i = 0; i < 3; i++) {
//            new Thread(() -> h2O.oxygen(() -> System.out.println("O"))).start();
//        }


        new CountDownLatch(1).await();

    }

   static class Print implements Runnable {
        private final String toPrint;
        Print (String toPrint) {
            this.toPrint = toPrint;
        }

        @Override
        public void run() {
            System.out.println(toPrint);
        }
    }

    public static Runnable newRunner(String a){
        return ()-> System.out.println(a);
    }
}
