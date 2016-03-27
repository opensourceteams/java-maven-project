package com.opensourceteams.modules.common.gramar.集合.向量vector.n_2_向量vector集合自定义类排序;

import org.junit.Test;

import java.util.Collections;
import java.util.Vector;

/**
 * 日期: 2016-03-25  08:53
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class VectorTest {

    /**
     * 验证常规排序,按放入的排序
     */
    @Test
    public void testSortNormal(){

        Vector<Person> vector = new Vector<Person>();
        vector.add(new Person("a",10));
        vector.add(new Person("b",20));
        vector.add(new Person("c",5));

        for (Person p : vector){
            System.out.println(p);
        }

    }

    /**
     * 验证常规排序,按放入的排序
     */
    @Test
    public void testSort(){

        Vector<Person> vector = new Vector<Person>();
        vector.add(new Person("a",10));
        vector.add(new Person("b",20));
        vector.add(new Person("c",5));

        for (Person p : vector){
            System.out.println(p);
        }
        System.out.println("排序后的");
        Collections.sort(vector);

        for (Person p : vector){
            System.out.println(p);
        }

    }
}
