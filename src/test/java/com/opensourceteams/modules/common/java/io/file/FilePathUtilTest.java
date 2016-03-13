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
