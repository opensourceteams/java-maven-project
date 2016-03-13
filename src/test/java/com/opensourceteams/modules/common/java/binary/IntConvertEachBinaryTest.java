package com.opensourceteams.modules.common.java.binary;

import com.opensourceteams.modules.common.java.binary.IntConvertEachBinary;
import org.junit.Test;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/13  下午2:10
 * 功能描述:
 */

public class IntConvertEachBinaryTest {

    @Test
    public void testIntConvertEachBinary(){



        byte[] newArry2 = IntConvertEachBinary.convertIntToByteArry(77765);

        int value2 = IntConvertEachBinary.getIntByArray(newArry2);
        System.out.println(value2);

        newArry2 = IntConvertEachBinary.convertIntToByteArry(-77765);

         value2 = IntConvertEachBinary.getIntByArray(newArry2);
        System.out.println(value2);


    }






}
