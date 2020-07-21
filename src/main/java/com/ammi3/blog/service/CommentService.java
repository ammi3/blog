package com.ammi3.blog.service;

import com.ammi3.blog.domain.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getCommentByBlog(Long blogId);

    int saveComment(Comment comment);

}
