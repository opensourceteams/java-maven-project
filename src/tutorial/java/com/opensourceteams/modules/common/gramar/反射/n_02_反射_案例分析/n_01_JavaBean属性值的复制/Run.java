package com.opensourceteams.modules.common.gramar.反射.n_02_反射_案例分析.n_01_JavaBean属性值的复制;

import com.opensourceteams.modules.common.java.lang.reflect.ReflectUtil;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 日期: 2016-03-29  04:38
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class Run {

    /**
     * 得到类实例的所有属性信息,(属性信息包括,类型,名称,值,等)
     */
    @Test
    public void testGetFields(){
        ManBean manBean = new ManBean("长胡子","刘德华",50,new Date(),new Date(),new Date());
        Field[] fields = new ReflectUtil<ManBean>().getDeclaredFields(manBean);
        for (Field f : fields){
            f.setAccessible(true);
            try {
                System.out.println(f.getType() + " -> " + f.getName() + " -> " + f.get(manBean));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }



    /**
     * 给类的属性赋值
     */
    @Test
    public void testSetProperties(){

        Map<Object,Object> map = new HashMap<Object, Object>();
        map.put("name","刘文");
        map.put("age","18");
        map.put("birthday",new Date());
        ManBean manBean = new ReflectUtil<ManBean>().setProperties(ManBean.class,map);
        System.out.println(manBean.getName());
        System.out.println(manBean.getAge());
        System.out.println(manBean.getBirthday());
    }


    /**
     * 两个类实例,进行属性值的复制
     */
    @Test
    public void testCopyProperties(){
        ManBean manBean = new ManBean("长胡子","刘德华",50,new Date(),new Date(),new Date());
        WomanBean womanBean = new WomanBean("生了个胖娃娃","凯丽",20,new Date(),new Date(),new Date());
        new ReflectUtil<ManBean>().copyProperties(manBean,womanBean);

        System.out.println(womanBean.getName());
        System.out.println(womanBean.getAge());
        System.out.println(womanBean.getBirthTochild());
        System.out.println(womanBean.getBirthday());
        System.out.println(womanBean.getCreateDate());
        System.out.println(womanBean.getUpdateDate());


    }

}
