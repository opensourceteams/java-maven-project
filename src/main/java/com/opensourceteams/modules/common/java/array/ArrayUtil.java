package com.opensourceteams.modules.common.java.array;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/11  上午6:36
 * 功能描述:
 */

public class ArrayUtil {

    /**
     * 得到子数组
     * @param array
     * @param beginIndex
     * @param endIndex
     * @return
     * @throws Exception
     */
    public static StringBuffer subArray(char[] array,int beginIndex,int endIndex) throws Exception {

        StringBuffer sb = new StringBuffer();
        if(array == null || array.length ==0){
            return null;
        }else  if(beginIndex > endIndex){
            throw new Exception("子数组结束索引不能小于开始索引");
        }else{
           // char[] newArray = new char[endIndex - beginIndex ];
            int index = 0 ;
            for (int i =0 ;i < array.length;i++){
                if(i >= beginIndex && i < endIndex){
                    //newArray[index++] = array[i];
                    sb.append(array[i]);
                }
            }
            return sb;
        }
    }

    public static StringBuffer subArray(char[] array,int length) throws Exception{
        return subArray(array,0,length);
    }

}
