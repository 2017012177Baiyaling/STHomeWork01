package com.dao.users;
import com.entity.users.Users;

public interface UsersDao {

    public Users selectByName(String username);

    public  boolean register(Users users);

}
