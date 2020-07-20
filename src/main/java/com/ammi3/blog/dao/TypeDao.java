package com.ammi3.blog.dao;

import com.ammi3.blog.domain.Type;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeDao {

    List<Type> getBlogType();
}
