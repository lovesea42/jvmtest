package com.brianxia.error;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryLeak {
    public static ConcurrentHashMap<String,String> data = new ConcurrentHashMap<>();

    public static void addData(String key){

        data.put(key,"");
    }

    public static void deleteData(String key){

        data.remove(key,"");
    }

    public static void throwEx() throws Exception{
        throw new RuntimeException("leak");

    }
    public static void leak() throws Exception{
        Random random = new Random();
        String key = String.valueOf(random.nextInt());
        addData(key);

        throwEx();

        deleteData(key);

    }

    public static void main(String[] args) {

        while(true){
            try{
                leak();
            }catch (Exception e){
                if(!(e instanceof RuntimeException))
                 e.printStackTrace();
            }
        }

    }

}
