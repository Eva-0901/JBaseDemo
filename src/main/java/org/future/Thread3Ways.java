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
        //装饰器模式。
        ThreadFuture threadFuture = new ThreadFuture();
        //使其获得了获取执行结果的能力。
        FutureTask<String> futureTask = new FutureTask<>(threadFuture);
        //使其获得了作为线程执行的能力。
         //因为thread只支持传入runnable，所以futureTask会实现runnable。
        Thread threadToExecute = new Thread(futureTask);
        //执行。
        threadToExecute.start();
        //获取结果。
        String result = futureTask.get();

        ExecutorService executorService = Executors.newCachedThreadPool();

        //submit方法永远有一个返回值，future，每日思考之：当提交runnable的任务时，future.get返回null。
         //submit方法的传入是实现了runnable/callable的任何东西。
        Future<String> resultForPool = executorService.submit(new ThreadFuture());
        //因为实现了runnable，所以也可以提交。
        //executorService.submit(futureTask);
        //会阻塞当前主线程直到获取结果，为了避免长时间的阻塞，需要用超时的get方法。
        String resultForPoolStr = resultForPool.get();

        System.out.println(result);
        System.out.println(resultForPoolStr);
    }

}

