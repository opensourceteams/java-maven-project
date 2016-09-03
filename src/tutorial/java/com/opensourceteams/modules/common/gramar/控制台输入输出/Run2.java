package com.opensourceteams.modules.common.gramar.控制台输入输出;

import java.util.Scanner;

/**
 * 日期: 2016-08-26  22:20
 * 开发人:刘文  -->  (liuwen@suzonedu.com)
 * 功能描述:
 */
public class Run2 {

    public static void main(String[] args) {
        System.out.println("请输入第一个数:");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        System.out.println();
        System.out.println("请输入第二个数:");
        String line2 = scanner.nextLine();
        System.out.println(line + " + " + line2 +" = " + (Integer.parseInt(line) + Integer.parseInt(line2) )  );
        scanner.close();
    }

}
