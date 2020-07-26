package com.ammi3.blog.dao;

import com.ammi3.blog.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao {

    User checkUser(@Param("username") String username, @Param("password") String password);
}
