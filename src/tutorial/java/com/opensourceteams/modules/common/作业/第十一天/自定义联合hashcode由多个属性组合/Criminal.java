package com.opensourceteams.modules.common.作业.第十一天.自定义联合hashcode由多个属性组合;

import com.opensourceteams.modules.common.java.binary.BinaryStringUtil;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/9  下午5:58
 * 功能描述:
 */

public class Criminal {




    /**
     *  0到34个省
     */
    private int home;

    /**
     * 血型,Run,B,AB,O    5
     */
    private int boold;

    /**
     * 按1cm算,范围  0到255
     */
    private int height;
    /**
     * 按kg算,0到 255 kg
     */
    private int weight;

    public Criminal( int home,int boold,int height, int weight) {
        this.height = height;
        this.weight = weight;
        this.boold = boold;
        this.home = home;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getBoold() {
        return boold;
    }

    public void setBoold(int boold) {
        this.boold = boold;
    }

    public int getHome() {
        return home;
    }

    public void setHome(int home) {
        this.home = home;
    }

    @Override
    public int hashCode() {

        StringBuffer sb = new StringBuffer();

        System.out.println("========" +"home:" +home + " boold:" +boold + " height:" + height + " weight:" + weight );


        sb.append(BinaryStringUtil.intToBitsByByteLength(home,1));
        //sb.append(BinaryUtil.intToBitsByBitLength(boold,3));//通过bit位数:3,得到的最大整数值7
       // sb.append(BinaryUtil.intToBitsByByteLength(height,1));
        //sb.append(BinaryUtil.intToBitsByByteLength(weight,1));
        System.out.println("home:"+ BinaryStringUtil.intToBitsByByteLength(home,1));
        System.out.println("height:"+ BinaryStringUtil.intToBitsByByteLength(height,1));
        System.out.println("长度" +sb.toString().length());
        System.out.println("值:"+ BinaryStringUtil.convertIntByBit(sb.toString()));
        System.out.println("字符串" +sb.toString());



        return  BinaryStringUtil.convertIntByBit(sb.toString());
    }

    @Override
    public String toString() {
        return "home:" +home + " boold:" +boold + " height:" + height + " weight:" + weight ;
    }
}
