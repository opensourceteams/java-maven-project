package com.opensourceteams.modules.common.java.util.sql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.List;
import java.util.Properties;


/**
 * 日期: 2016-03-25  14:53
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:1
 */
public class JDBCUtil {

    static String driver = "";
    static String url = "";
    static String user = "";
    static String password = "";

    public static Connection connection = getConnection();



    public static PreparedStatement ps = null;

    private synchronized static PreparedStatement getPreparedStatement(String sql){
        if(ps == null){
            try {
                return connection.prepareStatement(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            return ps;
        }
        return null;
    }

    private synchronized static Connection getConnection(){
        try {

            Properties p = new Properties();
            try {
                p.load(JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties"));
                url = p.getProperty("jdbc.url");
                user = p.getProperty("jdbc.user");
                password = p.getProperty("jdbc.password");
                driver = p.getProperty("jdbc.driver");
            } catch (IOException e) {
                e.printStackTrace();
            }

            Class.forName(driver);
            if(connection != null) return connection;

            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public synchronized static Connection getNewConnection(){
        try {

            Class.forName("com.mysql.jdbc.Driver");

            return DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

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
    public static Statement createStatement(){
        try {
            return getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static PreparedStatement preparedStatement(String sql){
        PreparedStatement ps = null;
        try {
             return connection.prepareStatement(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
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
    public static boolean execute(String sql){
        Statement st = createStatement(connection);
        try {
            return st.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(connection,st);
        }
        return false;


    }


    public static boolean executePreparedStatement(String sql){
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            return ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(connection,ps);
        }
        return false;

    }

    /**
     * 增加或更新操作
     * @param sql
     * @param values
     * @param types
     * @return
     * @throws Exception
     */
    public static boolean executePreparedStatement(String sql, List<Object> values, List<Integer> types) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            if(values != null){
                for (int i = 0; i < values.size(); i++){
                    if(values.get(i) == null){
                        ps.setNull(i +1, types.get(i));
                    }else{
                        if(types.get(i) == Types.INTEGER){
                            ps.setInt(i + 1,Integer.parseInt(values.get(i).toString()));
                        }else if(types.get(i) == Types.VARCHAR){
                            ps.setString(i + 1,values.get(i).toString());
                        }else if(types.get(i) == Types.BINARY){
                            InputStream is = (InputStream)values.get(i) ;
                            ps.setBinaryStream(i + 1,is,is.available());
                        }else{
                            throw new Exception("暂不支持类型:" +types.get(i));
                        }
                    }

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            return ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(connection,ps);
        }
        return false;

    }

    /**
     *
     * @param ps PreparedStatement ,进行参数设置
     * @param values
     * @param types
     * @throws Exception
     */
    public static void setPreparedStatement(PreparedStatement ps, List<Object> values, List<Integer> types) throws Exception {
        if(values != null && types != null){
            for (int i = 0; i < values.size(); i++){
                if(values.get(i) == null){
                    ps.setNull(i +1, types.get(i));
                }else{
                    if(types.get(i) == Types.INTEGER){
                        ps.setInt(i + 1,Integer.parseInt(values.get(i).toString()));
                    }else if(types.get(i) == Types.VARCHAR){
                        ps.setString(i + 1,values.get(i).toString());
                    }else{
                        throw new Exception("暂不支持类型:" +types.get(i));
                    }
                }

            }
        }

    }

    public static int executeUpdatePreparedStatement(String sql, List<Object> values, List<Integer> types) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            setPreparedStatement(ps,values,types);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(connection,ps);
        }
        return -1;

    }

    /**
     * 批量插入,或更新操作
     * @param sql
     * @param values
     * @param types
     * @return
     */
    public static int[] executeBatch(String sql,List<List<Object>> values,List<List<Integer>> types ){
        return  executeBatch(sql,values,types,1000);
    }

    public static int[] executeBatchNotClose(String sql,List<List<Object>> values,List<List<Integer>> types ){
        return  executeBatchNotClose(sql,values,types,10000);
    }


    public static int[] executeBatch(String sql,List<List<Object>> values,List<List<Integer>> types ,int rowsCountExecuteBath){
        PreparedStatement ps = preparedStatement(sql);
        try {


            if(values == null || types ==null){
                return null;
            }
            List rowValues = null;
            List rowTypes = null;
            for (int i = 0 ;i< values.size();i++){
                rowValues = values.get(i);
                rowTypes = types.get(i);

                JDBCUtil.setPreparedStatement(ps,rowValues,rowTypes);
                ps.addBatch();

                if(i % rowsCountExecuteBath ==0 ) ps.executeBatch();
            }

            return  ps.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            close(connection,ps);
        }

        return null;
    }

    public static int[] executeBatchNotClose(String sql,List<List<Object>> values,List<List<Integer>> types ,int rowsCountExecuteBath){
        PreparedStatement ps = getPreparedStatement(sql);
        try {


            if(values == null || types ==null){
                return null;
            }
            List rowValues = null;
            List rowTypes = null;
            for (int i = 0 ;i< values.size();i++){
                rowValues = values.get(i);
                rowTypes = types.get(i);

                JDBCUtil.setPreparedStatement(ps,rowValues,rowTypes);
                ps.addBatch();
                //ps.clearBatch();

                if(i % rowsCountExecuteBath ==0 ) {
                    ps.executeBatch();
                    ps.clearBatch();
                }
            }

            return  ps.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 查询操作
     * @param sql
     * @param values
     * @param types
     * @return
     */
    public static ResultSet resultSetPreparedStatement( String sql, List<Object> values, List<Integer> types){
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            setPreparedStatement(ps,values,types);
            return  ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

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
    public static int executeUpdate(String sql){
        Statement st = createStatement(connection);
        try {
            return st.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(connection,st);
        }
        return -1;

    }
    public static int executeUpdatePreparedStatement(String sql){
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            return st.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(connection,st);
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
    public static ResultSet resultSet( String sql){
        Statement st = createStatement(connection);


        try {
            return  st.executeQuery(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public static ResultSet resultSetPreparedStatement( String sql){
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            return  ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    public static ResultSet resultSetPreparedStatement(Connection conn, String sql){
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            return  ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;

    }

    public static  void close(){


        try {
            if(connection != null && !connection.isClosed()){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static  void close(Connection conn){

        try {
            if(conn != null && !conn.isClosed()){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static  void close(Connection conn,ResultSet rs){

        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            if(conn != null && !conn.isClosed()){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public static  void close(Connection conn,CallableStatement cs){
        if(cs != null){
            try {
                cs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        try {
            if(conn != null && !conn.isClosed()){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
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
        try {
            if(conn != null && !conn.isClosed()){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
