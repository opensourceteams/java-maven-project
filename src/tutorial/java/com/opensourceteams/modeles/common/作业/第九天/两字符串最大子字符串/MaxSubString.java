package com.opensourceteams.modeles.common.作业.第九天.两字符串最大子字符串;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/5  下午5:00
 * 功能描述:两字符串最大子字符串
 */

public class MaxSubString {

    public static void main(String[] args) {
        String a = "abcmede" ;
        String b = "cme";

        System.out.println("最大子字符串:" + findMaxSubString(a,b));

    }

    /**
     * 查找两个字符串的最大子字符串
     * @param a
     * @param b
     * @return
     */
    public static String findMaxSubString(String a,String b){

        String maxLengthString = getMaxString(a,b);
        String minString = getMinString(a,b);

        List<String> minStringList = getAllSubStringAsList(minString);

        List<String> maxStringList = getAllSubStringAsList(maxLengthString);

        //元素长度由大到小排序
        Collections.sort(minStringList,new StringLengthComparator());
        for(String s:minStringList){
            if(maxStringList.contains(s)){
                return s;
            }
        }

        return null;

    }




    public static String getSubStr(String str,int beginIndex,int length){
        if(str == null || length > str.length()){
            return null;
        }
        return str.substring(beginIndex,beginIndex + length );
    }

    public static String getMaxString(String ... strs){

        if(strs == null){
            return null;
        }

        String maxLengthStr = strs[0] ;

        for(String s: strs){
            if(s!= null && s.length() > maxLengthStr.length() ){
                maxLengthStr = s ;
            }
        }

        return maxLengthStr;
    }

    public static String getMinString(String ... strs){

        if(strs == null){
            return null;
        }


        String minLengthStr = strs[0] ;

        for(String s: strs){
            if(s!= null && s.length() < minLengthStr.length() ){
                minLengthStr = s ;
            }
        }

        return minLengthStr;
    }


    /**
     * 遍历一个字符串的所有子字符串
     * @param a
     */
    public static void getAllSubString(String a){

        for(int i = 0 ;i< a.length();i++){
            for(int j = a.length()  ;j > i;j--){
                String sub = a.substring(i,j);
                System.out.println(sub);
            }

        }
    }

    /**
     * 遍历一个字符串的所有子字符串
     * @param a
     */
    public static List<String>  getAllSubStringAsList(String a){

        List<String> list = new ArrayList<String>();

        for(int i = 0 ;i< a.length();i++){
            for(int j = a.length()  ;j > i;j--){
                list.add(a.substring(i,j));
            }

        }

        return list;
    }


}
