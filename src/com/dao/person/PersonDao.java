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
    public boolean addPerson(Person person);

    /**
     * 删除
     * @param id
     * @return
     */
    public boolean delPerson(int id);

    /**
     * 修改
     * @param person
     * @return
     */
    public boolean updatePerson(Person person);

    /**
     *查找（根据id）
     * @param id
     * @return
     */
    public Person selectById(int id);

    /**
     * 模糊查询
     * @param keyword
     * @return
     */
    public List<Person> select(String keyword);

    /**
     * 遍历
     * @return
     */
    public List<Person> listAllPerson();

}
