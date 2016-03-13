package com.opensourceteams.modules.common.作业.第九天.两字符串最大子字符串;

import java.util.Comparator;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/6  上午10:30
 * 功能描述:
 */

public class StringLengthComparator implements Comparator {


    /**
     * 由大到小排序
     * @param o1
     * @param o2
     * @return
     */
    public int compare(Object o1, Object o2) {

        if(o1 == null && o2 == null){
            return 0;
        }else if (o1 == null){
            return 1;
        }else if (o2 == null){
            return -1;
        }else{
            if( o1.toString().length() ==  o2.toString().length()){
                return 0;
            }else  if( o1.toString().length() <  o2.toString().length()){
                return 1;
            }else  if( o1.toString().length() >  o2.toString().length()){
                return -1;
            }
        }

        return 0;
    }
}
