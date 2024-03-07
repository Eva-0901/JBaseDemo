package org.future;

import java.util.concurrent.ExecutionException;

public class FutureDemo {

    public static void main(String[] args) {
        try {
            new Thread3Ways().testThreadFuture();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
