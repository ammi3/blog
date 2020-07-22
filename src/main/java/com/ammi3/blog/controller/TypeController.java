package com.ammi3.blog.controller;

import com.ammi3.blog.domain.Blog;
import com.ammi3.blog.domain.Type;
import com.ammi3.blog.service.BlogService;
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
public class TypeController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/types/{id}", method = RequestMethod.GET)
    public String types(@PathVariable Long id, @RequestParam(required = false, defaultValue = "1", value = "pageNum")int pageNum, Model model) {
        PageHelper.startPage(pageNum, 20);
        List<Type> types = typeService.getBlogType();
        if(id == -1) id = types.get(0).getId();
        List<Blog> blogs = blogService.getByTypeId(id);
        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("types", types);
        model.addAttribute("activeTypeId", id);
        return "types";
    }
}
