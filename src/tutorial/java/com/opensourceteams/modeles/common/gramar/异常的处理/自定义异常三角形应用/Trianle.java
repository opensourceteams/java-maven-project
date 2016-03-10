package com.opensourceteams.modeles.common.gramar.异常的处理.自定义异常三角形应用;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/2  下午2:26
 * 功能描述:三角形,两边之和大于第三边
 */

public class Trianle {

    private int a;
    private int b;
    private int c;

    public Trianle(){

    }

    public Trianle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }
}
