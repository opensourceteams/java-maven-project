package com.opensourceteams.modules.common.gramar.JDBC操作.n_05_自定义连接池;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * 日期: 2016-03-28  10:54
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public abstract class THTDataSourceAdapt implements DataSource {


    public abstract Connection getConnection() ;

    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    public void setLoginTimeout(int seconds) throws SQLException {

    }

    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    public Logger getParentLogger()  {
        return null;
    }
}
