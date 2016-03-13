package com.opensourceteams.modules.common.gramar.集合.TreeSet比较大小字符串Bean实现Comparable;


/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/8  下午3:33
 * 功能描述:
 */

public class Dog implements Comparable {

    private String color;
    private int weight;
    private String category;


    public Dog(String color, int weight, String category) {
        this.color = color;
        this.weight = weight;
        this.category = category;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return category +":" + color +":" + weight;
    }

    public int compareTo(Object o) {

        if(o == null){
            return -1;
        }
        if(o instanceof  Dog){
            Dog dog = (Dog) o;
            int catResult = this.category.compareTo(dog.category);
            if(catResult != 0){
                return catResult;
            }else{
                int colRes = this.color.compareTo(dog.getColor());
                if(colRes!=0){
                    return colRes;
                }else{
                    return this.weight - dog.weight;
                }
            }
            //品种不同


        }
        return 0;
    }
}
