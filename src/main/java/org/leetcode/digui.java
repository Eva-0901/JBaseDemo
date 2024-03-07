package org.leetcode;

public class digui {

    public static void main (String[] args) {
        hello(4);
    }

    public static void hello(int i) {
        if (i == 0) {
            System.out.println("End of digui");
            return;
        }
        if (i < 5) {
            System.out.println("zhunbei " + i);
            hello(i-1);
            System.out.println("jieshu " + i);
        }

    }
}
