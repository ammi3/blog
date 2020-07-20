package com.ammi3.blog.service.impl;

import com.ammi3.blog.dao.BlogDao;
import com.ammi3.blog.domain.Blog;
import com.ammi3.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogDao blogDao;

    /**
     * 获取主页显示博客
     * @return
     */
    @Override
    public List<Blog> getIndexBlog() {
        return blogDao.getIndexBlog();
    }

    /**
     * 获取主页推荐博客
     * @return
     */
    @Override
    public List<Blog> getAllRecommendBlog() {
        return blogDao.getAllRecommendBlog();
    }
}
