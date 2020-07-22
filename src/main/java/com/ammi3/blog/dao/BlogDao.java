package com.ammi3.blog.dao;

import com.ammi3.blog.domain.Blog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogDao {

    List<Blog> getIndexBlog();

    List<Blog> getAllRecommendBlog();

    Blog getDetailBlog(Long id);

    List<Blog> getSearchBlog(String query);

    List<Blog> getByTypeId(Long typeId);

    List<Blog> getByTagId(Long tagId);

    List<Blog> searchAllBlog();

    List<String> findGroupYear();

    List<Blog> findByYear(String year);
}
