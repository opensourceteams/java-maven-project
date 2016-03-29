package com.opensourceteams.modules.common.gramar.反射.n_01_反射初探;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 日期: 2016-03-28  16:50
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class RunCat {



    @Test
    public void testNewClass(){
        /**
         * 创建Cat
         */

        Class clzz = null;
        try {
            clzz = Class.forName("com.opensourceteams.modules.common.gramar.反射.n_01_反射初探.Cat");

            Constructor<Cat> constructor =  clzz.getDeclaredConstructor(String.class,String.class);
            constructor.setAccessible(true);
            Cat c = constructor.newInstance("a","b");
            System.out.println(c);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    /**
     * 得到属性
     */
    @Test
    public void testGetFiled(){

        /**
         * 创建Cat
         */

        Class clazz = null;
        try {
            clazz = Class.forName("com.opensourceteams.modules.common.gramar.反射.n_01_反射初探.Cat");

            Constructor<Cat> constructor =  clazz.getDeclaredConstructor(String.class,String.class);
            constructor.setAccessible(true);
            Cat c = constructor.newInstance("小红","白色");
            System.out.println(c);

            Field fieldColor = clazz.getDeclaredField("color");
            fieldColor.setAccessible(true);
            System.out.println(fieldColor);
            System.out.println(fieldColor.getName());
            System.out.println(fieldColor.toString());

            System.out.println(fieldColor.getType());

            //fieldColor.set(c ,"白色");

           System.out.println(fieldColor.get(c));

            Field fieldName = clazz.getDeclaredField("name");
            fieldName.setAccessible(true);


            //fieldName.set(c ,"小红");

            System.out.println(fieldName.get(c));

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }


    /**
     * 得到方法
     */
    @Test
    public void testGetMethod(){

        /**
         * 创建Cat
         */

        Class clazz = null;
        try {
            clazz = Class.forName("com.opensourceteams.modules.common.gramar.反射.n_01_反射初探.Cat");

            Constructor<Cat> constructor =  clazz.getDeclaredConstructor(String.class,String.class);
            constructor.setAccessible(true);
            Cat c = constructor.newInstance("a","b");
            System.out.println(c);

            Method method = clazz.getMethod("catchMouse");
            method.invoke(c);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
