package com.ammi3.blog.service.impl;

import com.ammi3.blog.NotFoundException;
import com.ammi3.blog.dao.BlogDao;
import com.ammi3.blog.domain.Blog;
import com.ammi3.blog.domain.BlogAndTag;
import com.ammi3.blog.domain.Tag;
import com.ammi3.blog.service.BlogService;
import com.ammi3.blog.utils.MarkdownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    /**
     * 根据类型id查找博客
     * @param typeId
     * @return
     */
    @Override
    public List<Blog> getByTypeId(Long typeId) {
        return blogDao.getByTypeId(typeId);
    }

    /**
     * 根据标签id查找博客
     * @param tagId
     * @return
     */
    @Override
    public List<Blog> getByTagId(Long tagId) {
        return blogDao.getByTagId(tagId);
    }

    @Override
    public Map<String, List<Blog>> archiveBlog() {
        List<String> years = blogDao.findGroupYear();
        Set<String> set = new HashSet<>(years);
        Map<String, List<Blog>> map = new HashMap<>();
        for(String year : years) {
            map.put(year, blogDao.findByYear(year));
        }
        return map;
    }

    @Override
    public int countBlog() {
        return blogDao.searchAllBlog().size();
    }

    @Override
    public List<Blog> getAllBlog() {
        return blogDao.getAllBlog();
    }

    @Override
    public List<Blog> searchBlogs(Blog blog) {
        return blogDao.searchBlogs(blog);
    }

    @Override
    public Blog getBlog(Long id) {
        return blogDao.getBlog(id);
    }

    @Override
    public int deleteBlog(Long id) {
        return blogDao.deleteBlog(id);
    }

    @Override
    public int saveBlog(Blog blog) {
       blog.setCreateTime(new Date());
       blog.setUpdateTime(new Date());
       blog.setViews(0);
       blogDao.saveBlog(blog);
       Long id = blog.getId();
       List<Tag> tags = blog.getTags();
       BlogAndTag blogAndTag = null;
       for(Tag tag : tags) {
           blogAndTag = new BlogAndTag(tag.getId(), id);
           blogDao.saveBlogAndTag(blogAndTag);
       }
       return 1;
    }

    @Override
    public int updateBlog(Blog blog) {
        blog.setUpdateTime(new Date());
        //将标签的数据存到t_blogs_tag表中
        List<Tag> tags = blog.getTags();
        BlogAndTag blogAndTag = null;
        for (Tag tag : tags) {
            blogAndTag = new BlogAndTag(tag.getId(), blog.getId());
            blogDao.saveBlogAndTag(blogAndTag);
        }
        return blogDao.updateBlog(blog);
    }
}
