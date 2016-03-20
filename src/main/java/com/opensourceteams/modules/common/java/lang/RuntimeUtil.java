package com.opensourceteams.modules.common.java.lang;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/20  上午7:26
 * 功能描述:
 */

public class RuntimeUtil {


    /**
     * 执行操作系统命令,得到终端的输出内容
     * @param command
     * @return
     */
    public static byte[] getBytes(String command){
        try {
            InputStream inputStream = Runtime.getRuntime().exec(command).getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int len = 0 ;
            while ((len = inputStream.read(buffer)) != -1){
                baos.write(buffer,0,len);

            }

            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    /**
     * 得到主机名称
     * @return
     */
    public static String getHostname(){
        byte[] bytes = getBytes("hostname");
        if(bytes != null){
            return  new String(bytes);
        }
        return null;
    }
}
