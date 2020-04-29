package com.sql.person;

/**
 * person类对应的sql语句
 */
public class PersonSql {
    //增加
    public static String addPerson = "INSERT INTO t_person(name,age,sex) VALUES(?,?,?) ";
    //删除
    public static String delPerson = "DELETE FROM t_person WHERE id=?";
    //修改
    public static String updatePerson = "UPDATE t_person SET name=?,age=?,sex=? WHERE id=?";
    //查找（根据id）
    public static String selectPerson = "SELECT*FROM t_person WHERE id=?";
    //遍历全部
    public static String listAllPerson = "SELECT*FROM t_person";
    //模糊查询
    public static String select = "SELECT * FROM t_person WHERE name LIKE ? OR age LIKE ? OR sex LIKE ? OR id LIKE ?";
}
