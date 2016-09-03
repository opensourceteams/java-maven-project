package com.opensourceteams.modules.common.gramar.运算符.n_03_打印空心三角形;

/**
 * 日期: 2016-09-01  16:54
 * 开发人:刘文  -->  (liuwen@suzonedu.com)
 * 功能描述:
 */
public class Run {

    public static void main(String[] args) {

        triangleHollow(3);
    }


    static void triangleHollow(int line) {
        // 控制打印行数
        for (int i = 1; i <= line; i++) {
            // 控制打印空格
            for (int j = 1; j <= line - i; j++) {
                System.out.print(" ");
            }
            // 控制打印*
            for (int k = 1; k <= 2 * i - 1; k++) {
                // 第一行,最后一行全部打印*
                if (i == 1 || i == line) {
                    System.out.print("*");
                } else {
                    // 第一个和最后一个打印*其余打印空格
                    if (k == 1 || k == 2 * i - 1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.println();
        }

    }
}
