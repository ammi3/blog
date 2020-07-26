package com.ammi3.blog.service.impl;

import com.ammi3.blog.dao.UserDao;
import com.ammi3.blog.domain.User;
import com.ammi3.blog.service.UserService;
import com.ammi3.blog.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User checkUser(String username, String password) {
        User user = userDao.checkUser(username, MD5Utils.code(password));
        return user;
    }
}
