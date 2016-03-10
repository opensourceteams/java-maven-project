package com.opensourceteams.modeles.common.gramar.集合;

import java.util.*;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/2/6  下午2:22
 * 功能描述:
 */

public class JavaMap {

    public static void main(String[] args) {
        Map<String,Integer> data = null;
        data = new HashMap<String, Integer>();

        data.put("Hadoop",10);
        data.put("Spark",6);
        data.put("Kafka",5);
        data.put("Tachyon",4);


        System.out.println(data);
        System.out.println(data.get("Spark"));

        if(data.containsKey("Hadoop")){
            System.out.println("Hadoop");
        }

        if(data.containsValue(6)){
            System.out.println("Spark");
        }


        Set<String> keys = data.keySet();
        Iterator<String> keyIterator = keys.iterator();
        while (keyIterator.hasNext()){
            System.out.println(keyIterator.next());
        }

        Collection<Integer> values = data.values();
        Iterator<Integer> iterator = values.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }



    }
}
