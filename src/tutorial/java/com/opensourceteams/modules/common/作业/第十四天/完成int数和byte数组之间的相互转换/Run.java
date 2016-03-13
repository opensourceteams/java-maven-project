package com.opensourceteams.modules.common.作业.第十四天.完成int数和byte数组之间的相互转换;

import com.opensourceteams.modules.common.java.binary.IntConvertEachBinary;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/14  上午7:27
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) {

        byte[] newArry2 = IntConvertEachBinary.convertIntToByteArry(77765);

        int value2 = IntConvertEachBinary.getIntByArray(newArry2);
        System.out.println(value2);

        newArry2 = IntConvertEachBinary.convertIntToByteArry(-77765);

        value2 = IntConvertEachBinary.getIntByArray(newArry2);
        System.out.println(value2);
    }
}
