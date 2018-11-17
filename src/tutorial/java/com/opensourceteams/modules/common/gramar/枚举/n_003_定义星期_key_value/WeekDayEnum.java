package com.opensourceteams.modules.common.gramar.枚举.n_003_定义星期_key_value;

/**
 * 开发者:刘文
 * 日期: 2016/12/30
 * 描述:
 */
public enum  WeekDayEnum {
    Mon(1,"周一") ,Tue(2,"周二");

    private int index;
    private String value;

    WeekDayEnum(int index,String value){
        this.index = index;
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    /**
     * 更据值找
     * @param value
     * @return
     */
    public static int getWeekDayEnumIndex(String value){

        for(WeekDayEnum weekDayEnum : WeekDayEnum.values()){
            if(weekDayEnum.value.equals(value)){
                return  weekDayEnum.getIndex();
            }
        }
        return  -1;
    }

    /**
     * 更据值找
     * @param value
     * @return
     */
    public static WeekDayEnum getWeekDayEnum(String value){

        for(WeekDayEnum weekDayEnum : WeekDayEnum.values()){
            if(weekDayEnum.value.equals(value)){
                return  weekDayEnum;
            }
        }
        return  null;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "index:" + index + "  value:" + value;
    }
}
