package com.opensourceteams.modules.common.java.io.file;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/14  上午7:42
 * 功能描述:
 */

public class FilePathUtilTest {

    /**
     * 删除文件
     */
    @Test
    public void testDelete(){
        String path = "a.tmp" ;
        File file = new File(path);
        file.deleteOnExit();
    }

    /**
     * 删除文件
     */
    @Test
    public void testDelete2(){
        String path = "a.tmp" ;
        FilePathUtil.deleteFile(path);
    }

    /**
     * 删除文件
     */
    @Test
    public void testDeleteFiles(){
        // TODO: 16/3/24  删除目录,目录下有子目录,递归删除的方法示实现
        String path = "/opt/temp/a" ;
        File file = new File(path);
        deleteFiles(file);
    }

    public void deleteFiles(File f){
        if(f != null){
            if (f.isFile()){
                f.deleteOnExit();
            }else if(f.isDirectory()){
                File[] files = f.listFiles();
                if(files == null || files.length ==0){
                    f.deleteOnExit();
                }else{
                    for (File sub :files){
                        deleteFiles(sub);
                    }

                }

            }
        }
    }
    /**
     * 遍历所有的目录和子目录
     */
    @Test
    public void testSubRecursionListFiles(){

        List<String> list = new ArrayList<String>();
        File f = new File(".");
        FilePathUtil.subRecursionListFilesSort(list,f);

        for (String s : list){
            System.out.println(s);
        }

    }

}
