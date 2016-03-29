package com.opensourceteams.modules.common.gramar.JDBC操作.n_05_自定义连接池;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 日期: 2016-03-28  10:50
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class THTConnection extends THtConnectionAdapt {

    Connection connection ;
    ThtDataSource dataSource;
    public THTConnection(Connection connection,ThtDataSource dataSource){
        this.connection = connection;
        this.dataSource = dataSource;
    }

    public PreparedStatement prepareStatement(String sql) {
        try {
            return connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void close() {
        dataSource.close(this);

    }

    public boolean isClosed() {
        return false;
    }
}
