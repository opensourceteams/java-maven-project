package com.opensourceteams.modeles.jialin.java.quitstart;

import java.nio.IntBuffer;

/**
 * 开发: 刘文
 * 邮箱: Email:372065525@qq.com
 * 日期: 16/2/5   上午6:29
 * 功能:
 */
public class JavaNio {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(100);
        System.out.println("Postition:" + intBuffer.position() +", limit:" + intBuffer.limit() + ",Capacity:" + intBuffer.capacity());

        int[] data = {9,8,7,6,5,4,3,2,1,0};
        intBuffer.put(10);
        System.out.println("Postition:" + intBuffer.position() +", limit:" + intBuffer.limit() + ",Capacity:" + intBuffer.capacity());

        intBuffer.put(data);
        System.out.println("Postition:" + intBuffer.position() +", limit:" + intBuffer.limit() + ",Capacity:" + intBuffer.capacity());

        intBuffer.flip();
        System.out.println("Postition:" + intBuffer.position() +", limit:" + intBuffer.limit() + ",Capacity:" + intBuffer.capacity());

        if(intBuffer.hasRemaining()){
            System.out.printf("v:" + intBuffer.get());
        }


    }


}
