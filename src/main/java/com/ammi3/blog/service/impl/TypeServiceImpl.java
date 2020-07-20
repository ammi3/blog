package com.ammi3.blog.service.impl;

import com.ammi3.blog.dao.TypeDao;
import com.ammi3.blog.domain.Type;
import com.ammi3.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    @Override
    public List<Type> getBlogType() {
        return typeDao.getBlogType();
    }
}
