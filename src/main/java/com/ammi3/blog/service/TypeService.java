package com.ammi3.blog.service;

import com.ammi3.blog.domain.Type;

import java.util.List;

public interface TypeService {

    List<Type> getBlogType();

    List<Type> getAllType();

    Type getType(Long id);

    int deleteType(Long id);

    Type getTypeByName(String name);

    int saveType(Type type);

    int updateType(Type type);
}
