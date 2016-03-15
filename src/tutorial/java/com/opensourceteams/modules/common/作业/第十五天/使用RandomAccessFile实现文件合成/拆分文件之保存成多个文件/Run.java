package com.opensourceteams.modules.common.作业.第十五天.使用RandomAccessFile实现文件合成.拆分文件之保存成多个文件;

import com.opensourceteams.modules.common.java.binary.IntConvertEachBinary;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/15  下午12:22
 * 功能描述:
 */

public class Run {

    public static String srcFile = "src/tutorial/resources/data/input/a.txt" ;
    public static String descFile = "src/tutorial/resources/data/input/a_compose.txt" ;

    public static void main(String[] args) throws Exception {

        String[] srcFiles = {"src/tutorial/resources/data/input/a.txt","src/tutorial/resources/data/input/b.txt"};
        fileCompose(srcFiles,descFile);
        fileSplit(descFile);
    }

    /**
     * 文件分隔
     * @param srcPath
     * @throws Exception
     */
    public static boolean fileSplit(String srcPath) throws Exception {
        File file = new File(srcPath);
        if(file.isDirectory()){
            throw  new Exception("是一个目录:"+srcPath);
        }

        RandomAccessFile raf = new RandomAccessFile(srcPath,"r");
        int fileCount = 0 ;//拆分的文件的个数
        FileOutputStream fos = new FileOutputStream(getFileSplitName(file,fileCount++));

        int fileType = 0; //读取到的当前文件类型

        byte[] byteArrayFileLength = null;

        byte[] buffer = new byte[1024];


        int fileLength = 0 ;//读取到的当前文件长度


        int totalLeng = 0 ;

        int len = 0 ;
        boolean isBeginFile = true;

        String deleteFilePath = "";

        while ((len = raf.read(buffer))  != -1){

            //又是一个新文件
            if(isBeginFile){
                fileType = buffer[0];
                byteArrayFileLength= Arrays.copyOfRange(buffer,1,5);
                fileLength = IntConvertEachBinary.getIntByArray(byteArrayFileLength) ;//读取到的当前文件长度

            }

            //读文件的内容
            if(1 + 4 + fileLength < len){
                System.out.print(new String(buffer,5,fileLength));
                fos.write(buffer,5,fileLength);
            }else{
                System.out.print(new String(buffer,5,len - 5));
                fos.write(buffer,5,len - 5);
            }




            if (raf.getFilePointer() >= 1 + 4 + fileLength   ){
                totalLeng = totalLeng + 1 + 4 + fileLength;

                raf.seek(totalLeng );
                isBeginFile = true;

                deleteFilePath = getFileSplitName(file,fileCount++);

                fos = new FileOutputStream(deleteFilePath) ;

                continue;
            }

        }

        fos.close();
        raf.close();

        new File(deleteFilePath).deleteOnExit();

        return true;

    }

    /**
     * 文件的合成
     * 第一个文件为文件类型,写死的,都是文本文件,所以类型都为0
     * @param srcFiles
     * @param descFile
     * @throws IOException
     */
    public static void fileCompose(String[] srcFiles, String descFile) throws IOException {

        FileOutputStream fos = new FileOutputStream(descFile);
        RandomAccessFile raf = null;

        int len = 0 ;

        for (int i = 0 ;i< srcFiles.length ;i ++){

            raf = new RandomAccessFile(srcFiles[i],"r");

            fos.write((byte)0);//文本文件:0 ,jpg:1

            fos.write(IntConvertEachBinary.convertIntToByteArry((int)raf.length()));

            raf.seek(0);
            while ((len = raf.read()) != -1){
                fos.write(len);
            }

        }

        if(raf != null){
            raf.close();
        }

        fos.close();
    }

    public static String getFileSplitName(File file, int number) throws Exception {
        String newFilePath = "";
        if(file == null){
            throw new Exception("文件不能为空");
        }else if(file.isDirectory()){
            throw new Exception("文件不能是目录");
        }else{
            int index = file.getName().lastIndexOf(".");

            newFilePath = file.getParentFile().getAbsolutePath() +"/" + file.getName().substring(0,index)+"__" +number+ file.getName().substring(index) ;
        }
        return newFilePath;
    }
}
