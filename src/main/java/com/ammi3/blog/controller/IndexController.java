package com.ammi3.blog.controller;

import com.ammi3.blog.NotFoundException;
import com.ammi3.blog.domain.Blog;
import com.ammi3.blog.domain.Tag;
import com.ammi3.blog.domain.Type;
import com.ammi3.blog.service.BlogService;
import com.ammi3.blog.service.TagService;
import com.ammi3.blog.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private TagService tagService;

    /**
     * 主页
     * @param pageNum
     * @param model
     * @return
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(@RequestParam(required = false, defaultValue = "1", value = "pageNum")int pageNum, Model model) {
        PageHelper.startPage(pageNum, 5);
        List<Blog> allBlog = blogService.getIndexBlog();
        List<Type> allType = typeService.getBlogType();
        List<Tag> allTag = tagService.getBlogTag();
        List<Blog> recommendBlog = blogService.getAllRecommendBlog();

        PageInfo pageInfo = new PageInfo(allBlog);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("tags", allTag);
        model.addAttribute("types", allType);
        model.addAttribute("recommendBlogs", recommendBlog);
        return "index";
    }

    @RequestMapping(value = "/blog/{id}", method = RequestMethod.GET)
    public String toLogin(@PathVariable Long id, Model model) {
        Blog blog = blogService.getDetailBlog(id);
        model.addAttribute("blog", blog);
        return "blog";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String search(@RequestParam(required = false, defaultValue = "1", value = "pagenum")int pagenum,
                         @RequestParam String query, Model model) {
        PageHelper.startPage(pagenum, 5);
        List<Blog> searchBlog = blogService.getSearchBlog(query);
        PageInfo pageInfo = new PageInfo(searchBlog);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("query", query);
        return "search";
    }
}
