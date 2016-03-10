package com.opensourceteams.modeles.common.gramar.异常的处理.自定义异常处理;

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

    public void setAge(int age) throws AgeTooBigException,AgeTooSmallException {
        if(  age > 100){
            throw new AgeTooBigException("年龄太大");
        }else  if(  age < 0){
            throw new AgeTooSmallException("年龄太小");
        }
        this.age = age;
    }

    /**
     *  throws AgeTooBigException,AgeTooSmallException
     * @param args
     */
    public static void main(String[] args) {

        Person person = new Person();


        try {
            person.setAge(-150);
        }catch (AgeTooBigException e) {
            System.out.println(e.getInto());
            System.exit(-1);
        }catch (AgeTooSmallException e) {

            System.out.println(e.getInto());
            System.exit(-1);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }


        System.out.println(person.getAge());

    }
}
