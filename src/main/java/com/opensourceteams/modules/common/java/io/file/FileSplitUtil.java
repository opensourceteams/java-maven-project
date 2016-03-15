package com.opensourceteams.modules.common.java.io.file;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/14  下午3:47
 * 功能描述:
 */

public class FileSplitUtil {


    /**
     * 分隔文件的方法
     * @param filePath
     * @param splitPartCount
     * @return
     * @throws IOException
     */
    public static boolean fileSplit(String filePath,int splitPartCount) throws IOException {
        int partCount = splitPartCount ;
        File srcFile = new File(filePath);
        RandomAccessFile raf = new RandomAccessFile(srcFile,"r");

        long length = raf.length();

        long parkFileLength = length / partCount ;


        for (int i = 0 ;i < partCount;i++){
            raf.seek( i * parkFileLength);
            FileOutputStream fos_file = new FileOutputStream(srcFile.getAbsoluteFile() +"__" + i +"__data");
            while (true){
                fos_file.write(raf.read());
                if(i == partCount - 1){
                    if(raf.getFilePointer() >=  length){
                        break;
                    }
                }else{
                    if(raf.getFilePointer() >=  (i +1) * parkFileLength){
                        break;
                    }
                }

            }
            fos_file.close();

        }


        raf.close();
        return true;

    }

    /**
     * 文件合成
     * @param filePathList
     * @param descFilePath
     * @return
     * @throws IOException
     */
    public static boolean fileCompose(List<String> filePathList, String descFilePath) throws IOException {

        if(filePathList == null || filePathList.size() <=1){
            return  false;
        }

        FileOutputStream fos = new FileOutputStream(descFilePath);

        byte[] buffer = new byte[1024];
        for (String s : filePathList){

            FileInputStream fis = new FileInputStream(s);
            int len = 0 ;
            while ((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }

            fis.close();

        }
        fos.close();
        return true;

    }
}
