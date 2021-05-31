package service.impl;

import entity.Admin;
import entity.User;
import repostitory.AdminRepostitory;
import repostitory.UserRepostitory;
import repostitory.impl.AdminRepostitoryImpl;
import repostitory.impl.UserRepostitoryImpl;
import service.LoginService;

import java.nio.file.AccessDeniedException;

public class LoginServiceImpl implements LoginService {
    private UserRepostitory userRepostitory = new UserRepostitoryImpl();
    private AdminRepostitory adminRepostitory = new AdminRepostitoryImpl();
    @Override
    public Object Login(String username, String password,String type) {
        Object object = null;
        switch (type){
            case "user":
                object = userRepostitory.Login(username,password);
                break;
            case "admin":
                object = adminRepostitory.Login(username,password);
                break;
        }
        return object;
    }
}
