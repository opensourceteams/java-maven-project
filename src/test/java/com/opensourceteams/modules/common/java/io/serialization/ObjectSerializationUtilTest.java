package com.opensourceteams.modules.common.java.io.serialization;

import com.opensourceteams.modules.common.java.io.file.ObjectSerializationUtil;
import com.opensourceteams.modules.common.java.io.serialization.data.object.Cat;
import com.opensourceteams.modules.common.java.io.serialization.data.object.Person;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/14  下午5:05
 * 功能描述:
 */

public class ObjectSerializationUtilTest {

    /**
     * 序列化和反序列化 基本对象
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Test
    public void testObjectSerialization() throws IOException, ClassNotFoundException {
        String[] arry = {"a","b","c"};
        byte[] b = ObjectSerializationUtil.objectSerialization(arry);
        Object objDeserialize = ObjectSerializationUtil.objectDeserialize(b);

        String[] newArray =  (String[])objDeserialize;
        for(String s: newArray){
            System.out.println(s);
        }

    }

    /**
     * 序列化和反序列化 自定义对象
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Test
    public void testCustomerObjectListSerialization() throws IOException, ClassNotFoundException {
        Cat c1 = new Cat("小花",10);
        byte[] b = ObjectSerializationUtil.objectSerialization(c1);

        Object objDeserialize = ObjectSerializationUtil.objectDeserialize(b);
        if(objDeserialize != null && objDeserialize instanceof Cat){
            Cat newCat = (Cat)objDeserialize;
            System.out.println(newCat.getName() + ":" + newCat.getAge());
        }


    }


    /**
     * 序列化和反序列化 自定义关联对象
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Test
    public void testCustomerRelateObjectSerialization() throws IOException, ClassNotFoundException {
        Cat c1 = new Cat("小花",10);
        Person p = new Person("小明",12,c1);
        byte[] b = ObjectSerializationUtil.objectSerialization(p);

        Object objDeserialize = ObjectSerializationUtil.objectDeserialize(b);
        if(objDeserialize != null && objDeserialize instanceof Person){
            Person newPerson = (Person)objDeserialize;
            Cat newCat = newPerson.getCat();
            System.out.println(newPerson.getName() + ":" + newPerson.getAge() +" cat --->" +newCat.getName() +":" + newCat.getAge());
        }


    }

    /**
     * 序列化和反序列化 自定义关联对象,引用对象是临时的,不进行复制 临时的对象 transient
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Test
    public void testCustomerRelateObjectTransientSerialization() throws IOException, ClassNotFoundException {
        Cat c1 = new Cat("小花",10);
        Person p = new Person("小明",12,c1);
        byte[] b = ObjectSerializationUtil.objectSerialization(p);

        Object objDeserialize = ObjectSerializationUtil.objectDeserialize(b);
        if(objDeserialize != null && objDeserialize instanceof Person){
            Person newPerson = (Person)objDeserialize;
            Cat newCat = newPerson.getCat();
            System.out.println(newPerson.getName() + ":" + newPerson.getAge() +" cat --->" +newCat);
        }


    }

    /**
     * 序列化和反序列化 自定义对象 集合
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @Test
    public void testCustomerObjectSerialization() throws IOException, ClassNotFoundException {
        List<Cat> list = new ArrayList<Cat>();

        for (int i = 0;i < 100 ;i++){
            Cat c1 = new Cat("小花" +i,10 +i);
            list.add(c1);
        }

        byte[] b = ObjectSerializationUtil.objectSerialization(list);

        Object objDeserialize = ObjectSerializationUtil.objectDeserialize(b);
        if(objDeserialize != null && objDeserialize instanceof List){
            List<Cat> newList = (List<Cat>)objDeserialize;
            for(Cat subC : newList){
                System.out.println(subC.getName() + ":" + subC.getAge());
            }

        }


    }





}
