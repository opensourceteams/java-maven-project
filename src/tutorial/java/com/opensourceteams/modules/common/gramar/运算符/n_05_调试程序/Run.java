package com.opensourceteams.modules.common.gramar.运算符.n_05_调试程序;

import java.util.Scanner;

/**
 * 日期: 2016-09-01  20:01
 * 开发人:刘文  -->  (liuwen@suzonedu.com)
 * 功能描述:
 */
public class Run {

    public static void main(String[] args) {
        System.out.print("请输入你的用户名：");
        Scanner aa = new Scanner(System.in);
        String name = aa.nextLine();
        System.out.print("请输入密码：");
        String key = aa.nextLine();
        if (!key.equals("000000") ) {


            System.out.println("用户信息不合法");

        }else{
            System.out.println("合法");
        }
        aa.close();

    }

}
