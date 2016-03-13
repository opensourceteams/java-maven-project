package com.opensourceteams.modules.common.作业.第十二天.创建任意路径文件和目录;

import com.opensourceteams.modules.common.java.io.file.FilePathUtil;
import com.opensourceteams.modules.common.java.io.file.FileUtil;
import org.junit.Test;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/11  上午5:10
 * 功能描述:
 */

public class Run {




    public static void main(String[] args) throws Exception {
        //FilePathUtil.mkdir("d/fc/f");
        FilePathUtil.createFile("src/test/resources/file/a.txt");


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
        FileUtil.fileCopy("src/test/resources/file/a.txt","src/test/resources/file/d.txt");

    }



}
