package com.opensourceteams.modules.common.java.nio.charset;

import org.junit.Test;

import java.nio.charset.Charset;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/12  下午5:53
 * 功能描述:平台默认的字符集:UTF-8
 */

public class CharsetTest {

    /**
     * 验证 jdk 对字符集的支持
     字符集:gb2312 支持吗:true
     字符集:GB2312 支持吗:true
     字符集:gbk 支持吗:true
     字符集:GBK 支持吗:true
     字符集:utf-8 支持吗:true
     字符集:utf8 支持吗:true
     字符集:iso8859-1 支持吗:true
     字符集:iso-8859-1 支持吗:true
     */
    @Test
    public void testCharsetSupport(){
        String[]   charset = {"gb2312","GB2312","gbk","GBK","utf-8","utf8","iso8859-1","iso-8859-1"};

        boolean b = false;
        for(String s: charset){
            b =  Charset.isSupported(s);
            System.out.println("字符集:" +s +" 支持吗:" +b);
        }

       String defaultCharset =  Charset.defaultCharset().name();
        System.out.println("平台默认的字符集:" + defaultCharset);

    }
}
