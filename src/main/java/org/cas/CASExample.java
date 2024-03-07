package org.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CASExample {
    //是原子操作，不会被中断。一般通过循环重新尝试直到成功。
    //虽然解决了race condition，但是仍存在ABA问题。

    public static AtomicInteger atomicInteger = new AtomicInteger(3);

    public static void main(String[] args) {
        int expect = atomicInteger.get();
        int newVal = expect + 1;

        while(!atomicInteger.compareAndSet(expect, newVal)) {
            //重新获取
            expect = atomicInteger.get();
            newVal = expect + 1;
        }

        System.out.println(atomicInteger.get());

    }
}
