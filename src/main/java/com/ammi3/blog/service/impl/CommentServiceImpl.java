package com.ammi3.blog.service.impl;

import com.ammi3.blog.dao.CommentDao;
import com.ammi3.blog.domain.Comment;
import com.ammi3.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public List<Comment> getCommentByBlog(Long blogId) {
        List<Comment> comments = commentDao.getCommentByBlog(blogId, Long.parseLong("-1"));
        return comments;
    }

    @Override
    public int saveComment(Comment comment) {
        Long parentCommentId = comment.getParentComment().getId();
        if(parentCommentId != -1) {
            comment.setParentComment(commentDao.findByParentCommentId(parentCommentId));
        } else {
            comment.setParentCommentId((long) -1);
            comment.setParentComment(null);
        }
        comment.setCreateTime(new Date());
        return commentDao.saveComment(comment);
    }
}
