package com.opensourceteams.modules.common.gramar.字符串;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/5  下午4:49
 * 功能描述:取出两个字符串中的最大子字符串
 */

public class StringUtil {

    public static void main(String[] args) {
        String str = "abcdefg";
        System.out.println(getSubStr(str,2,3));


    }

    public static String getSubStr(String str,int beginIndex,int length){
        if(str == null || length > str.length()){
            return null;
        }
        return str.substring(beginIndex,beginIndex + length );
    }


}
