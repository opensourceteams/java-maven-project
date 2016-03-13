package com.opensourceteams.modules.common.gramar.集合.List集合元素的去重;

import java.util.*;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/10  下午3:08
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();

        list.add("a");
        list.add("subRecursionListFiles");
        list.add("a");

        System.out.println("======List转换为 Set");
        Set<String> set = listToSet(list);
        printSet(set);


        System.out.println("======Set 转换为 List");
        List<String> list2 = setToList(set);
        printList(list2);

        //listToList();

        Object[] obj = listToArray(list2);
        printArray(obj);







    }

    public static void listToList(){

        List<List<String>> grade = new ArrayList<List<String>>();


        int index = 0;
        for (int j = 0;j<10;j++){

            List<String> clazz = new ArrayList<String>();
            for(int i =0;i< 5;i++){

                clazz.add("年级" +j+ "班级:" +i +" tom"+ (index++));

            }
            grade.add(clazz);
        }


        for (List<String> clazzs : grade){
            for (String s :clazzs){
                System.out.println("学生:" +s);
            }
        }

    }

    /**
     * 去list 的重复元素,直接把List转换为Set
     * @param list
     * @return
     */
    public static Set<String> listToSet(List<String> list){

        HashSet<String> hs = new HashSet<String>(list);

        return hs;
    }

    public static Object[] listToArray(List<String> list){

        return list.toArray();
    }


    /**
     * set 转换为 list
     * @param set
     * @return
     */
    public static List<String> setToList(Set<String> set){

        List<String> list = new ArrayList<String>(set);
        return list;
    }


    public static void printSet( Set<String> set){
        Iterator it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

    public static void printList( List<String> list){
        for(String s: list){
            System.out.println(s);
        }
    }

    public static void printArray( Object[] obj){
        for(Object s: obj){
            System.out.println(s);
        }
    }



}
