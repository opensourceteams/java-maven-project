package com.opensourceteams.modules.common.gramar.JDBC操作.n_05_自定义连接池;

import com.opensourceteams.modules.common.java.util.sql.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 日期: 2016-03-28  11:10
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class Run {

    public static void main(String[] args) {
        ThtDataSource dataSource = new ThtDataSource();
        Connection conn = dataSource.getConnection();
        String sql = "insert into student (name ,age) values ('a',19)";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            int i = ps.executeUpdate();
            System.out.println(i);


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(conn,ps);
        }
    }
}
