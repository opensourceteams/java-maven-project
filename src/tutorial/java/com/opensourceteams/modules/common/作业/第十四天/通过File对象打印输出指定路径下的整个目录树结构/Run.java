package com.opensourceteams.modules.common.作业.第十四天.通过File对象打印输出指定路径下的整个目录树结构;

import com.opensourceteams.modules.common.java.io.file.FilePathUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/14  上午7:26
 * 功能描述:
 */

public class Run {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        File f = new File(".");
        FilePathUtil.subRecursionListFilesSort(list,f);

        for (String s : list){
            System.out.println(s);
        }
    }
}
