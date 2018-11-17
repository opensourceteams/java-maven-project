package com.opensourceteams.modules.common.gramar.枚举.n_003_定义星期_key_value.n_02_根据key找value;

import com.opensourceteams.modules.common.gramar.枚举.n_003_定义星期_key_value.WeekDayEnum;

/**
 * 开发者:刘文
 * 日期: 2016/12/30
 * 描述:
 */
public class Run {

    public static void main(String[] args) {
        String str = "周二";
        System.out.println(WeekDayEnum.getWeekDayEnumIndex(str));
        System.out.println(WeekDayEnum.getWeekDayEnum(str).getIndex());
        System.out.println(WeekDayEnum.getWeekDayEnum(str));
    }
}
