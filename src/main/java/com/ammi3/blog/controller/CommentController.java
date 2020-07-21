package com.ammi3.blog.controller;

import com.ammi3.blog.domain.Comment;
import com.ammi3.blog.domain.User;
import com.ammi3.blog.service.BlogService;
import com.ammi3.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

    @Value("${comment.avatar}")
    private String avatar;

    /**
     * 显示对应文章的评论
     * @param blogId
     * @param model
     * @return
     */
    @RequestMapping(value = "comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model) {
        model.addAttribute("comments", commentService.getCommentByBlog(blogId));
        model.addAttribute("blog", blogService.getDetailBlog(blogId));
        return "blog::commentList";
    }

    @RequestMapping(value = "comments", method = RequestMethod.POST)
    public String post(Comment comment, HttpSession httpSession) {
        Long blogId = comment.getBlog().getId();
        comment.setBlog(blogService.getDetailBlog(blogId));
        comment.setBlogId(blogId);
        User user = (User) httpSession.getAttribute("user");
        if(user != null) {
            comment.setAvatar(user.getAvatar());
            comment.setAdminComment(true);
        } else {
            comment.setAvatar(avatar);
        }

        System.out.println(comment);
        commentService.saveComment(comment);
        return "redirect:/comments/" + blogId;
    }
}
