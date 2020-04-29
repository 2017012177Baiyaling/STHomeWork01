package com.sql.users;

public class UsersSql {
    //注册
    public static String register = "INSERT INTO t_user(username,password) VALUES(?,?)";
    //查找
    public static String selectByName = "SELECT*FROM t_user WHERE username=?";
}
