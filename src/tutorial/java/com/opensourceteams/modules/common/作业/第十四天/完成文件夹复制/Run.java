package com.opensourceteams.modules.common.作业.第十四天.完成文件夹复制;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import static org.apache.commons.io.FileUtils.copyDirectory;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/14  上午7:32
 * 功能描述: 直接调 apache 封装好的 api
 */

public class Run {


    public static void main(String[] args) throws IOException {

        String srcDri = "/opt/workspace/bigdata/all_frame_intellij/java_maven/src/tutorial/java/com/opensourceteams/modules/common/作业/第十四天" ;
        String destDir = "b";
        FileUtils.copyDirectory(new File(srcDri),new File(destDir));

    }
}
