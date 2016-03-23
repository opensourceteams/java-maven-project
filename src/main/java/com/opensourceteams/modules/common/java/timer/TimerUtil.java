package com.opensourceteams.modules.common.java.timer;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/11  下午3:55
 * 功能描述:打印时间专用
 */

public class TimerUtil {



    /**
     * 打印工作的时间,是多少毫秒
     * @param start
     */
    public static long printlnWorkerTimeMillis(long start){
        long end = System.currentTimeMillis();

        System.out.println("\n执行时间:"+ ( end -start) +"(毫秒)\t" +(( end -start) /1000 ) + "(秒)" );
        return end -start;
    }

    /**
     * 打印工作的时间,是多少毫秒
     * @param start
     */
    public static long  printWorkerTimeMillis(long start){
        long end = System.currentTimeMillis();

        System.out.print("执行时间:"+ ( end -start) +"(毫秒)\t" +(( end -start) /1000 ) + "(秒) \t" );
        return end -start;
    }


}
