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
     * 文件拆分
     * ).需要拆分的文件A,被分成若干个小文件
     * ).每一个文件的大小是不确定的,但是文件存储是有格式的,一个文件的报文分为三块
     *      第一块:1个byte来存储文件类型    1:为jpg格式文件  0:为txt文件格式
     *      第二块:4个byte存储文件的长度
     *      第三块:文件的实际内容
     * ).可以循环去读文件A中的数据放到buffer缓冲数组中
     * ).一次读取的缓冲数组数据可能包含一个文件的所有信息
     * ).多次读取的缓冲数据的和才包含一个文件的所有信息
     * ).根据第一个文件的特殊性
     *          也就是文件A的第一个byte肯定是第一个文件的文件类型
     *               文件A的第二个byte到第五个byte肯定是第一个文件的文件长度:FileALength
     *               文件A的第六个byte到取FileALength个byte 为第一个文件的内容
     * ).文件A中包含的每个文件的长度fileLength放到while循环去计算,文件A的当前指针 >= 1 + 4 + fileLength  说明又读到了一个新文件
     * ).只要能确定每个新文件的每隔点,那就找到分隔点,保存到不同的文件中就行
     *
     *
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

                continue;
            }else{
                isBeginFile = false;
            }

        }

        fos.close();
        raf.close();
        return true;

    }

    /**
     * 文件的合成
     * ).一个文件的报文分为三块,
     *      第一块:1个byte来存储文件类型    1:为jpg格式文件  0:为txt文件格式
     *      第二块:4个byte存储文件的长度
     *      第三块:文件的实际内容
     * ).思路,遍历每一个文件进行存储到一个合成文件中
     * ).每一个文件的写入分为三块,先写类型,再写长度,最后写内容
     * )
     * @param srcFiles
     * @param descFile
     * @throws IOException
     */
    public static void fileCompose(String[] srcFiles, String descFile) throws Exception {

        FileOutputStream fos = new FileOutputStream(descFile);
        RandomAccessFile raf = null;

        int len = 0 ;
        byte[] buffer = new byte[1024]; //文件输出流的缓冲区

        for (int i = 0 ;i< srcFiles.length ;i ++){

            raf = new RandomAccessFile(srcFiles[i],"r");

            fos.write(getFileByteType(srcFiles[i]));//文本文件:0 ,jpg:1
            fos.write(IntConvertEachBinary.convertIntToByteArry((int)raf.length()));

            //raf.seek(0);
            while ((len = raf.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }

        }

        if(raf != null){
            raf.close();
        }

        fos.close();
    }

    /**
     * 根据文件路径,得到文件类型
     * @param filePath
     * @return
     * @throws Exception
     */
    public static byte getFileByteType(String filePath) throws Exception {
        File file = new File(filePath);
        if(file == null){
            throw new Exception("文件不能为空");
        }else if(file.isDirectory()){
            throw new Exception("此路径为目录,不是文件");
        }else if(file.getName().indexOf(".") == -1){
            throw new Exception("文件格式不正确,文件名称需要包含.");
        }else{
            if(".jpg".equals(file.getName().substring(file.getName().lastIndexOf(".")).toLowerCase())){
                return 1;//文本文件:0 ,jpg:1
            }else{
                return 0;//文本文件:0 ,jpg:1
            }

        }
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
