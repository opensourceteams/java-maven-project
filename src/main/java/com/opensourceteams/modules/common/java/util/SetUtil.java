package com.opensourceteams.modules.common.java.util;

import java.util.Iterator;
import java.util.Set;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/18  下午12:19
 * 功能描述:
 */

public class SetUtil {


    /**
     * 打印输出 Set 的所有子元素
     * @param set
     */
    public static void println(Set set){
        if(set != null){
            Iterator it = set.iterator();
            while (it.hasNext()){
                System.out.println(it.next());
            }
        }

    }
}
