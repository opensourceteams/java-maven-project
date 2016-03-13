package com.opensourceteams.modules.common.java.map.hashmap;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/11  上午10:17
 * 功能描述:HashMap 基本操作,单元测试类
 */

public class HashMapTest {

    HashMap<Integer,String> hashMap = new HashMap<Integer, String>();

    /**
     * HashMap 的put操作
     */
    @Test
    public void testPut(){
        String s= System.getProperty("line.separator");
        hashMap.put(1,"a");
        hashMap.put(2,"subRecursionListFiles");

    }

    /**
     * HashMap 的 keySet 遍历
     */
    @Test
    public void testKeySet(){
        testPut();
        for (Integer key : hashMap.keySet()){
            System.out.println("key:" + key);
            System.out.println("value:" + hashMap.get(key));
        }

    }

    /**
     * HashMap 的 entrySet 遍历
     */
    @Test
    public void testEntrySet(){
        testPut();
        for (Map.Entry<Integer,String> entry : hashMap.entrySet()){
            System.out.println("key:" + entry.getKey() + " value:" + entry.getValue());
        }

    }
}
