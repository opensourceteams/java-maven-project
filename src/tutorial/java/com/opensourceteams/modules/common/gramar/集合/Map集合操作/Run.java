package com.opensourceteams.modules.common.gramar.集合.Map集合操作;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/10  下午8:03
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) {
        System.out.println("A");
        Map map = new HashMap();
        map.put("sa","dd");
        map.put("ly","李yan");
        map.put("bj","北京");
        map.put("Java中Map的用法详解","将键映射到值的对象。一个映射不能包含重复的键；每个键最多只能映射到一个值。此接口取代 Dictionary 类，后者完全是一个抽象类，而不是一个接口。\n" +
                "　　Map 接口提供三种collection 视图，允许以键集、值集或键-值映射关系集的形式查看某个映射的内容。映射顺序 定义为迭代器在映射的 collection 视图上返回其元素的顺序。某些映射实现可明确保证其顺序，如 TreeMap 类；另一些映射实现则不保证顺序，如HashMap 类。");



        map.remove("bj");


        System.out.println("====keys======");
        for (Object key : map.keySet()) {

            System.out.println("Key = " + key);
            System.out.println();

        }

        //遍历map中的值
        System.out.println("====values======");

        for (Object value : map.values()) {

            System.out.println("Value = " + value);

        }


        System.out.printf("=============new\n");

        Iterator<Map.Entry<Object, Object>> entries = map.entrySet().iterator();

        while (entries.hasNext()) {

            Map.Entry<Object, Object> entry = entries.next();

            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

        }

    }
}
