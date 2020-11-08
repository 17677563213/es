package com.wxy.blog.es.service;

import com.wxy.blog.es.dao.PeopelDao;
import com.wxy.blog.es.pojo.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

public class PeopleService {
    @Autowired
    public PeopelDao peopelDao;

    public void save(People people){
        peopelDao.save(people);

    }

    public Page<People> search(String content, Pageable pageable){
        Page<People> byUsernameOrPasswordLike = peopelDao.findByUsernameOrPasswordLike(content, content, pageable);
        return byUsernameOrPasswordLike;
    }
}
