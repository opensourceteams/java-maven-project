package com.opensourceteams.modules.common.作业.day4;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/2/27  上午9:32
 * 功能描述:
 */

public class BaseTypeDemo {


    public static void main(String[] args) {

        byte b1 = 127;

        System.out.println("bype:" + b1);

        System.out.println("自动转换为int:" + (b1 + 1 ));
        /**
         * 常量128是不能直接赋值给byte,放不下,编译不能通过,但是如果是将int 128 进行数类型转换,那就会把多的部分给裁掉
         */
        System.out.println("常128是不能直接放到byte中" + (byte)(b1 + 1 ));

        short short1 = 12;
        System.out.println("short:" + short1);

        int i1 = 1 ;
        System.out.println("int:" + i1);


        long l1 = 1L;

        System.out.println("long:"+l1);


        double d1 = 1.12;
        System.out.println("double:"+d1);


        float f1 = 1.21f;
        System.out.println("float"+f1);


    }


}
