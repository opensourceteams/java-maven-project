package com.opensourceteams.modules.common.gramar.集合;

import java.util.*;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/2/6  下午2:34
 * 功能描述:
 */

public class TreeMap {

    public static void main(String[] args) {
        treeMap();
        weakHashMap();

    }
    private static void weakHashMap(){
        Map<String,Integer> data = null;
        data = new WeakHashMap<String, Integer>();

        data.put("Hadoop",10);
        data.put("Spark",6);
        data.put("Kafka",5);
        data.put("Tachyon",4);
        System.out.println(data);

        System.gc();

        System.out.println(data);


    }

    private static void treeMap(){
        Map<String,Integer> data = null;
        data = new java.util.TreeMap<String, Integer>();

        data.put("Hadoop",10);
        data.put("Spark",6);
        data.put("Kafka",5);
        data.put("Tachyon",4);

        Set<String>  set = data.keySet();
        Iterator<String> keyIterator = set.iterator();
        while (keyIterator.hasNext()){
            System.out.println(keyIterator.next());
        }

    }
}
