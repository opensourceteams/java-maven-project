package com.opensourceteams.modules.common.java.util.sql;

import com.opensourceteams.modules.common.java.timer.TimerUtil;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.opensourceteams.modules.common.java.util.sql.JDBCUtil.executeBatch;


/**
 * 日期: 2016-03-25  15:03
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class JDBCUtilTest {
    Connection conn = JDBCUtil.getNewConnection();

    /**
     * Statement 创建表
     */
    @Test
    public void testCreateTable(){
        Connection conn = JDBCUtil.getNewConnection();
        String sql = "create table student_batch_PreparedStatement (id int primary key auto_increment,name varchar(100),age int) "  ;
        Boolean result = JDBCUtil.execute(conn,sql);
        JDBCUtil.close(conn);

        System.out.println(result);
    }

    /**
     * PreparedStatement 创建表
     */
    @Test
    public void testExecutePreparedStatement(){
        String sql = "create table student1 (id int primary key auto_increment,name varchar(100),age int) "  ;
        Boolean result = JDBCUtil.executePreparedStatement(sql);
        JDBCUtil.close(conn);

        System.out.println(result);
    }

    /**
     * Statement 创建表
     */
    @Test
    public void testDropTable(){
        Connection conn = JDBCUtil.getNewConnection();
        String sql = "drop table STUDENT_BATCH_PREPAREDSTATEMENT  "  ;
        Boolean result = JDBCUtil.execute(conn,sql);
        JDBCUtil.close(conn);

        System.out.println(result);
    }

    /**
     * Statement 增加数据
     */
    @Test
    public void testInsert(){
        String sql = "insert into student (name,age) values ('中',6)"  ;
        Boolean result = JDBCUtil.execute(conn,sql);
        JDBCUtil.close();

        System.out.println(result);
    }

    /**
     * PreparedStatement 增加数据
     */
    @Test
    public void testInsertPreparedStatement(){
        String sql = "insert into student (name,age) values ('中',6)"  ;
        Boolean result = JDBCUtil.executePreparedStatement(sql);
        JDBCUtil.close();

        System.out.println(result);
    }
    /**
     * executePreparedStatement 增加数据
     */
    @Test
    public void testInsertPreparedStatementParamers(){
        String sql = "insert into student (name,age) values (?,?)"  ;
        List<Object> values = new ArrayList<Object>();
        values.add("中国");
        values.add(15);

        List<Integer> types = new ArrayList<Integer>();
        types.add(Types.VARCHAR);
        types.add(Types.INTEGER);

        Boolean result = null;
        try {
            result = JDBCUtil.executePreparedStatement(sql, values,types);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JDBCUtil.close();

        System.out.println(result);
    }



    /**
     * Statement 增加数据
     */
    @Test
    public void testInsert2(){
        String sql = "";
        for (int i =100;i<200;i++){
             sql = "insert into student (id,name,age) values (" + i+",'f"+i+"',"+i+")"  ;
            Boolean result = JDBCUtil.execute(conn,sql);
        }

        JDBCUtil.close(conn);

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
     * PreparedStatement 插入数据
     */
    @Test
    public void testExecuteBatch(){
        //sql = "insert into student (id,name,age) values (" + i+",'f"+i+"',"+i+")"  ;
        String sql = "insert into student (name,age) values (?,?) "  ;
        PreparedStatement ps = JDBCUtil.preparedStatement(sql);
        try {
            List<Object> values = null;

            List<Integer> types = null;

            for (int i = 0 ;i< 10;i++){
                values = new ArrayList<Object>();
                values.add("中国" +i);
                values.add(i +10);

                types = new ArrayList<Integer>();
                types.add(Types.VARCHAR);
                types.add(Types.INTEGER);

                JDBCUtil.setPreparedStatement(ps,values,types);
                ps.addBatch();
            }

            ps.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        JDBCUtil.close(conn);

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


    /**
     * executeUpdatePreparedStatement 增加数据
     */
    @Test
    public void testExecuteUpdatePreparedStatement(){
        String sql = "insert into student (name,age) values (?,?)"  ;
        List<Object> values = new ArrayList<Object>();
        values.add("中国");
        values.add(15);

        List<Integer> types = new ArrayList<Integer>();
        types.add(Types.VARCHAR);
        types.add(Types.INTEGER);

        int result = 0;
        try {
            result = JDBCUtil.executeUpdatePreparedStatement(sql, values,types);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JDBCUtil.close();

        System.out.println(result);
    }


    /**
     * executeUpdatePreparedStatement 更新数据
     */
    @Test
    public void testExecuteUpdatePreparedStatementUpdate(){
        String sql = "update student set name =? ,age =? where id =?"  ;
        List<Object> values = new ArrayList<Object>();
        values.add("中国1");
        values.add(18);
        values.add(3);

        List<Integer> types = new ArrayList<Integer>();
        types.add(Types.VARCHAR);
        types.add(Types.INTEGER);
        types.add(Types.INTEGER);

        int result = 0;
        try {
            result = JDBCUtil.executeUpdatePreparedStatement(sql, values,types);
        } catch (Exception e) {
            e.printStackTrace();
        }
        JDBCUtil.close();

        System.out.println(result);
    }

    /**
     * testResultSetPreparedStatement 查询数据
     */
    @Test
    public void testResultSetPreparedStatement(){
        String sql = "select * from student  where name =? and id = ?"  ;
        List<Object> values = new ArrayList<Object>();
        values.add("中国1");
        values.add(3);

        List<Integer> types = new ArrayList<Integer>();
        types.add(Types.VARCHAR);
        types.add(Types.INTEGER);

        ResultSet resultSet = JDBCUtil.resultSetPreparedStatement(sql,values,types);
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

    @Test
    public void printlCapacity(){
        String sql = "SELECT \n" +
                "    sum(DATA_LENGTH) 'data(kb)',sum(INDEX_LENGTH) 'index(KB)',\n" +
                "    sum(DATA_LENGTH) / 1024 'data(MB)',sum(INDEX_LENGTH)  / 1024 'MB',\n" +
                "    sum(DATA_LENGTH) / 1024 / 1024 'data(GB)', sum(INDEX_LENGTH)  / 1024 /1024 'GB'\n" +
                "\n" +
                "FROM information_schema.TABLES where TABLE_SCHEMA='bigdata' and  table_name ='STUDENT_BATCH_PREPAREDSTATEMENT';"  ;


        Connection conn = JDBCUtil.getNewConnection();
        ResultSet resultSet = JDBCUtil.resultSetPreparedStatement(conn,sql);
        try {
            while (resultSet.next()){
                System.out.print("data(kb):" + resultSet.getString(1) );
                System.out.print("\tindex(KB):" + resultSet.getString(2));
                System.out.print("\tdata(MB):" + resultSet.getString(3));
                System.out.print("\tindex(MB):" + resultSet.getString(4));
                System.out.print("\tdata(GB):" + resultSet.getString(5));
                System.out.print("\tindex(GB):" + resultSet.getString(6));

                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        JDBCUtil.close(conn,resultSet);

    }

    /**
     * PreparedStatement 插入数据 批量处理,性能测试一百万数据
     */
    @Test
    public void testExecuteBatch2(){
        testDropTable();
        testCreateTable();
        long time = System.currentTimeMillis();
        //sql = "insert into student (id,name,age) values (" + i+",'f"+i+"',"+i+")"  ;
        String sql = "insert into student_batch_PreparedStatement (name,age) values (?,?) "  ;

        try {
            List<List<Object>> values = new ArrayList<List<Object>>();
            List<List<Integer>> types = new ArrayList<List<Integer>>();
            List<Object> rowValues = null;

            List<Integer> rowTypes = null;
            int totalCount = 20000000;

            for (int i = 0 ;i< totalCount;i++){
                rowValues = new ArrayList<Object>();
                rowValues.add("中国" +i);
                rowValues.add(i +10);

                rowTypes = new ArrayList<Integer>();
                rowTypes.add(Types.VARCHAR);
                rowTypes.add(Types.INTEGER);

                values.add(rowValues);
                types.add(rowTypes);

                if (i % 100000 ==0){
                    int[] result = JDBCUtil.executeBatchNotClose(sql,values,types);


                    TimerUtil.printlnWorkerTimeMillis(time, "插入完成了数据量(条):"+i);
                    printlCapacity();
                    values = new ArrayList<List<Object>>();
                    types = new ArrayList<List<Integer>>();
                }

            }
            int[] result = JDBCUtil.executeBatch(sql,values,types);
            TimerUtil.printlnWorkerTimeMillis(time, "插入完成了数据量(条):" +totalCount);
            printlCapacity();


        } catch (Exception e) {
            e.printStackTrace();
        }
        JDBCUtil.close(conn);
        TimerUtil.printlnWorkerTimeMillis(time);

    }
}
