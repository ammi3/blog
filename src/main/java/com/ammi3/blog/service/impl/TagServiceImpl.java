package com.ammi3.blog.service.impl;

import com.ammi3.blog.dao.TagDao;
import com.ammi3.blog.domain.Tag;
import com.ammi3.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
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

    @Override
    public List<Tag> getAllTag() {
        return tagDao.getAllTag();
    }

    @Override
    public List<Tag> getTagByString(String text) {
        List<Tag> tags = new ArrayList<>();
        List<Long> longs = convertToList(text);
        for(Long long1 : longs) {
            tags.add(tagDao.getTag(long1));
        }
        return tags;
    }

    @Override
    public int deleteTag(Long id) {
        return tagDao.deleteTag(id);
    }

    @Override
    public Tag getTag(Long id) {
        return tagDao.getTag(id);
    }

    @Override
    public Tag getTagByName(String name) {
        return tagDao.getTagByName(name);
    }

    @Override
    public int saveTag(Tag tag) {
        return tagDao.saveTag(tag);
    }

    @Override
    public int updateTag(Tag tag) {
        return tagDao.updateTag(tag);
    }

    private List<Long> convertToList(String ids) {
        List<Long> list = new ArrayList<>();
        if(!"".equals(ids) && ids != null) {
            String[] idArray = ids.split(",");
            for(int i = 0; i < idArray.length; i++) {
                list.add(new Long(idArray[i]));
            }
        }
        return list;
    }
}
