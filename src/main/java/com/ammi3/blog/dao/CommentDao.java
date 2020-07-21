package com.ammi3.blog.dao;

import com.ammi3.blog.domain.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao {

    List<Comment> getCommentByBlog(@Param("blogId") Long blogId, @Param("blogParentId")Long blogParentId);

    int saveComment(Comment comment);

    Comment findByParentCommentId(@Param("parentCommentId") Long parentCommentId);
}
