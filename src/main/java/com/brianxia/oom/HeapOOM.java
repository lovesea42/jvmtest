package com.brianxia.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆溢出
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutofMemoryError -XX:HeapDumpPath=c:\
 */
public class HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while(true){
            list.add(new OOMObject());
        }
    }
}
