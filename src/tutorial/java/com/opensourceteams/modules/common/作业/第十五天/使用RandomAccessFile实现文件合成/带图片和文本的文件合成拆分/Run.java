package com.opensourceteams.modules.common.作业.第十五天.使用RandomAccessFile实现文件合成.带图片和文本的文件合成拆分;

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

        String[] srcFiles = {"src/tutorial/resources/data/input/a.txt","src/tutorial/resources/data/input/b.txt","src/tutorial/resources/data/input/hadoop-logo.jpg"};
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
        FileOutputStream fos = null;

        int fileType = 0; //读取到的当前文件类型

        byte[] byteArrayFileLength = null;

        byte[] buffer = new byte[1024];


        int fileLength = 0 ;//读取到的当前文件长度


        int totalLeng = 0 ;

        int len = 0 ;
        boolean isBeginFile = true;




        while ((len = raf.read(buffer))  != -1){

            //又是一个新文件
            if(isBeginFile){

                fileType = buffer[0];
                //fos.close();
                fos = new FileOutputStream(getFileSplitName(file,fileCount++,fileType));
                byteArrayFileLength= Arrays.copyOfRange(buffer,1,5);
                fileLength = IntConvertEachBinary.getIntByArray(byteArrayFileLength) ;//读取到的当前文件长度

            }

            //读文件的内容
            if(1 + 4 + fileLength < len){
                fos.write(buffer,5,fileLength);
            }else{



                if(isBeginFile){

                    //System.out.print(new String(buffer,5,len - 5));
                    fos.write(buffer,5,len - 5);
                }else{
                    //System.out.print(new String(buffer,0,len));
                    fos.write(buffer,0,len);

                }


            }




            if (raf.getFilePointer() >= 1 + 4 + fileLength   ){
                totalLeng = totalLeng + 1 + 4 + fileLength;

                raf.seek(totalLeng );
                isBeginFile = true;

                //deleteFilePath = getFileSplitName(file,fileCount++,fileType);

                //fos = new FileOutputStream(deleteFilePath) ;

                continue;
            }else{
                isBeginFile = false;
            }

        }

        fos.close();
        raf.close();

       // new File(deleteFilePath).deleteOnExit();

        return true;

    }

    /**
     * 文件的合成1
     * 第一个文件为文件类型,写死的,都是文本文件,所以类型都为0
     * ).一个文件的报文分为三块,
     *      第一块:1个byte来存储文件类型    1:为jpg格式文件  0:为txt文件格式
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

            if(".jpg".equals(srcFiles[i].substring(srcFiles[i].lastIndexOf(".")).toLowerCase())){
                fos.write((byte)1);//文本文件:0 ,jpg:1
            }else{
                fos.write((byte)0);//文本文件:0 ,jpg:1
            }




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

    /**
     * 得到分隔后的文件名称
     * @param file
     * @param number
     * @param fileType
     * @return
     * @throws Exception
     */
    public static String getFileSplitName(File file, int number,int fileType) throws Exception {
        String newFilePath = "";
        if(file == null){
            throw new Exception("文件不能为空");
        }else if(file.isDirectory()){
            throw new Exception("文件不能是目录");
        }else{
            int index = file.getName().lastIndexOf(".");

            String fileShuffix = "";
            if(fileType == 1){
                fileShuffix = ".jpg";
            }else{
                fileShuffix = ".txt";
            }

            newFilePath = file.getParentFile().getAbsolutePath() +"/" + file.getName().substring(0,index)+"__" +number+ fileShuffix ;
        }
        return newFilePath;
    }
}
