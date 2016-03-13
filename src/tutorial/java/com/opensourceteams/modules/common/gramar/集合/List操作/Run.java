package com.opensourceteams.modules.common.gramar.集合.List操作;

import java.util.ArrayList;
import java.util.List;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/10  下午7:37
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) {
        String a1 = "a";
        String a2 = "subRecursionListFiles";
        String a3 = "c";

        String[] arry = {"b1","b2","b3"};

        System.out.println("========");
        for(String s : arry){
            System.out.println(s);
        }

        System.out.println("========");
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a3);
        System.out.println("====集合====");

       // ArrayList a11 = new ArrayList();
       // ArrayList<String> a11 = new ArrayList<String>();
       // ArrayList<Object> a11 = new ArrayList<Object> ();
        List<Object> a11 = new ArrayList<Object> ();
        a11.add("java");
        a11.add("php");//List集合中的元素可以重复

        System.out.println(a11.get(0));
        System.out.println(a11.get(1));
        System.out.println("===");
        for(int i=0;i<a11.size();i++){
            System.out.println(a11.get(i));
        }

/*        for(String s: a11){
            System.out.println(s);
        }*/

        a11.remove(1);

        a11.add(1,"hadoop");

        System.out.println("========Object 增强for循环");
        for(Object s: a11){
            System.out.println(s);
        }




    }
}
