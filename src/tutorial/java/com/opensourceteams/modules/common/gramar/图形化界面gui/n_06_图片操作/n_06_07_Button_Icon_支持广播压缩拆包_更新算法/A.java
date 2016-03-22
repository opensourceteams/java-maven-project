package com.opensourceteams.modules.common.gramar.图形化界面gui.n_06_图片操作.n_06_07_Button_Icon_支持广播压缩拆包_更新算法;

import java.util.UUID;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/22  上午8:35
 * 功能描述:
 */

public class A {

    public static void main(String[] args) {
        String uuid = UUID.randomUUID().toString();
        String lastUUID = "";
        System.out.println(uuid);
        System.out.println(uuid.getBytes().length);
        System.out.println(uuid.replaceAll("-",""));
        System.out.println(uuid.replaceAll("-","").getBytes().length);

        System.currentTimeMillis();
        System.out.println( System.currentTimeMillis());

        while (true){

            uuid = UUID.randomUUID().toString();

            System.out.println( System.currentTimeMillis());
            System.out.println(uuid.replaceAll("-",""));
            System.out.println(uuid.compareTo(lastUUID));

            lastUUID =uuid;
        }
    }
}
