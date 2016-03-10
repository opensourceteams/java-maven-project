package com.opensourceteams.modeles.common.作业.第七天.日期异常处理;

import com.opensourceteams.modeles.common.gramar.异常的处理.自定义异常三角形应用.CustomerException;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/2  下午3:43
 * 功能描述:
 */

public class Run {

    public static void main(String[] args)  {
        try {
            DateData d = new DateData(2016,03,32);
            System.out.println("日期格式正式");
        } catch (CustomerException e) {
            System.out.println(e.getInfo());
        }
    }
}
