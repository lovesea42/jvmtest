package com.brianxia.gc;


/**
 * 循环引用的问题

 */
public class CircularReferrence {
    public Object ref = null;
    public static void main(String[] args) {
        CircularReferrence myObject1 = new CircularReferrence();
        CircularReferrence myObject2 = new CircularReferrence();
        myObject1.ref = myObject2;
        myObject2.ref = myObject1;
        myObject1 = null;
        myObject2 = null;
    }
}
