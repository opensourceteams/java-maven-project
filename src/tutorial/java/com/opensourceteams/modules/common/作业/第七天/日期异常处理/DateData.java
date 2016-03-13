package com.opensourceteams.modules.common.作业.第七天.日期异常处理;

import com.opensourceteams.modules.common.gramar.异常的处理.自定义异常三角形应用.CustomerException;

import java.util.Calendar;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/2  下午3:42
 * 功能描述:
 */

public class DateData {

    private int year;
    private int month;
    private int day;

    public DateData(){}

    public DateData(int year, int month, int day) throws CustomerException {
        validDate(year,month,day);
        this.year = year;
        this.month = month;
        this.day = day;
    }

    void validDate(int year, int month, int day) throws CustomerException{
        if(year < 1900 || year > Calendar.getInstance().get(Calendar.YEAR)){
                throw new CustomerException("年份非法数据");
        }else if(month < 1 || month > 12){
            throw new CustomerException("月份非法数据");
        }else {
            int calDay = CalendarUtil.getMonthDate(year,month);
            if(day < 0 || day > calDay){
                throw new CustomerException("日期非法数据");
            }

        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
