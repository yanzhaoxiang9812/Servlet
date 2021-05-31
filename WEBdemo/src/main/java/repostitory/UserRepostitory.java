package repostitory;

import entity.User;

public interface UserRepostitory {
    public User Login(String username,String password);
}
