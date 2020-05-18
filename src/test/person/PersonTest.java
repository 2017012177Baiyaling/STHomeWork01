package test.person;

import com.dao.person.PersonDao;
import com.dao.person.impl.PersonDaoImpl;
import com.entity.person.Person;
import org.junit.Test;

public class PersonTest {
    PersonDao personDao = new PersonDaoImpl();
    //���������û�
    @Test
    public void testAdd(){
        Person person = new Person();
        person.setName("����");
        person.setAge(1);
        person.setSex("��");
        System.out.println(personDao.addPerson(person));
    }
    //���Ա���
    @Test
    public void testListAll() throws Exception{
        System.out.println(personDao.listAllPerson());
    }

    @Test
    public void testSelect(){
        String key = "��";
        PersonDao p = new PersonDaoImpl();
        System.out.print (((PersonDaoImpl) p).select(key));
    }
}

