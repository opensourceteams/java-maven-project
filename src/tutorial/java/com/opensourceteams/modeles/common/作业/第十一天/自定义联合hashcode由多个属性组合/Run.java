package com.opensourceteams.modeles.common.作业.第十一天.自定义联合hashcode由多个属性组合;

import com.opensourceteams.modeles.common.gramar.二进制.十进制轩二进制表示.BinaryUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/9  下午6:07
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) {


        HashSet<Criminal> hashSet = new HashSet<Criminal>();


        Criminal c3 = new Criminal(171,2,185,145);
        Criminal c1 = new Criminal(170,1,180,140);
        Criminal c2 = new Criminal(175,2,185,145);
        Criminal c4 = new Criminal(175,5,185,145);
        Criminal c5 = new Criminal(175,1,185,145);



        hashSet.add(c1);
        hashSet.add(c2);
        hashSet.add(c3);
        hashSet.add(c4);
        hashSet.add(c5);

        for (Criminal c : hashSet){
            System.out.println(c);
        }

        //Collections.sort(hashSet);
/*        TreeSet<Criminal> ts = new TreeSet(hashSet);
        ts.comparator();
        for(Criminal c : hashSet){
            System.out.println(c);
        }*/


    }
}
