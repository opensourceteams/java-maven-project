package com.opensourceteams.modules.common.gramar.运算符.n_02_更精确地使用浮点数;

import java.math.BigDecimal;

/**
 * 日期: 2016-09-01  14:40
 * 开发人:刘文  -->  (liuwen@suzonedu.com)
 * 功能描述:
 */
public class Run2 {

    public static void main(String[] args) {
        BigDecimal money = new BigDecimal("2");
        BigDecimal price = new BigDecimal("1.10");

        BigDecimal result = money.subtract(price);
        System.out.println( result);
    }


}
