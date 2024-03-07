package org.future;

import java.util.concurrent.*;

public class Thread3Ways {
    //3 ways to create a new thread in java.

    //1. inherit thread.
    class ThreadSimple extends Thread {
        @Override
        public void run() {
            System.out.println("I am a simple thread.");
        }
    }

    //2. implement runnable interface
    class ThreadRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println("I am a thread implements runnable.");
        }
    }

    //3. implement callable and wrap it with FutureTask to transmit into a thread
    class ThreadFuture implements Callable<String> {
        @Override
        public String call() {
            return "I'm the thread return value.";
        }
    }

     void testThreadFuture() throws ExecutionException, InterruptedException {
        ThreadFuture threadFuture = new ThreadFuture();
        FutureTask<String> futureTask = new FutureTask<>(threadFuture);

        Thread threadToExecute = new Thread(futureTask);

        threadToExecute.start();
        String result = futureTask.get();

        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<String> resultForPool = executorService.submit(new ThreadFuture());
        String resultForPoolStr = resultForPool.get();

        System.out.println(result);
        System.out.println(resultForPoolStr);
    }

}

