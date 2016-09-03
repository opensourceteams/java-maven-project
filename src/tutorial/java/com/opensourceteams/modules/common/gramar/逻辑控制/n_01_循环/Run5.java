package com.opensourceteams.modules.common.gramar.逻辑控制.n_01_循环;

/**
 * 日期: 2016-09-03  12:07
 * 开发人:刘文  -->  (liuwen@suzonedu.com)
 * 功能描述:
 */
public class Run5 {

    public static void main(String[] args) {
        for(int i = 1;i<10;i++){


            for(int j = 1; j<= i;j++){
                System.out.print(i +" * " + j  + " = "+  (i * j) + "\t");
            }

            System.out.println();

        }
    }
}
