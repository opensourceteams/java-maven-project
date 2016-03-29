package com.opensourceteams.modules.common.gramar.JDBC操作.n_05_自定义连接池;

import com.opensourceteams.modules.common.java.util.sql.JDBCUtil;

import java.sql.Connection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 日期: 2016-03-28  10:56
 * 开发人:刘文  -->  (372065525@qq.com)
 * 功能描述:
 */
public class ThtDataSource extends THTDataSourceAdapt {

    public static int defaultPoolCont = 10;

    Set<Connection> connectionPool = new HashSet<Connection>();

    public ThtDataSource() {
        init();
    }

    private void init() {
        for (int i = 0; i < defaultPoolCont; i++) {
            connectionPool.add(new THTConnection(JDBCUtil.getNewConnection(),this));
        }
    }

    public synchronized Connection getConnection() {

        if (connectionPool != null) {
            while (true) {
                if (connectionPool.size() == 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    Iterator it = connectionPool.iterator();
                    if (it.hasNext()) {
                        Connection obj = (Connection) it.next();
                        connectionPool.remove(obj);
                        return obj;
                    }
                }

            }


        }
        return null;
    }

    public void close(Connection conn){
        if(connectionPool != null && !connectionPool.contains(conn)){
            connectionPool.add(conn);
        }
    }




}
