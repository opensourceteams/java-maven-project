package com.opensourceteams.modules.common.gramar.枚举.n_002_定义星期_value;

/**
 * 开发者:刘文
 * 日期: 2016/12/30
 * 描述:
 */
public enum WeekDayEnum {
    Mon(1),Tue(2),Wed(3),Thu(4),Fri(5),Sat(6),Sun(7) ;

    private int index;

     WeekDayEnum(int index){
        this.index = index;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
