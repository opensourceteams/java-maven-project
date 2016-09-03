package com.opensourceteams.modules.common.gramar.运算符.n_01_加密运算;

import java.util.Scanner;

/**
 * 日期: 2016-09-01  14:21
 * 开发人:刘文  -->  (liuwen@suzonedu.com)
 * 功能描述:
 */
public class Run {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        String entry = strToEncryptionAndDecoding(line, 12335);
        System.out.println("加密后的数据:" + entry);

        String decoding = strToEncryptionAndDecoding(entry, 12335);
        System.out.println("加密后的数据:" + decoding);
    }

    /**
     * 对字符串进行加密和解密
     *
     * @param str    原字符串
     * @param enctry 加密密钥
     * @return
     */
    public static String strToEncryptionAndDecoding(String str, int enctry) {
        StringBuffer sb = new StringBuffer();
        char v = 'a';
        for (int i = 0; i < str.length(); i++) {
            v = (char) (str.charAt(i) ^ enctry);
            sb.append(v);


        }
        return sb.toString();
    }
}


