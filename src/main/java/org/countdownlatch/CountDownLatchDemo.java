package org.countdownlatch;

import java.util.concurrent.*;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

        //靠AQS中的sync类初始化 state=3
        CountDownLatch latch = new CountDownLatch(3);
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.submit(new Worker(latch, String.valueOf(i)));
        }

        //阻塞主线程，尝试获取state，直到state为0时再继续执行。
        latch.await();
        System.out.println("All workers are done!");
        //必须显示地关闭线程池，才能使得主线程结束，因为线程池中的核心线程不会被主动回收。
        //另一个方法shutdownnow是立刻停止所有任务。
        //等待已经提交的任务技术后再关闭。
        executorService.shutdown();

    }
    static  class Worker implements Runnable {
    private CountDownLatch countDownLatch;
    private String workerName;

    Worker(CountDownLatch countDownLatch, String workerName) {
        this.countDownLatch = countDownLatch;
        this.workerName = workerName;
    }
    @Override
    public void run() {
        System.out.println("I am worker: " + workerName);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            //AQS and change the state value.
            countDownLatch.countDown();
        }
    }
}

}
