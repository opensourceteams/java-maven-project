package com.opensourceteams.modules.common.java.util;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/18  上午9:13
 * 功能描述:
 */

public class VectorConvertUtil {


    /**
     * 转换成Set
     * @param vector
     * @return
     */
    public Set convertSet(Vector vector){


        return new HashSet(vector);
    }
}
