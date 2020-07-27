package com.ammi3.blog.dao;

import com.ammi3.blog.domain.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface TagDao {

    List<Tag> getBlogTag();

    List<Tag> getAllTag();

    Tag getTag(Long id);

    int deleteTag(Long id);

    Tag getTagByName(String name);

    int saveTag(Tag tag);

    int updateTag(Tag tag);
}
