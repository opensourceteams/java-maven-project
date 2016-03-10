package com.opensourceteams.modeles.common.gramar.集合.TreeSet比较大小字符串Bean实现Comparable;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/8  下午3:43
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) {

        TreeSet<Dog> ts = new TreeSet<Dog>();
        ts.add(new Dog("red",1,"a"));
        ts.add(new Dog("red",4,"a"));
        ts.add(new Dog("black",3,"c"));
        ts.add(new Dog("red",2,"b"));

        for (Iterator<Dog> it =  ts.iterator();it.hasNext();){
            Dog dog = it.next();
            if(dog !=null){

                System.out.println(dog.getCategory() +":" + dog.getWeight() +":" + dog.getColor());


                System.out.println(dog);
                System.out.println("--");
            }
        }
    }
}
