package com.opensourceteams.modules.common.java.algorithm;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/21  下午1:59
 * 功能描述:
 */

public class NextValueUtil {

    /**
     * 当前值,得到下一个值,有最大值,当等于大于最大值时,返回0
     * @param currentValue
     * @param maxValue
     * @return
     */
    public static int getNextValue(int currentValue,int maxValue){
        if(currentValue < maxValue){
            return currentValue +1 ;
        }else{
            return 0;
        }

    }
}
