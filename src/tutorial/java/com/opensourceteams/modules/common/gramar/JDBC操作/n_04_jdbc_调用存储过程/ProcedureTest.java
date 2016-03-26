package com.opensourceteams.modules.common.gramar.JDBC操作.n_04_jdbc_调用存储过程;

import com.opensourceteams.modules.common.java.util.sql.JDBCUtil;
import org.junit.Test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

/**
 * 日期: 2016-03-26  17:42
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述: 调用存储过程

 mysql:存储过程
 delimiter //
 CREATE  PROCEDURE `addProc`(in a int,in b int ,out c int)
 BEGIN
 set c = a + b;
 END
 */
public class ProcedureTest {

    @Test
    public void testCallProcedure(){
        Connection conn = JDBCUtil.getNewConnection();
        try {
            CallableStatement cs = conn.prepareCall(" { call addProc(?,?,?) }");

            cs.setInt(1,5);
            cs.setInt(2,10);
            cs.registerOutParameter(3, Types.INTEGER);

            cs.execute();
            int value = cs.getInt(3);
            System.out.println(value);
            JDBCUtil.close(conn,cs);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
