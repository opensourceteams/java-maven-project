package com.opensourceteams.modules.common.作业.第十一天.自定义联合hashcode由多个属性组合2;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/9  下午6:07
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) {

        Comparator<Criminal>  comparator = new Comparator<Criminal>() {
            public int compare(Criminal o1, Criminal o2) {

                if(o1 == null && o2 ==null){
                    return 0;
                }else if(o1 == null && o2 != null){
                    return -1;
                }else if(o1 != null && o2 == null){
                    return 1;
                }else{
                    return Integer.parseInt(o1.getAllPro())  - Integer.parseInt(o2.getAllPro()) ;
                }

            }
        };



       // HashSet<Criminal> hashSet = new HashSet<Criminal>();

        TreeSet<Criminal> ts = new TreeSet<Criminal>(comparator);

        Criminal c3 = new Criminal(170,2,185,145);
        Criminal c1 = new Criminal(175,1,180,140);
        Criminal c2 = new Criminal(185,2,185,145);
        Criminal c4 = new Criminal(169,5,185,145);
        Criminal c5 = new Criminal(190,1,185,145);
        Criminal c6 = new Criminal(175,5,185,145);
        Criminal c7 = new Criminal(175,3,185,145);



        ts.add(c1);
        ts.add(c2);
        ts.add(c3);
        ts.add(c4);
        ts.add(c5);
        ts.add(c6);
        ts.add(c7);

        for (Criminal c : ts){
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
