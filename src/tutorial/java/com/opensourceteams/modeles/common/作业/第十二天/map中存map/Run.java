package com.opensourceteams.modeles.common.作业.第十二天.map中存map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/10  下午4:08
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) {

        Map<Integer,Map<String,String>> grad = new HashMap<Integer, Map<String, String>>();

        for(int i = 1 ;i <= 10 ;i++){

            Map<String,String> classes = new HashMap<String, String>();
            for(int j = 1 ;j <= 50;j++){
                classes.put("班级:" +i +" 学号:" +j ," 学生:" + (50 * (i -1) + j));
            }
            grad.put(i,classes);
        }

       // System.out.println(grad);

        Set<Map.Entry<Integer,Map<String,String>>> entries = grad.entrySet();
        for(Map.Entry<Integer,Map<String,String>> entry : entries){
            System.out.println(entry.getKey()+":" + entry.getValue());
        }


    }
}
