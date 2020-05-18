package com.util.dbconn.impl;

import com.util.dbconn.DbCoon;

import java.sql.*;

public class DbCoonImpl implements DbCoon {

    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String URL = "jdbc:mysql://localhost:3306/db_person";
    private final String USERNAME = "root";
    private final String PASSWORD = "mysql";
    private Connection conn=null;

    public DbCoonImpl(){
        try{
            Class.forName(DRIVER);
            this.conn= DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }


    @Override
    public Connection getConnection() {
        return this.conn;
    }


    @Override
    public void closeConnection(Connection conn) {
        if(conn!=null)
        {
            try{
                conn.close();
            }catch(SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }


    @Override
    public void closePreparedStatement(PreparedStatement ps) {
        if(ps!=null)
        {
            try{
                ps.close();
            }catch(SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }


    @Override
    public void closeResultSet(ResultSet rs) {
        if(rs!=null)
        {
            try{
                rs.close();
            }catch(SQLException ex)
            {
                ex.printStackTrace();
            }
        }
    }
}
