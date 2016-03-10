package com.opensourceteams.theory.java.第十八章_Java_io_系统.对象序列化.序列化的控制;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/1/22  下午3:16
 * 功能描述:
 */

public class Blip2 implements Externalizable{

    public Blip2(){
        System.out.println(" Blip2 构造函数");
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip2 writeExternal");
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip2  readExternal");
    }
}
