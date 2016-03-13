package com.opensourceteams.modules.common.gramar.字符串;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/5  下午3:50
 * 功能描述:
 */

public class StringConvert {

    public static void main(String[] args) {
        String str = "abcd";

        String newStr = reverseString(str);
        System.out.println(newStr);

        newStr = reverseString2("abc");
        System.out.println(newStr);
        newStr = reverseString2("abcd");
        System.out.println(newStr);

    }


    /**
     * 转换位置
     * @param str
     * @return
     */
    public static String reverseString(String str){
        if(str == null || str.length() ==1 ){
            return str ;
        }
        char[] charArray = str.toCharArray();

        char c ;
        for(int i = 0;i<charArray.length /2;i++){
            c = charArray[i];
            charArray[i] = charArray[charArray.length - i -1] ;
            charArray[charArray.length - i -1] = c;
        }
        return  new String(charArray);
    }


    /**
     * 字符串,位置反转
     * @param str
     * @return
     */
    public static String reverseString2(String str){
        if(str == null || str.length() ==1  ){
            return str ;
        }
        StringBuffer s = new StringBuffer();
        char[] charArray = str.toCharArray();
        for(int i = charArray.length -1;i >= 0 ;i --){
            s.append(charArray[i]);
        }
        return  s.toString();
    }


}
