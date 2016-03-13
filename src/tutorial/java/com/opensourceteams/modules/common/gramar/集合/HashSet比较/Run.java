package com.opensourceteams.modules.common.gramar.集合.HashSet比较;


import java.util.HashSet;
import java.util.Set;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/8  上午10:38
 * 功能描述:
 */


class Student{

    private String name;
    private char sex;
    private int age;

    public Student(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public boolean equals(Object obj) {
        return false;
    }
/*    int i = 1 ;
    @Override
    public int hashCode() {

        return  i++;
    }*/
}



public class Run {

    public static void main(String[] args) {

        Student  p1 = new Student("a",'男',12);

        Student  p2 = new Student("a",'男',1);
        Set<Student> set = new HashSet<Student>();
        set.add(p1);
        set.add(p1);


        set.add(p2);




        System.out.println(set.size());


    }
}
