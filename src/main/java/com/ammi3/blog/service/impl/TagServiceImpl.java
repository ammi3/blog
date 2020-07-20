package com.ammi3.blog.service.impl;

import com.ammi3.blog.dao.TagDao;
import com.ammi3.blog.domain.Tag;
import com.ammi3.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    /**
     * 获取主页标签
     * @return
     */
    @Override
    public List<Tag> getBlogTag() {
        return tagDao.getBlogTag();
    }
}
