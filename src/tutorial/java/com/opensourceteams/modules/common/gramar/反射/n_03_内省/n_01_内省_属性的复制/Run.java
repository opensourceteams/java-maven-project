package com.opensourceteams.modules.common.gramar.反射.n_03_内省.n_01_内省_属性的复制;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * 日期: 2016-03-29  14:30
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class Run {

    public static void main(String[] args) {

        Jing8Dog jing8Dog = new Jing8Dog();
        jing8Dog.setName("a");
        jing8Dog.setBlood(1);
        jing8Dog.setOwner("b");
        jing8Dog.setType("c");


        Jing9Dog jing9Dog = new Jing9Dog();

        try {


            Class clazz  =  Jing8Dog.class;

            BeanInfo beanInfo9 =  Introspector.getBeanInfo(jing9Dog.getClass());
            PropertyDescriptor[] propertyDescriptors9 =  beanInfo9.getPropertyDescriptors();
            for (PropertyDescriptor p : propertyDescriptors9){

                if(p.getWriteMethod() != null){
                    Method method = p.getWriteMethod();

                    Object obj = getGetPropertityValue(jing8Dog,p);
                    if(obj == null){
                        //System.out.println("");
                    }else{
                        method.invoke(beanInfo9,obj);
                    }


                }
                System.out.println(p.getName());
                System.out.println(p.getWriteMethod());
                System.out.println(p.getWriteMethod());
                System.out.println(p.getReadMethod().getName());
                System.out.println(p.getReadMethod().getReturnType());
                System.out.println(p.getReadMethod().getParameterTypes());
                System.out.println();
            }




          /*  for (PropertyDescriptor p : propertyDescriptors){
                Method readMethod = p.getReadMethod();
                Object value = readMethod.invoke(jing8Dog);
                System.out.println("value:" + value);

                //System.out.println(p.getReadMethod());
               // System.out.println(p.getWriteMethod());

            }*/
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println(jing9Dog.getName());
        System.out.println(jing9Dog.getBlood());
    }


    public static <T> Object getGetPropertityValue(T t, PropertyDescriptor propertyDescriptor){
        try {
            BeanInfo beanInfo =  Introspector.getBeanInfo(t.getClass());
            PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor p : propertyDescriptors){
                Method method = p.getReadMethod();
                Method method1 = propertyDescriptor.getReadMethod();
                if(method!= null && method1 != null && method.getName().equals(method1.getName())){
                    if(method.getReturnType() == method1.getReturnType()){
                        if(method.getParameterTypes() == method1.getParameterTypes()){
                            return method.invoke(t) ;
                        }
                    }
                }
            }

        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;

    }
}
