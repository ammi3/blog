package com.ammi3.blog.service;


import com.ammi3.blog.domain.Blog;

import java.util.List;
import java.util.Map;

public interface BlogService {

    List<Blog> getIndexBlog();

    List<Blog> getAllRecommendBlog();

    Blog getDetailBlog(Long id);

    List<Blog> getSearchBlog(String query);

    List<Blog> getByTypeId(Long typeId);

    List<Blog> getByTagId(Long tagId);

    Map<String, List<Blog>> archiveBlog();

    int countBlog();

    List<Blog> getAllBlog();

    List<Blog> searchBlogs(Blog blog);

    Blog getBlog(Long id);

    int deleteBlog(Long id);

    int saveBlog(Blog blog);

    int updateBlog(Blog blog);
}
