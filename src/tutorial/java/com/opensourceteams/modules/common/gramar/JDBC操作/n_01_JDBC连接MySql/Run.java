package com.opensourceteams.modules.common.gramar.JDBC操作.n_01_JDBC连接MySql;

import com.opensourceteams.modules.common.java.util.sql.JDBCUtil;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * 日期: 2016-03-25  15:03
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class Run {
    Connection conn = JDBCUtil.getConnection("jdbc:mysql://192.168.12.12:3306/bigdata","bigdata","bigdata");

    /**
     * Statement 增加数据
     */
    @Test
    public void testInsert(){
        String sql = "insert into student (id,name,age) values (6,'f',6)"  ;
        Boolean result = JDBCUtil.execute(conn,sql);
        JDBCUtil.close(conn);

        System.out.println(result);
    }

    /**
     * Statement 更新数据
     */
    @Test
    public void testUpdate(){
        String sql = "update student set age = 7 where id = 6 "  ;
        Boolean result = JDBCUtil.execute(conn,sql);
        JDBCUtil.close(conn);

        System.out.println(result);
    }

    /**
     * Statement 更新数据
     */
    @Test
    public void testExecuteUpdate(){
        String sql = "update student set age = 8 where id = 1 "  ;
        int result = JDBCUtil.executeUpdate(conn,sql);
        JDBCUtil.close(conn);

        System.out.println(result);
    }

    /**
     * Statement 删除数据
     */
    @Test
    public void testDelete(){
        String sql = "delete from student where id = 6 "  ;
        Boolean result = JDBCUtil.execute(conn,sql);
        JDBCUtil.close(conn);

        System.out.println(result);
    }


    /**
     * Statement 查询数据
     */
    @Test
    public void testResultSet(){
        String sql = "select * from student "  ;
        ResultSet resultSet = JDBCUtil.resultSet(conn,sql);
        try {
            while (resultSet.next()){
                System.out.print("id:" + resultSet.getInt("id") );
                System.out.println("\tname:" + resultSet.getString("name"));
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        JDBCUtil.close(conn,resultSet);

    }
}
