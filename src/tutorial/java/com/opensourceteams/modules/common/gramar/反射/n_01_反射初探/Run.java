package com.opensourceteams.modules.common.gramar.反射.n_01_反射初探;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 日期: 2016-03-28  16:34
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class Run {

    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("com.opensourceteams.modules.common.gramar.反射.n_01_反射初探.Student");
            Method method = clazz.getMethod("getName");
            int i = method.getModifiers();
            System.out.println(i);
            System.out.println(Modifier.isPublic(i));
            System.out.println(Modifier.isPrivate(i));

            System.out.println("=======");
            method.setAccessible(true);

            method = clazz.getDeclaredMethod("getPrivateName");
            i = method.getModifiers();
            System.out.println(i);
            System.out.println(Modifier.isPublic(i));
            System.out.println(Modifier.isPrivate(i));
            System.out.println("=======");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
