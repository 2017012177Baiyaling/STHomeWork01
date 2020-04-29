package com.servlet.user;
import com.dao.users.UsersDao;
import com.dao.users.impl.UsersDaoImpl;
import com.entity.users.Users;
import com.util.web.WebContents;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(name = "UserServlet", urlPatterns = "/user",asyncSupported = true)
public class UserServlet extends HttpServlet {
    public UserServlet(){
        super();
    }

    @Override
    public void destroy(){
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        
        response.setContentType("text/html");
     
        request.setCharacterEncoding("utf-8");
      
        response.setCharacterEncoding("utf-8");
  
        PrintWriter out = response.getWriter();
 

        String state = request.getParameter("state");

        switch (state) {
            case"tologin":
                RequestDispatcher rd1 = request.getRequestDispatcher(WebContents.LOGIN);
                rd1.forward(request,response);
            case "login":
                login(request, response);
                break;
            case"toRegister":
                RequestDispatcher rd2 = request.getRequestDispatcher(WebContents.REGISTER);
                rd2.forward(request,response);
            case "register":
                register(request, response);
                break;
            case "quit":
                quit(request,response);
                break;
        }
    }

    /** 登录*/
    private void login(HttpServletRequest request,HttpServletResponse response)throws IOException{
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UsersDao usersDao = new UsersDaoImpl();
        Users user = null;
        user = usersDao.selectByName(username);
        RequestDispatcher rd = null;
        if(user != null){
            if(user.getPassword().equals(password)){
                request.getSession().setAttribute("user",user);
                session.setAttribute("currentUsername",username);
                rd = request.getRequestDispatcher("/person?state=home");
                rd.forward(request,response);
            }else{
                rd = request.getRequestDispatcher(WebContents.LOGIN);
                request.setAttribute("msg","密码错误！");
                rd.forward(request,response);
            }
        }else{
            rd = request.getRequestDispatcher(WebContents.LOGIN);
            request.setAttribute("msg","该用户不存在！");
            rd.forward(request,response);
        }
    }

    private void register(HttpServletRequest request,HttpServletResponse response)throws IOException{
        RequestDispatcher rd = null;
        UsersDao usersDao1 = new UsersDaoImpl();
        UsersDao usersDao2 = new UsersDaoImpl();
        Users user1 = new Users();
        Users user2 = new Users();
        user1.setUsername(request.getParameter("username"));
        user2 = usersDao2.selectByName(request.getParameter("username"));
        if(user2 == null){
            user1.setPassword(request.getParameter("password"));
            usersDao1.register(user1);
            rd = request.getRequestDispatcher("/user?state=login");
            rd.forward(request,response);
        }else{
            request.setAttribute("msg","用户名已存在，请重新输入！");
            rd = request.getRequestDispatcher(WebContents.REGISTER);
            rd.forward(request,response);
        }
    }

    /**
     * 退出
     * @param request
     */
    private void quit(HttpServletRequest request,HttpServletResponse response)throws IOException{
        HttpSession session = request.getSession();
        session.removeAttribute("currentUsername");
        RequestDispatcher rd1 = request.getRequestDispatcher(WebContents.LOGIN);
        rd1.forward(request,response);
    }
}

