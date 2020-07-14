package com.ly.openapi.cache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: Cynaith
 **/
public class LRUCache {
    private static Map<String,String> LRUMap = new LinkedHashMap<String,String>(){
        @Override
        protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
            return this.size() >=100;
        }
    };

    public static String get(String key){
        String value = null;
        try{
            value = LRUMap.get(key);
            return value;
        }catch (Exception e){
            return null;
        }

    }
    public synchronized static boolean put(String key,String value){
        if (key==null||value==null){
            return false;
        }
        LRUMap.put(key, value);
        return true;
    }
    public static void printAll(){
        Iterator it = LRUMap.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry m = (Map.Entry)it.next();
            System.out.println(m.getValue());
        }
    }
    public static Map<String,String> getMap(){
        return LRUMap;
    }
}
