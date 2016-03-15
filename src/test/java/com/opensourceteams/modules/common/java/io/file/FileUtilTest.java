package com.opensourceteams.modules.common.java.io.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/11  上午7:03
 * 功能描述:
 */

public class FileUtilTest {



    @Test
    public void testWriteFileAppend() throws IOException {
        List<String> list = new ArrayList<String>();
        String destPath = "a.txt";
        list.add("中国人民中国人民中国人民中国人民中国人民中国人民中国人民中国人民\n");
        FileUtil.writeFileAppend(destPath,list);

    }
    /**
     *
     * Method: readCharArray(String path)
     *
     */
    @Test
    public void testReadCharArray() throws Exception {
        //TODO: Test goes here...
        String result = FileUtil.readCharArray("src/test/resources/file/a.txt");
        System.out.println(result);
    }

    @Test
    public void testFileCopy() throws Exception {
        long start = System.currentTimeMillis();
        System.out.println(start);

        String srcPath = "/opt/workspace/temp/bigtxt.txt";
        String destPath="/opt/workspace/temp/bigtxt2.fileCompose.txt";
        FileUtil.fileCopy(srcPath,destPath);

    }

    @Test
    public void testDirectoryCopy() throws Exception {
        List<String> list = new ArrayList<String>();
        File f = new File("/opt/workspace/bigdata/all_frame_intellij/java_maven/src/tutorial/java/com/opensourceteams/modules/common/作业/第十四天");
        String destPath = "/opt/workspace/bigdata/all_frame_intellij/java_maven/a";
        subRecursionListFiles(list,f);

        for (String s : list){
           // System.out.println(s);
            //FileUtil.fileCopy(s,destPath);

        }

    }

    public static void subRecursionListFiles(List<String> list, File f ) throws IOException {
        if(f!= null ){
            if(f.isDirectory()){
                for (File subF : f.listFiles()){
                    list.add(subF.getAbsolutePath());
                    System.out.println(subF.getCanonicalPath());

                    if(subF.isDirectory()){
                        subRecursionListFiles(list,subF);
                    }
                }
            }else if(f.isFile()){
                list.add(f.getAbsolutePath());
            }


        }

    }

}
