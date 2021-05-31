package repostitory;

import entity.Admin;

public interface AdminRepostitory {
    public Admin Login(String username, String password);
}
