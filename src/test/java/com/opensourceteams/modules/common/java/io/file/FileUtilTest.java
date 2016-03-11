package com.opensourceteams.modules.common.java.io.file;

import org.junit.Test;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/11  上午7:03
 * 功能描述:
 */

public class FileUtilTest {

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
