package com.opensourceteams.modules.common.gramar.控制台输入输出;

import java.util.Scanner;

/**
 * 日期: 2016-08-26  22:20
 * 开发人:刘文  -->  (liuwen@suzonedu.com)
 * 功能描述:
 */
public class Run {

    public static void main(String[] args) {
        System.out.println("请输入数据:");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println("你输入的数据是:"+ line);
    }

}
