package com.opensourceteams.modules.common.java.lang.reflect;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 日期: 2016-03-29  04:58
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class ReflectUtil<T> {

    /**
     * 得到类实例的所有属性信息,(属性信息包括,类型,名称,值,等)
     * @param t
     * @return
     */
    public Field[] getDeclaredFields(T t){
        Class<T> clazz = (Class<T>) t.getClass();
        return clazz.getDeclaredFields();
    }

    /**
     * 两个类实例,进行属性值的复制
     * @param t
     * @param destObject
     * @return
     */
    public Object copyProperties(T t,Object destObject){
        Field[] fields = getDeclaredFields(t);
        Field destField = null;
        for (Field f : fields) {
            f.setAccessible(true);
            try {
                destField = destObject.getClass().getDeclaredField(f.getName());
                destField.setAccessible(true);
                destField.set(destObject,f.get(t));
            } catch (NoSuchFieldException e) {

            } catch (IllegalAccessException e) {
            }
        }


        return destObject;
    }


    public List<T> setPropertiesList(Class<T> clazz, List<Map<Object,Object>> list){
        List<T> resultList = new ArrayList<T>();
        if(list != null && list.size() >0){
            for (Map<Object,Object> map : list){
                T t = setProperties(clazz,map);
                resultList.add(t);
            }
        }
        return resultList;
    }
    /**
     * 给类的属性赋值
     * @param clazz
     * @param values
     * @return
     */
    public T setProperties(Class<T> clazz, Map<Object,Object> values){

        T t = null;
        try {
            t = clazz.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Field destField = null;
        Field field = null;
        for (Map.Entry<Object,Object> entry : values.entrySet()){
            if(entry.getKey() != null){
                try {
                    field = clazz.getDeclaredField(entry.getKey().toString());
                    field.setAccessible(true);
                    if(field.getType() == int.class){
                        if(entry.getValue() == null){
                            field.set(t,0);
                        }else{
                            field.set(t,Integer.parseInt(entry.getValue().toString()));
                        }

                    }else if(field.getType() == String.class){
                        if(entry.getValue() == null){
                            field.set(t,null);
                        }else{
                            field.set(t,entry.getValue().toString());
                        }

                    }else if(field.getType() == Date.class){
                        if(entry.getValue() == null){
                            field.set(t,null);
                        }else{
                            field.set(t,(Date)entry.getValue());
                        }

                    }

                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        }

        return t;

    }

}
