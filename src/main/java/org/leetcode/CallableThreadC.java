package org.leetcode;

import java.util.concurrent.Callable;

public class CallableThreadC implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "I'm a callable thread.";
    }
}
