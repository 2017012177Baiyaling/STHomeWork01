package test.person;

import com.dao.person.PersonDao;
import com.dao.person.impl.PersonDaoImpl;
import com.entity.person.Person;
import org.junit.Test;

public class PersonTest {
    PersonDao personDao = new PersonDaoImpl();
    //测试增加用户
    @Test
    public void testAdd(){
        Person person = new Person();
        person.setName("张五");
        person.setAge(1);
        person.setSex("男");
        System.out.println(personDao.addPerson(person));
    }
    //测试遍历
    @Test
    public void testListAll() throws Exception{
        System.out.println(personDao.listAllPerson());
    }

    @Test
    public void testSelect(){
        String key = "白";
        PersonDao p = new PersonDaoImpl();
        System.out.print (((PersonDaoImpl) p).select(key));
    }
}

