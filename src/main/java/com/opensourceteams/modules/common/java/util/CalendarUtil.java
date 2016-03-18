package com.opensourceteams.modules.common.java.util;

import java.util.Calendar;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/2  下午5:58
 * 功能描述:
 */

public class CalendarUtil {

    public static String getSimpleDate(){
        Calendar c = Calendar.getInstance();

        return c.get(Calendar.YEAR) +"-" + c.get(Calendar.MONTH) +"-" +c.get(Calendar.DATE) +" " +c.get(Calendar.HOUR_OF_DAY) +":" +c.get(Calendar.MINUTE)+":" +c.get(Calendar.SECOND);
    }

    /**
     * 得到当前月有多少天
     * @return
     */
    public static int getMonthDate(){

        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH,Calendar.MONTH +1);
        c.set(Calendar.DATE,0);
        return c.get(Calendar.DATE);
    }


    /**
     * 得到当前月有多少天
     * @return
     */
    public static int getMonthDate(int year,int month){

        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR,year);
        c.set(Calendar.MONTH,month +1);
        c.set(Calendar.DATE,0);
        return c.get(Calendar.DATE);
    }
}
