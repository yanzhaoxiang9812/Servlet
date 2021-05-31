package service;

import entity.User;

public interface LoginService {
    public Object Login(String username,String password,String type);
}
