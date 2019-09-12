package com.ltsk.whcg.service;

import java.util.List;


import com.ltsk.whcg.entity.User;
import com.ltsk.whcg.utils.Result;

public interface UserService {
    public User findByName(String username);

    public boolean addUser(User user);

    public boolean updatePwd(String newPassword, String username, String update_time);

    public List<String> getRoleName(String userid);

	public Result getRoleIdbyName();

    public Result deleteUser(String username);
}
