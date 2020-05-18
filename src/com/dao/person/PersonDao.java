package com.dao.person;

import com.entity.person.Person;

import java.util.List;

/**
 * person对应的数据库操作方法
 */
public interface PersonDao {


    /**
     * 增加
     * @param person
     * @return
     */
    public boolean addPerson(Person person);//之前这里没有注释。【5】

    /**
     * 删除（根据关键字）
     * @param id
     * @return
     */
    public boolean delPerson(int id);//之前这里没有注释。【5】

    /**
     * 修改
     * @param person
     * @return
     */
    public boolean updatePerson(Person person);//之前这里没有注释。【5】

    /**
     *查找（根据关键字）
     * @param id
     * @return
     */
    public Person selectById(int id);//之前这里没有注释。【5】

    /**
     * 模糊查询
     * @param keyword
     * @return
     */
    public List<Person> select(String keyword);//之前这里没有注释。【5】

    /**
     * 遍历
     * @return
     */
    public List<Person> listAllPerson();//之前这里没有注释。【5】

}
