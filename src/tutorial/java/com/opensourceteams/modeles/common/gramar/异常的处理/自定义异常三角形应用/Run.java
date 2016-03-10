package com.opensourceteams.modeles.common.gramar.异常的处理.自定义异常三角形应用;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/2  下午2:28
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) {
        Trianle t = new Trianle(4,1,8);

        if(t.getA() + t.getB() <= t.getC() || t.getA() + t.getC() <= t.getB() || t.getB() + t.getC() <= t.getA()){
            try {
                throw new CustomerException("不符合三角形定义");
            } catch (CustomerException e) {
                System.out.println(e.getInfo());
            }
        }
    }
}
