package com.util.dbconn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface DbCoon {
    //连接数据库
    public Connection getConnection();
    //关闭数据库
    public void closeConnection(Connection conn);
    //关闭预处理结果
    public void closePreparedStatement(PreparedStatement ps);
    //关闭结果集
    public void closeResultSet(ResultSet rs);
}
