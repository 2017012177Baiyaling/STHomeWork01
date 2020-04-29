package com.dao.users.impl;

import com.dao.users.UsersDao;
import com.entity.users.Users;
import com.sql.users.UsersSql;
import com.util.dbconn.DbCoon;
import com.util.dbconn.impl.DbCoonImpl;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsersDaoImpl implements UsersDao{
    private  Connection conn;
    private  DbCoon dbConn;
    public UsersDaoImpl(){
        this.dbConn = new DbCoonImpl();
    }
    /**
     * 注册
     * @param users
     * @return
     */
    @Override
    public  boolean register(Users users) {
        boolean flag = false;
        conn = null;
        PreparedStatement ps = null;
        try {
            this.conn = dbConn.getConnection();
            ps = conn.prepareStatement(UsersSql.register);
            ps.setString(1, users.getUsername());
            ps.setString(2, users.getPassword());
            if (ps.executeUpdate() > 0) {
                flag = true;
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            dbConn.closePreparedStatement(ps);
            dbConn.closeConnection(conn);
        }
        return flag;
    }
    /**
     * 登录
     * @param username
     * @return
     */
    @Override
    public Users selectByName(String username) {
        Users users = null;
        conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            this.conn = dbConn.getConnection();
            ps = conn.prepareStatement(UsersSql.selectByName);
            ps.setString(1,username);
            rs = ps.executeQuery();
            while (rs.next()){
                users = new Users();
                users.setId(rs.getInt("id"));
                users.setUsername(rs.getString("username"));
                users.setPassword(rs.getString("password"));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            dbConn.closeResultSet(rs);
            dbConn.closePreparedStatement(ps);
            dbConn.closeConnection(conn);
        }
        return users;
    }
}