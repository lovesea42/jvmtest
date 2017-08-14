package com.brianxia.gc;

import com.brianxia.monitor.memory.MemoryMonitor;

/**
 * 引用计数GC
 * VM Args:-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *
 * -XX:+UseSerialGC
 */
public class ReferenceCountingGC {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] test1 = new byte[2 * _1MB];
        byte[] test2 = new byte[2 * _1MB];
        byte[] test3 = new byte[2 * _1MB];
        byte[] test4 = new byte[4 * _1MB];

        //System.out.println("start to system gc...");
        //System.gc();
        //System.out.println("end to system gc...");
        MemoryMonitor.visitMemory();
    }
}
