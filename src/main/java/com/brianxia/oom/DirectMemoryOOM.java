package com.brianxia.oom;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.nio.ByteBuffer;

/**
 * 直接内存溢出
 * VM Args : -Xmx20M -XX:MaxDirectMemorySize=10M
 */
public class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws Exception {
        ByteBuffer.allocateDirect(11*_1MB);

        //ByteBuffer.allocateDirect(10*_1MB);
        //ByteBuffer.allocateDirect(_1MB);
    }
}
