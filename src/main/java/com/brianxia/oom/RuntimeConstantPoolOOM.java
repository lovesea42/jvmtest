package com.brianxia.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * 常量池导致的内存溢出,1.7之后无法实现
 * VM Args:-XX:PermSize=10M -XX:MaxPermSize=10M
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        List<String> list =new ArrayList<String>();
        int i = 0;
        while(true){
            list.add(String.valueOf(i++).intern());
        }
    }

}
