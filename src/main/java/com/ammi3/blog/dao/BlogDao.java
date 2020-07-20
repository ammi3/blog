package com.ammi3.blog.dao;

import com.ammi3.blog.domain.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogDao {

    List<Blog> getIndexBlog();

    List<Blog> getAllRecommendBlog();
}
