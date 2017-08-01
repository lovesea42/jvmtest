package com.brianxia.monitor.os;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class OsMonitor {

    public static boolean isInstanceOfInterface(Class<?> clazz, String interfaceName) {
        if (clazz == Object.class) {
            return false;
        } else if (clazz.getName().equals(interfaceName)) {
            return true;
        }

        Class<?>[] interfaceclasses = clazz.getInterfaces();

        for (Class<?> interfaceClass : interfaceclasses) {
            if (isInstanceOfInterface(interfaceClass, interfaceName)) {
                return true;
            }
        }

        return isInstanceOfInterface(clazz.getSuperclass(), interfaceName);
    }

    public static void main(String[] args) {
        OperatingSystemMXBean bean = ManagementFactory.getOperatingSystemMXBean();
        System.out.println("arch:" + bean.getArch()
                +",name:" + bean.getName()
                +",version:"+bean.getVersion()
                +",available processors:"+bean.getAvailableProcessors()
                +",system load average:"+bean.getSystemLoadAverage()
        );

        // for Sun JDK
        if (isInstanceOfInterface(bean.getClass(), "com.sun.management.OperatingSystemMXBean")) {
            com.sun.management.OperatingSystemMXBean b = (com.sun.management.OperatingSystemMXBean) bean;

            System.out.println("total physical memory size:" + (b.getTotalPhysicalMemorySize()>>20) + "m"
                    +",free physical memory size:" + (b.getFreePhysicalMemorySize()>>20) + "m"
            );
        }
    }
}
