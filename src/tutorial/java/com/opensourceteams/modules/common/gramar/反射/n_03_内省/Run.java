package com.opensourceteams.modules.common.gramar.反射.n_03_内省;


import com.opensourceteams.modules.common.gramar.反射.n_03_内省.n_01_内省_属性的复制.Jing8Dog;

import java.beans.*;
import java.lang.reflect.Method;


/**
 * 日期: 2016-03-29  14:10
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class Run {


    public static void main(String[] args) {

        BeanInfo beanInfo = null;

        try {
            beanInfo = Introspector.getBeanInfo(Jing8Dog.class);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor p : propertyDescriptors){
                System.out.println(p.getName()); //属性名称

                System.out.println(p.getReadMethod());

                System.out.println(p.getWriteMethod());

               // Method methodWrite = p.getWriteMethod();
                //System.out.println(methodWrite.getName());

                System.out.println("===========");
            }

            MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();
            for (MethodDescriptor m : methodDescriptors){
               // System.out.println(m.getName());
                System.out.println(m.getDisplayName());
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }

    }
}
