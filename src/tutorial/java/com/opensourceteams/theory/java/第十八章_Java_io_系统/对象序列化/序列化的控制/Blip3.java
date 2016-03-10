package com.opensourceteams.theory.java.第十八章_Java_io_系统.对象序列化.序列化的控制;

import java.io.*;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/1/22  下午3:36
 * 功能描述:
 */

public class Blip3 implements Externalizable {
    private int i;
    private String s;
    public Blip3(){
        System.out.println("Blip3");
    }

    public Blip3(String _s, int _i){
        this.i = _i;
        this.s = _s;
        System.out.println("Blip3 两参");
    }

    @Override
    public String toString() {
        return s + i;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("Blip3 writeExternal");
        out.writeObject(s);
        out.writeInt(i);

    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("Blip3 readExternal");
        s = (String)in.readObject();
        i = in.readInt();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String file = "src/tutorial/resources/output/blip3" ;

        /**
         * 写
         */
        Blip3 blip3 = new Blip3("Hello",47);
        System.out.println(blip3);
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        out.writeObject(blip3);
        out.close();

        /**
         * 读
         */
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Blip3 b = (Blip3) in.readObject();
        System.out.println(b);


    }
}
