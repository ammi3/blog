package com.ammi3.blog.service;


import com.ammi3.blog.domain.Blog;

import java.util.List;

public interface BlogService {

    List<Blog> getIndexBlog();

    List<Blog> getAllRecommendBlog();

    Blog getDetailBlog(Long id);

    List<Blog> getSearchBlog(String query);
}
