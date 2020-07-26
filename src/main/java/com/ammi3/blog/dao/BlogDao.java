package com.ammi3.blog.dao;

import com.ammi3.blog.domain.Blog;
import com.ammi3.blog.domain.BlogAndTag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
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

    List<Blog> getAllBlog();

    List<Blog> searchBlogs(Blog blog);

    Blog getBlog(Long id);

    int deleteBlog(Long id);

    int saveBlog(Blog blog);

    int saveBlogAndTag(BlogAndTag blogAndTag);

    int updateBlog(Blog blog);
}
