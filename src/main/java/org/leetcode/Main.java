package org.leetcode;

import java.util.concurrent.Semaphore;

public class Main {
//    public static volatile int times = 1;
    public static void main(String[] args) throws InterruptedException {
        Semaphore o = new Semaphore(1);

        o.acquire();
        System.out.println(1);
//
//        Semaphore h = new Semaphore(2);
//        Semaphore o = new Semaphore(0);
//
//
//         class H2O {
//
//            public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
//                h.acquire();
//                // print H
//                releaseHydrogen.run();
//                o.release();
//            }
//
//            public void oxygen(Runnable releaseOxygen) throws InterruptedException {
//                o.acquire(2);
//                releaseOxygen.run();
//                h.release(2);
//            }
//        }

//            H2O h2o = new H2O();
//
//            String waters = "OOHHOHHHH";
//
//            for (int i = 0; i < waters.length(); i++) {
//                int finalI = i;
//                Thread a = new Thread(()->{
//                    if(waters.charAt(finalI)=='H'){
//                        try {
//                            h2o.hydrogen(()->System.out.print("H"));
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }else if(waters.charAt(finalI)=='O'){
//                        try {
//                            h2o.oxygen(()->System.out.print("O"));
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                    }else {
//                        throw new RuntimeException("'water' must consist of values in ['H', 'O'] only");
//                    }
//                });
//                a.start();
////                a.setName("Test" + String.valueOf(i));
////                System.out.println(Thread.currentThread().getName());
//            }




    }

}