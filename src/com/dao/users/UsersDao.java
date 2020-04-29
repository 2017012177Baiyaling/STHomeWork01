package com.dao.users;
import com.entity.users.Users;

public interface UsersDao {
    /**
     * 登录
     * @param username
     * @return
     */
    public Users selectByName(String username);
    /**
     * 注册
     * @param users
     * @return
     */
    public  boolean register(Users users);

}
