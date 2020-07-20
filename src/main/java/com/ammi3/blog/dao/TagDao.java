package com.ammi3.blog.dao;

import com.ammi3.blog.domain.Tag;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagDao {

    List<Tag> getBlogTag();
}
