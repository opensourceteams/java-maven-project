package com.opensourceteams.modules.common.java.util;

import org.junit.Test;

import java.util.HashMap;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/13  上午4:58
 * 功能描述:
 */

public class HashMapTest {


    HashMap<Integer,String> hashMap = new HashMap<Integer, String>();

    @Test
    public void testHashMapPut(){


        for(int i = 0 ;i <10 ;i++){
            hashMap.put(i +100,"中国"+i);
        }

        hashMap.put(1,"a");
        hashMap.put(2,"subRecursionListFiles");
        hashMap.put(3,"c");
        hashMap.put(15,"中国人民");
        hashMap.put(31,"中国民是最努力最朴实的人31");
        hashMap.put(63,"中国民是最努力最朴实的人64");
    }

    @Test
    public void testHashMapGet(){
        testHashMapPut();
        String s15 = hashMap.get(15);
        String s = hashMap.get(31);
        String s64 = hashMap.get(63);
    }

    @Test
    public void testHashCode(){

        int i1 = "中国".hashCode();
        int i2 = "中国人民富起来了".hashCode();
        int i3 = "123".hashCode();
        int i4 = "abcdefghijklmn".hashCode();


        for (int i = 0 ;i < 100 ;i++){
            System.out.println("i:" +i + " hashCode:" + ("" + i ).hashCode());
        }
        System.out.println("===============");

        for (char i = 'a' ;i < 'z' ;i++){
            System.out.println("i:" + (char)i + " hashCode:" + ("" + i ).hashCode());
        }
        for (char i = 'A' ;i < 'Z' ;i++){
            System.out.println("i:" +(char)i + " hashCode:" + ("" + i ).hashCode());
        }
    }
}
