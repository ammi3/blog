package com.ammi3.blog.controller;

import com.ammi3.blog.domain.Blog;
import com.ammi3.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ArchiveController {

    @Autowired
    private BlogService blogService;

    @RequestMapping(value = "/archives", method = RequestMethod.GET)
    public String archives(Model model) {
        model.addAttribute("archiveMap", blogService.archiveBlog());
        model.addAttribute("blogCount", blogService.countBlog());
        return "archives";
    }
}
