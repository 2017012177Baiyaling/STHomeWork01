package com.dao.person.impl;

import com.dao.person.PersonDao;
import com.entity.person.Person;
import com.sql.person.PersonSql;
import com.util.dbconn.DbCoon;
import com.util.dbconn.impl.DbCoonImpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * person对应的数据库操作方法的实现
 * @author asus
 */
public class PersonDaoImpl implements PersonDao{
    private Connection conn;
    private DbCoon dbConn;
    public PersonDaoImpl(){
        this.dbConn = new DbCoonImpl();
    }
    /**
     * 增加
     * @param person
     * @return
     */
    @Override
    public boolean addPerson(Person person) {
        boolean flag = false;
        conn = null;
        PreparedStatement ps = null;
        try {
            this.conn = dbConn.getConnection();
            ps = conn.prepareStatement(PersonSql.addPerson);
            ps.setString(1, person.getName());
            ps.setInt(2, person.getAge());
            ps.setString(3, person.getSex());
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
     *删除
     * @param id
     * @return
     */
    @Override
    public boolean delPerson(int id) {
        boolean flag = false;
        conn = null;
        PreparedStatement ps = null;
        try{
            this.conn = dbConn.getConnection();
            ps = conn.prepareStatement(PersonSql.delPerson);
            ps.setInt(1, id);
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
     * 修改
      * @param person
     * @return
     */
    @Override
    public boolean updatePerson(Person person) {
        boolean flag = false;
        conn = null;
        PreparedStatement ps = null;
        try{
            this.conn = dbConn.getConnection();
            ps = conn.prepareStatement(PersonSql.updatePerson);
            ps.setString(1, person.getName());
            ps.setInt(2, person.getAge());
            ps.setString(3, person.getSex());
            ps.setInt(4, person.getId());
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
     *查找（根据id）
     * @param id
     * @return
     */
    @Override
    public Person selectById(int id) {
        Person person = null;
        conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            this.conn = dbConn.getConnection();
            ps = conn.prepareStatement(PersonSql.selectPerson);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()){
                person = new Person();
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setAge(rs.getInt("age"));
                person.setSex(rs.getString("sex"));
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            dbConn.closeResultSet(rs);
            dbConn.closePreparedStatement(ps);
            dbConn.closeConnection(conn);
        }
        return person;
    }

    /**
     * 模糊查询
     * @param keyword
     * @return
     */
    @Override
    public List<Person> select(String keyword){
        List<Person> list = new ArrayList<>();
        conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String key = "%" + keyword + "%";
        try{
            this.conn = dbConn.getConnection();
            ps = conn.prepareStatement(PersonSql.select);
            ps.setString(1,key);
            ps.setString(2,key);
            ps.setString(3,key);
            ps.setString(4,key);
            rs = ps.executeQuery();
            while (rs.next()){
                Person person = new Person();
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setAge(rs.getInt("age"));
                person.setSex(rs.getString("sex"));
                list.add(person);
            }
        } catch (SQLException e) {
                e.printStackTrace();
        }finally {
            dbConn.closeResultSet(rs);
            dbConn.closePreparedStatement(ps);
            dbConn.closeConnection(conn);
        }
        return list;
    }
    /**
     * 遍历所有
     * @return
     */
    @Override
    public List<Person> listAllPerson() {
        Person person = null;
        List<Person> list = new ArrayList<>();
        conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            this.conn = dbConn.getConnection();
            ps = conn.prepareStatement(PersonSql.listAllPerson);
            rs = ps.executeQuery();
            while (rs.next()){
                person = new Person();
                person.setId(rs.getInt("id"));
                person.setName(rs.getString("name"));
                person.setAge(rs.getInt("age"));
                person.setSex(rs.getString("sex"));
                list.add(person);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            dbConn.closeResultSet(rs);
            dbConn.closePreparedStatement(ps);
            dbConn.closeConnection(conn);
        }
        return list;
    }
}
