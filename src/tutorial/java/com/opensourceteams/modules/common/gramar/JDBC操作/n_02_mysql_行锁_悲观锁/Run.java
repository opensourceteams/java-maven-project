package com.opensourceteams.modules.common.gramar.JDBC操作.n_02_mysql_行锁_悲观锁;

import com.opensourceteams.modules.common.java.util.sql.JDBCUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 日期: 2016-03-25  16:45
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class Run {

    Connection conn = JDBCUtil.getConnection("jdbc:mysql://192.168.12.12:3306/bigdata","bigdata","bigdata");

    /**
     * Statement cha入数据
     */
    @Test
    public void testInsert() throws SQLException {
        conn.setAutoCommit(false);

        String sql = "insert student set age = 9 where id = 1 "  ;
        int result = JDBCUtil.executeUpdate(conn,sql);
        conn.commit();
        JDBCUtil.close(conn);

        System.out.println(result);
    }

    /**
     * Statement 更新数据
     */
    @Test
    public void testExecuteUpdate() throws SQLException {
        conn.setAutoCommit(false);

        String sql = "update student set age = 9 where id = 1 "  ;
        int result = JDBCUtil.executeUpdate(conn,sql);
        conn.commit();
        JDBCUtil.close(conn);

        System.out.println(result);
    }

    /**
     * Statement 更新数据
     */
    @Test
    public void testExecuteUpdate2() throws SQLException {
        Connection conn = JDBCUtil.getConnection("jdbc:mysql://192.168.12.12:3306/bigdata","bigdata","bigdata");
        conn.setAutoCommit(false);
        String sql = "update student set age = 10 where id = 1 "  ;
        int result = JDBCUtil.executeUpdate(conn,sql);
        conn.commit();
        JDBCUtil.close(conn);

        System.out.println(result);
    }


    /**
     * Statement 更新数据
     */
    @Test
    public void testExecuteDelete() throws SQLException {
        conn.setAutoCommit(false);

        String sql = "delete from student where age > 130 "  ;
        int result = JDBCUtil.executeUpdate(conn,sql);
        conn.commit();
        JDBCUtil.close(conn);

        System.out.println(result);
    }

    /**
     * Statement 更新数据
     */
    @Test
    public void testExecuteDelete2() throws SQLException {
        Connection conn = JDBCUtil.getConnection("jdbc:mysql://192.168.12.12:3306/bigdata","bigdata","bigdata");
        conn.setAutoCommit(false);
        String sql = "delete from student where age < 100 "  ;
        int result = JDBCUtil.executeUpdate(conn,sql);
        conn.commit();
        JDBCUtil.close(conn);

        System.out.println(result);
    }
}
