package com.opensourceteams.modeles.common.gramar.集合.Collections操作;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/10  上午10:43
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) {
        getCollectionsMax();
        getCollectionsMin();
        getCollectionsMin2(); //取首位字符最小值
        getCollectionsIntegerMin(); //取数字最小值
        getCollectionsSwap();//swap  交换元素位置
        getCollectionsReverse();//reverse  反向排序
        getCollectionsRotate();//rotate  旋转

        getCollectionsIntegerMax();

        System.out.println("=======");
        System.out.println((int)'中');
        System.out.println((int)'法');
        System.out.println((int)'国');
        System.out.println((int)'中');
        System.out.println((int)'人');

        getCollectionsIntegerMin2();

    }


    /**
     * 得到集合元素中,元素首个字符最大的
     */
    public static void getCollectionsMax(){
        List<String> list = new ArrayList<String>();
        list.add("az");
        list.add("b");
        String max = Collections.max(list);
        System.out.println(max);
    }

    /**
     * 得到集合元素中,元素首个字符最小的
     */
    public static void getCollectionsMin(){
        System.out.println("---------元素首个字符最小的");
        List<String> list = new ArrayList<String>();
        list.add("az");
        list.add("b");
        String max = Collections.min(list);
        System.out.println(max);
    }

    public static void getCollectionsIntegerMin2(){
        System.out.println("---------元素首个字符最小的");
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(23);
        int max = Collections.min(list);
        System.out.println(max);
    }

    /**
     * 取首位字符最小值
     */
    public static void getCollectionsMin2(){
        System.out.println("------------最小值-------------");
        List<String> list = new ArrayList<String>();
        list.add("2");
        list.add("14");
        String result = Collections.min(list);
        System.out.println(result);
    }


    /**
     * 求数字最小值
     */
    public static void getCollectionsIntegerMin(){

        Comparator<String> c = new Comparator<String>() {
            public int compare(String o1, String o2) {

                if(o1 ==null && o2 == null){
                    return 0;
                }else if(o1 ==null){
                    return -1;
                }else if(o2 ==null){
                    return 1;
                }else{

                    return Integer.parseInt(o1) -  Integer.parseInt(o2);
                }
            }
        };
        List<String> list = new ArrayList<String>();
        list.add("14");
        list.add("4");
        String result = Collections.min(list,c);
        System.out.println(result);
    }


    /**
     * 求数字最小值
     */
    public static void getCollectionsIntegerMax(){

        Comparator<String> c = new Comparator<String>() {
            public int compare(String o1, String o2) {

                if(o1 ==null && o2 == null){
                    return 0;
                }else if(o1 ==null){
                    return -1;
                }else if(o2 ==null){
                    return 1;
                }else{

                    return Integer.parseInt(o2) - Integer.parseInt(o1) ;
                }
            }
        };
        List<String> list = new ArrayList<String>();
        list.add("14");
        list.add("4");
        String result = Collections.min(list,c);
        System.out.println("取最大值 4,14  ,结果为:" +result);
    }

    public static void getCollectionsSwap(){
        System.out.println("======swap  交换元素位置=====");
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("4");//8
        list.add("5");
        list.add("8");//4
        list.add("9");

        Collections.swap(list,1,3);

        for(String s:list){
            System.out.println(s);
        }

    }

    public static void getCollectionsReverse(){
        System.out.println("====== reverse  反向排序=====");
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("4");//8
        list.add("5");
        list.add("8");//4
        list.add("9");

        Collections.reverse(list);

        for(String s:list){
            System.out.println(s);
        }

    }

    public static void getCollectionsRotate(){
        System.out.println("====== rotate  旋转=====");
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("4");//8
        list.add("5");
        list.add("8");//4
        list.add("9");

        Collections.rotate(list,2); //

        for(String s:list){
            System.out.println(s);
        }

    }


}
