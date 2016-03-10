package com.opensourceteams.theory.java.第十八章_Java_io_系统.对象序列化.序列化的控制;

import java.io.*;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/1/22  下午3:18
 * 功能描述:
 */

public class Blips {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("main入口");
        Blip1 blip1 = new Blip1();
        Blip2 blip2 = new Blip2();
        String file = "src/tutorial/resources/output/BLips.out";
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(file));
        o.writeObject(blip1);
        o.writeObject(blip2);
        o.close();
        /**
         *
         */
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));

        Blip1 b1 = (Blip1)in.readObject();
        Blip2 b2 = (Blip2)in.readObject();
        System.out.println("Blip1:" + b1);
        System.out.println("Blip2:" + b2);

    }
}
