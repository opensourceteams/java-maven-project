package com.opensourceteams.modules.common.作业.第十二天.文件的复制;


import com.opensourceteams.modules.common.java.io.file.FileUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/11  上午6:04
 * 功能描述:
 */

public class Run {



    @Test
    public void testReadCharArray1() throws Exception {
        //TODO: Test goes here...
        String path = "";
        List<String> list = new ArrayList<String>();
        list.add("你好");
        list.add("你好");
        list.add("你好2");

        FileUtil.writeFile(path,list);
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
