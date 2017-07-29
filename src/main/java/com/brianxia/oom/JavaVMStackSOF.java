package com.brianxia.oom;

/**
 * Hotspot并不区分虚拟机栈和本地方法栈，单线程栈溢出
 * VM Args: -Xss128k
 */
public class JavaVMStackSOF {
    private int stackLength = 1;
    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF sof = new JavaVMStackSOF();
        try{
            sof.stackLeak();
        }catch (Throwable e){
            System.out.println("stackLength : " + sof.stackLength);
            throw e;
        }
    }
}
