package com.opensourceteams.modules.common.gramar.枚举.n_002_定义星期_value;

/**
 * 开发者:刘文
 * 日期: 2016/12/30
 * 描述:
 */
public class Run {

    public static void main(String[] args) {
        WeekDayEnum weekDayEnum = WeekDayEnum.Mon;
        if(1 == WeekDayEnum.Mon.getIndex()){
            System.out.println("周一");
        }else {
            System.out.println("非周一");
        }
    }
}
