package com.brianxia.monitor.memory;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryPoolMXBean;
import java.util.List;

public class MemoryMonitor {

    public static void visitMemory(){
        MemoryMXBean bean = ManagementFactory.getMemoryMXBean();
        Runtime runtime = Runtime.getRuntime();

        List<GarbageCollectorMXBean> beans = ManagementFactory.getGarbageCollectorMXBeans();


        System.out.println("--------------Memory-----------------");
        //JVM内存相关信息
        System.out.println("max memory:" + (runtime.maxMemory()>>20)+ "M"
                            + ",total memory:" + (runtime.totalMemory()>>20) + "M"
                            + ",free memory:" + (runtime.freeMemory()>>20)+ "M"
                + ",heap memory used:" + (bean.getHeapMemoryUsage().getUsed()>>20) + "M"
                + ",non heaap memory used:" + (bean.getNonHeapMemoryUsage().getUsed()>>20)+ "M"

        );
        System.gc();

        System.out.println("--------------GC-----------------");
        //GC相关信息
        for (GarbageCollectorMXBean mxbean : beans) {
            if (mxbean.isValid()) {
                System.out.println("name:" + mxbean.getName()
                +",count:" + mxbean.getCollectionCount()
                +",time:"+mxbean.getCollectionTime()

                );
            }
        }


        System.out.println("--------------Memory Pool-----------------");
        for (MemoryPoolMXBean mpBean : ManagementFactory.getMemoryPoolMXBeans()) {
            long count = mpBean.getUsage().getUsed();
            String name = mpBean.getName();

            System.out.println("name:" + name
                    +",count:" + count

            );
        }
    }

    public static void main(String[] args) {
        MemoryMonitor.visitMemory();
    }
}
