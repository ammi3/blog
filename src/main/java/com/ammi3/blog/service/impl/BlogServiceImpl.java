package com.ammi3.blog.service.impl;

import com.ammi3.blog.NotFoundException;
import com.ammi3.blog.dao.BlogDao;
import com.ammi3.blog.domain.Blog;
import com.ammi3.blog.service.BlogService;
import com.ammi3.blog.utils.MarkdownUtils;
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

    /**
     * 根据id获取具体博客
     * @param id
     * @return
     */
    @Override
    public Blog getDetailBlog(Long id) {
        Blog blog = blogDao.getDetailBlog(id);
        if(blog == null) {
            throw new NotFoundException("该博客不存在");
        }
        // 解析博客内容由markdown转换为html
        String content = blog.getContent();
        blog.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        return blog;
    }

    /**
     * 搜索博客
     * @param query
     * @return
     */
    @Override
    public List<Blog> getSearchBlog(String query) {
        return blogDao.getSearchBlog(query);
    }
}
