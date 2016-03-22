package com.opensourceteams.modules.common.java.algorithm;

import org.junit.Test;

import java.util.List;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/21  下午8:02
 * 功能描述:
 */

public class SplitArrayUtilTest {

    @Test
    public void testSplitArray(){
        byte[] bytes = new byte[1024];
        for (int i =  0 ;i< bytes.length;i++){
            bytes[i]= 10;
        }

        List<byte[]> list = SplitArrayUtil.splitArray(bytes,500, (byte) 1);
        for (byte[] sub : list){
            for (byte b : sub){
                System.out.print(b + " ");
            }
            System.out.println();
        }
        System.out.println("==========第二种遍历方式");
        for (int i = 0 ;i < list.size();i++){
            byte[] sub = list.get(i);
            for (int j = 0 ;j <sub.length;j++){
                if(j ==0){
                    byte[] values = SplitArrayUtil.getSplitValue(sub[j]);
                    System.out.print("类型:" +values[0]);
                    System.out.print("当前包数:" + values[1]);
                }else if ( j == 1){
                    System.out.println("总共包数:" +sub[j]);
                }else{
                    System.out.print(sub[j] +"\t");
                }
            }
            System.out.println();
        }
    }
}
