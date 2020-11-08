package com.wxy.blog.es.dao;

import com.wxy.blog.es.pojo.People;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * elasticsearch<类型,主键类型>
 */


public interface PeopelDao extends ElasticsearchRepository<People,Integer> {
//    按照名称进行查询,pageable
//    PageRequest.of() 分页
    public Page<People> findByUsernameOrPasswordLike(String content, String content2, Pageable pageable);


}
