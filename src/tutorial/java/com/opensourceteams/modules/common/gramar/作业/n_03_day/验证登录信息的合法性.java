package com.opensourceteams.modules.common.gramar.作业.n_03_day;

import java.util.Scanner;

/**
 * 日期: 2016-09-03  22:58
 * 开发人:刘文  -->  (liuwen@suzonedu.com)
 * 功能描述:
 */
public class 验证登录信息的合法性 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名:");
        String username = scanner.nextLine();
        System.out.println("密码");
        String password = scanner.nextLine();

        if(!"000000".equals(password)){
            System.out.println("用户信息不合法");
        }else {
            System.out.println("合法");
        }
    }
}
