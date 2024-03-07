package org.leetcode;

public class ThreadA extends Thread{

    private Thread nextThread;

    ThreadA (Thread nextThread) {
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
            System.out.println("A is running: A");
//            Main.times ++;
            try {
                nextThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
