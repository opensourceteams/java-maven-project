package com.opensourceteams.modules.common.java.binary;

import com.opensourceteams.modules.common.gramar.网络编程.案例分析.n_01_简体qq聊天器.n_07_简体qq聊天器_服务器去重登录用户集合.server.network.ServerPushOnlineUserSetThread;
import org.junit.Test;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/22  下午12:07
 * 功能描述:
 */

public class ByteUtilTest {

    /**
     * 整数转换成byte数组
     */
    @Test
    public void testToBytesByInt(){
        byte[] b = ByteUtil.toBytesByInt(19878);
        System.out.println(b);
    }

    /**
     * int 转 byte数组 正数
     */
    @Test
    public void testToIntByBytes(){
        byte[] b = ByteUtil.toBytesByInt(19878);
        int value  = ByteUtil.toIntByBytes(b);
        System.out.println(value);
    }

    /**
     * int 转 byte数组 负数
     */
    @Test
    public void testToIntByBytes2(){
        byte[] b = ByteUtil.toBytesByInt(-19878);
        int value  = ByteUtil.toIntByBytes(b);
        System.out.println(value);
    }


    /**
     * long 转换成byte数组
     */
    @Test
    public void testToBytesByLong(){
        byte[] b = ByteUtil.toBytesByLong(19878);
        System.out.println(b);
    }

    /**
     * long 转 byte数组 正数
     */
    @Test
    public void testToLongByBytes(){
        byte[] b = ByteUtil.toBytesByLong(19878);
        long value  = ByteUtil.toLongByBytes(b);
        System.out.println(value);
    }

    /**
     * long 转 byte数组 负数
     */
    @Test
    public void testToLongByBytesNegative(){

        byte[] b = ByteUtil.toBytesByLong(-19878);
        long value  = ByteUtil.toLongByBytes(b);
        System.out.println(value);
    }




}
