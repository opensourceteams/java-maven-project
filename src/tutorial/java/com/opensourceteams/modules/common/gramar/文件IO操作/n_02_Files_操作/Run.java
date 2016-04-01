package com.opensourceteams.modules.common.gramar.文件IO操作.n_02_Files_操作;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.Files.copy;

/**
 * 日期: 2016-03-30  10:12
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class Run {

    /**
     * 可以删除没有空文件夹或文个把
     * @throws IOException
     */
    @Test
    public void  testFilesDelete() throws IOException {
        //Files.delete(Paths.get("/opt/temp/data/text/a"));
        Files.deleteIfExists(Paths.get("/opt/temp/data/text/a"));
    }

    /**
     * 文件的复制 Path复制
     */
    @Test
    public void testFilesCopyPath(){
        Path source = Paths.get("/opt/temp/data/text/a.txt");
        Path target = Paths.get("/opt/temp/data/text/a3.txt");

        try {
            copy(source,target);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件夹的复制,不管用,只复制了顶级目录
     */
    @Test
    public void testFilesCopyPath2(){
        Path source = Paths.get("/opt/temp/data/text");
        Path target = Paths.get("/opt/temp/data/text3");

        try {
            Path reslut = Files.copy(source,target);
            System.out.println(reslut.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
