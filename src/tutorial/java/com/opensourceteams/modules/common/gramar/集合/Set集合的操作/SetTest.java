package com.opensourceteams.modules.common.gramar.集合.Set集合的操作;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/18  下午12:06
 * 功能描述:
 */

public class SetTest {

    /**
     * Set 元素的增加
     */
    @Test
    public void testSetAdd(){
        Set<String> set = new HashSet<String>();
        set.add("a");
        set.add("b");
        set.add("中国");

        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
