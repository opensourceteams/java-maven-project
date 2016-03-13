package com.opensourceteams.modules.common.gramar.集合.TreeSet比较大小字符串;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/8  下午2:21
 * 功能描述: 字符串比较
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


  /*  @Override
    public boolean equals(Object obj) {
        return false;
    }*/
/*    int i = 1 ;
    @Override
    public int hashCode() {

        return  i++;
    }*/
}


public class Run {

    public static void main(String[] args) {

        Comparator<Student> comp = new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
                if(o1 == null && o2 ==null){
                    return 0;
                }else if(o1 == null && o2 != null){
                    return -1;
                }else if(o1 != null && o2 == null){
                    return 1;
                }else{
                    return (((Student)o1).getName().compareTo (((Student)o2).getName()));
                }
            }
        };

        TreeSet<Student> ts = new TreeSet<Student>(comp);

        ts.add(new Student("p1",'男',2));
        ts.add(null);
        ts.add(new Student("p5",'男',2));
        ts.add(new Student("p3",'男',6));
        ts.add(new Student("p2",'男',8));

        System.out.println(ts.size());

        Iterator<Student> it = ts.iterator();
        while (it.hasNext()){
            Object obj = it.next();
            if(obj!=null){
                Student s = (Student) obj;
                System.out.println(s.getName() +":" + s.getAge());
            }else{
                System.out.println("空");
            }

        }


    }
}
