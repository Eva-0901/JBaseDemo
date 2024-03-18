package org.proxy;

public class Son extends Father{

    public static void main(String[] args) {
        Son son = new Son();

        if (son instanceof Father) {
            System.out.println("Instance of extends.");
        }

        System.out.println("Father is Son's Son? " + Son.class.isAssignableFrom(Father.class));
        //判断后面能否转换到前面来，或者说是前面的子类。
        System.out.println("Son is Father's Son?" + Father.class.isAssignableFrom(Son.class));
    }
}
