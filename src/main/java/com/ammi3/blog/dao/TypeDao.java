package com.ammi3.blog.dao;

import com.ammi3.blog.domain.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface TypeDao {

    List<Type> getBlogType();

    List<Type> getAllType();

    Type getType(Long id);

    int deleteType(Long id);

    Type getTypeByName(String name);

    int saveType(Type type);

    int updateType(Type type);
}
