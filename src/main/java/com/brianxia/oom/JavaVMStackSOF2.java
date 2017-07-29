package com.brianxia.oom;

/**
 * 多线程总栈空间溢出
 * VM Args: -Xss2M
 */
public class JavaVMStackSOF2 {

    private void dontStop(){
        while(true){

        }
    }


    public void stackLeakByThread(){
        while(true){
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackSOF2 oom = new JavaVMStackSOF2();
        oom.stackLeakByThread();
    }
}
