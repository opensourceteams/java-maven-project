package com.opensourceteams.modules.common.gramar.JDBC操作.n_03_jdbc_保存图片_到mysql;

import com.opensourceteams.modules.common.java.io.StreamUtil;
import com.opensourceteams.modules.common.java.util.sql.JDBCUtil;
import org.junit.Test;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * 日期: 2016-03-26  15:10
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class ImageTest {

    /**
     * 保存图片
     */
    @Test
    public void  testSaveImage(){
        Connection conn = JDBCUtil.getNewConnection();
        String sql ="insert into student (name,pic)  values (?,?)";
        FileInputStream  fis = null;
        try {
            fis = new FileInputStream("/opt/temp/data/images/hadoop-logo.jpg");
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,"image1");
            ps.setBinaryStream(2,fis,fis.available());

            int result = ps.executeUpdate();
            System.out.println(result);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn);
        }
    }

    /**
     * 读取图片
     */
    @Test
    public void testReadImage(){

        Connection conn = JDBCUtil.getNewConnection();
        String sql = "select id,name,age,pic  from student where id = 1 " ;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            PreparedStatement ps =  conn.prepareStatement(sql);

            ResultSet rs =  ps.executeQuery();

            byte[] buffer = new byte[1024];
            int len =0 ;

            byte[] bytes = null;
            while (rs.next()){
/*

                fos = new FileOutputStream("/opt/temp/data/images/hadoop-logo-write.jpg");
                len =0 ;
                while ((len = is.read(buffer)) != -1){
                    fos.write(buffer,0,len);
                }*/

                fos = new FileOutputStream("/opt/temp/data/images/hadoop-logo-write.jpg");
                bytes = rs.getBytes(4);
                fos.write(bytes);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            StreamUtil.close(is,fos);
        }
    }
}
