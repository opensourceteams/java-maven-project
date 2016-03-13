package com.opensourceteams.modules.common.gramar.集合;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/2/6  上午11:51
 * 功能描述:
 */

public class JavaCollections {

    public static void main(String[] args) {
        List<String> list = null;
        Collection<String> collection = new ArrayList<String>();
        collection.add("Hive");
        collection.add("MySQL");

        list = new ArrayList<String>();
        list.add("Spark");
        list.add("Hadoop");
        list.add("Kafka");
        list.add("Tachyon");
        list.addAll(collection);



        System.out.println("初使化===========================" + list);

        list.remove(0);
        System.out.println("remove===========================" + list);

        list.remove("MySQL");
        System.out.println("remove===========================" + list);

        String[] array =  list.toArray(new String[]{});

        System.out.println("list.toArray()===========================" + array);
        for(String str : array){
            System.out.println(str);
        }

        List<String> subList = list.subList(1,3);
        System.out.println("subList===========================" + subList);



    }
}
