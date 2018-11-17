package com.opensourceteams.modules.common.gramar.枚举.n_001_定义星期;

/**
 * 开发者:刘文
 * 日期: 2016/12/30
 * 描述:
 */
public class Run {

    public static void main(String[] args) {
        WeekDayEnum weekDayEnum = WeekDayEnum.Mon;
        if(weekDayEnum == WeekDayEnum.Mon){
            System.out.println("周一");
        }else {
            System.out.println("非周一");
        }
    }
}
