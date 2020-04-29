package com.servlet.person;

import com.dao.person.PersonDao;
import com.dao.person.impl.PersonDaoImpl;
import com.entity.person.Person;
import com.util.web.WebContents;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
@WebServlet(name = "PersonServlet", urlPatterns = "/person",asyncSupported = true)
public class PersonServlet extends HttpServlet {
    public PersonServlet(){
        super();
    }
    @Override
    public void destroy(){
        super.destroy();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        doPost(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        
        response.setContentType("text/html");

        request.setCharacterEncoding("utf-8");

        response.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();
   
        String state = request.getParameter("state");
        switch (state){
            case "home":
                listAll(request,response);
                break;
            case"toAdd":
                RequestDispatcher rd1 = request.getRequestDispatcher(WebContents.ADD);
                rd1.forward(request,response);
                break;
            case "add":
                addPerson(request,response);
                break;
            case "toUpdate":
                toUpdate(request,response);
                break;
            case "update":
                editPerson(request,response);
                break;
            case "del":
                del(request,response);
                break;
            case "select":
                select(request,response);
                break;
        }
    }

    private void listAll(HttpServletRequest request, HttpServletResponse response)throws IOException{
        List<Person> list = new ArrayList<>();
        RequestDispatcher rd = null;
        PersonDao personDao = new PersonDaoImpl();
        list = personDao.listAllPerson();
        request.setAttribute("list",list);
        rd = request.getRequestDispatcher(WebContents.HOME);
        rd.forward(request,response);
    }
    private void addPerson(HttpServletRequest request,HttpServletResponse response)throws IOException{
        RequestDispatcher rd = null;
        PersonDao personDao = new PersonDaoImpl();
        Person person = new Person();
        person.setName(request.getParameter("name"));
        person.setSex(request.getParameter("sex"));
        person.setAge(Integer.parseInt(request.getParameter("age")));
        personDao.addPerson(person);
        rd = request.getRequestDispatcher("/person?state=home");
        rd.forward(request,response);
    }

    private void toUpdate(HttpServletRequest request,HttpServletResponse response)throws IOException{
        RequestDispatcher rd = null;
        PersonDao personDao = new PersonDaoImpl();
        Person person = new Person();
        int  id = Integer.parseInt(request.getParameter("id"));
        person = personDao.selectById(id);
        request.setAttribute("person",person);
        rd = request.getRequestDispatcher(WebContents.EDIT);
        rd.forward(request,response);
    }

    private void editPerson(HttpServletRequest request,HttpServletResponse response)throws IOException{
        RequestDispatcher rd = null;
        PersonDao personDao = new PersonDaoImpl();
        Person person = new Person();
        int  id = Integer.parseInt(request.getParameter("id"));
        person.setId(id);
        person.setName(request.getParameter("name"));
        person.setSex(request.getParameter("sex"));
        person.setAge(Integer.parseInt(request.getParameter("age")));
        personDao.updatePerson(person);
        rd = request.getRequestDispatcher("/person?state=home");
        rd.forward(request,response);
    }

    private void del(HttpServletRequest request,HttpServletResponse response)throws IOException{
        RequestDispatcher rd = null;
        int id  = Integer.parseInt(request.getParameter("id"));
        PersonDao personDao = new PersonDaoImpl();
        personDao.delPerson(id);
        rd = request.getRequestDispatcher("/person?state=home");
        rd.forward(request,response);
    }

    private void select (HttpServletRequest request,HttpServletResponse response)throws IOException{
        RequestDispatcher rd = null;
        List<Person> list = new ArrayList<Person>();
        PersonDao personDao = new PersonDaoImpl();
        list = personDao.select(request.getParameter("findName"));
        request.setAttribute("list",list);
        rd = request.getRequestDispatcher(WebContents.SELECT);
        rd.forward(request,response);
    }
}
