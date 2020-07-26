package com.ammi3.blog.service;

import com.ammi3.blog.domain.Tag;

import java.util.List;

public interface TagService {

    List<Tag> getBlogTag();

    List<Tag> getAllTag();

    List<Tag> getTagByString(String text);

    int deleteTag(Long id);

    Tag getTag(Long id);

    Tag getTagByName(String name);
}
