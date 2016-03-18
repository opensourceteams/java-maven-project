package com.opensourceteams.modules.common.java.util;

import java.util.Set;
import java.util.Vector;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/18  上午9:54
 * 功能描述:
 */

public class SetConverUtil {


    /**
     * set 转化为 Vector
     * @param set
     * @return
     */
    public static Vector convertVector(Set set ){
        Vector vector = new Vector(set);
        return vector;
    }
}
