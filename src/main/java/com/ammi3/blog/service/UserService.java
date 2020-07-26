package com.ammi3.blog.service;

import com.ammi3.blog.domain.User;

public interface UserService {

    User checkUser(String username, String password);
}
