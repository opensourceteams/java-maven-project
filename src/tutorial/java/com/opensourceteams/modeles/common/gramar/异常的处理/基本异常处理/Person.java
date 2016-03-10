package com.opensourceteams.modeles.common.gramar.异常的处理.基本异常处理;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/2  上午11:22
 * 功能描述:
 */

public class Person {

    private  int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws Exception {
        if( age < 0 || age > 100){
            throw new Exception("年龄非法");
        }
        this.age = age;
    }

    public static void main(String[] args) throws Exception {

        Person person = new Person();


/*        try {
            person.setAge(-3);
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        person.setAge(-3);


    }
}
