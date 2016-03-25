package com.opensourceteams.modules.common.java.util.sql;

import java.sql.*;

/**
 * 日期: 2016-03-25  14:53
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class JDBCUtil {


    public static Connection getConnection(String url,String user,String password){
        try {
            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Statement createStatement(Connection conn){
        try {
            return conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean execute(Connection conn,String sql){
        Statement st = createStatement(conn);
        try {
            return st.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return false;

    }
    public static int executeUpdate(Connection conn, String sql){
        Statement st = createStatement(conn);
        try {
            return st.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(st != null){
                try {
                    st.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return -1;

    }

    public static ResultSet resultSet(Connection conn, String sql){
        Statement st = createStatement(conn);


        try {
            return  st.executeQuery(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static  void close(Connection conn){

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static  void close(Connection conn,ResultSet rs){

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static  void close(Connection conn,Statement st){
        if(st != null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
