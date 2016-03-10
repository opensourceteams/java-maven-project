package com.opensourceteams.modules.common.java.io.file;

import java.io.File;

/**
 * 开发者:刘文  Email:372065525@qq.com
 * 16/3/11  上午6:00
 * 功能描述:
 * ).创建多级目录
 * ).创建多级目录下的文件
 */

public class FilePathUtil {


    /**
     * 创建多级目录,如果目录存在就不创建
     * @param path 需要创建目录的路径
     */
    public static void mkdir(String path) {
        File fd = null;
        try {
            fd = new File(path);
            if (!fd.exists()) {
                fd.mkdirs();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fd = null;
        }
    }


    /**
     * 创建文件
     * @param path
     * @throws Exception
     */
    public static void createFile(String path) throws Exception {
        if (path == null || "".equals(path)) {
            return;
        }
        try {
            // 获得文件对象
            File f = new File(path);
            if (f.exists()) {
                return;
            }
            // 如果路径不存在,则创建
            if (!f.getParentFile().exists()) {
                f.getParentFile().mkdirs();
            }
            f.createNewFile();
        } catch (Exception e) {
            // log.error("创建文件错误.path=" + path, e);
            throw e;
        }
    }
}
