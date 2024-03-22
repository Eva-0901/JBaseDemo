package org.function;

import java.util.function.BiFunction;

public class BiFunctionPractise {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> plusFunction = Integer::sum;
        Integer result = plusFunction.apply(1,1);
        System.out.println("Result through bi function is: " + result);
    }
}
