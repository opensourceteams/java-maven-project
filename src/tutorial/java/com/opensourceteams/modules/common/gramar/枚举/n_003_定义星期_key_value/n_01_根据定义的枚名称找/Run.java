package com.opensourceteams.modules.common.gramar.枚举.n_003_定义星期_key_value.n_01_根据定义的枚名称找;

import com.opensourceteams.modules.common.gramar.枚举.n_003_定义星期_key_value.WeekDayEnum;

/**
 * 开发者:刘文
 * 日期: 2016/12/30
 * 描述:
 */
public class Run {

    public static void main(String[] args) {

        WeekDayEnum weekDayEnum =  WeekDayEnum.valueOf("Mon");
        System.out.println(weekDayEnum.getIndex());
        System.out.println(weekDayEnum.getValue());
    }
}
