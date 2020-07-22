package com.ammi3.blog.controller;

import com.ammi3.blog.domain.Blog;
import com.ammi3.blog.domain.Tag;
import com.ammi3.blog.service.BlogService;
import com.ammi3.blog.service.TagService;
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
public class TagController {

    @Autowired
    private TagService tagService;

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/tags/{id}", method = RequestMethod.GET)
    public String tags(@PathVariable long id, @RequestParam(required = false, defaultValue = "1", value = "pageNum")int pageNum, Model model) {
        PageHelper.startPage(pageNum, 20);
        List<Tag> tags = tagService.getBlogTag();
        if(id == -1) id = tags.get(0).getId();
        List<Blog> blogs = blogService.getByTagId(id);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("tags", tags);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("activeTagId", id);
        return "tags";
    }
}
