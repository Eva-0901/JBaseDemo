package org.leetcode;

public class ThreadB extends Thread{
//    private Thread beforeThread;
//
//    ThreadB (Thread beforeThread) {
//        this.beforeThread = beforeThread;
//    }
private Thread nextThread;

    ThreadB (Thread nextThread) {
        this.nextThread = nextThread;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
//            try {
//                beforeThread.join();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
            System.out.println("B is running: B");
//            Main.times ++;
            try {
                nextThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
