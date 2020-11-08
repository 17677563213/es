package com.wxy.blog.es.controller;

import com.wxy.blog.es.pojo.People;
import com.wxy.blog.es.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/people")
@CrossOrigin
public class PeopleController {
    @Autowired
    public PeopleService peopleService;

    /**
     * 注意事项:
     *  1.采用logstash:的时候,id在配置文件中需要进行小写
     *  2.通过spring data elasticsearch 库可以自己进行填写一个新的,不能够使用原来的,如果使用原来会出现数据异常
     *
     *
     *  采用spring data elasticsearch  实体类,主键数据类型
     * @param people
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public Map<String,String> save(@RequestBody People people){
        people.setId((int)((Math.random()*9+1)*1000));
        peopleService.save(people);

        HashMap<String, String> resultMap = new HashMap<>();
        resultMap.put("message", "向索引库中添加数据!");
        return resultMap;
    }

    @RequestMapping(value = "/search/{page}/{size}",method = RequestMethod.GET)
    public Object search(@PathVariable Integer page,@PathVariable Integer size,@RequestParam String content){
        PageRequest of = PageRequest.of(page - 1, size);

        Page<People> search = peopleService.search(content, of);

        HashMap<Object, Object> resultMap = new HashMap<>();
        resultMap.put("count", search.getTotalElements());
        resultMap.put("list", search.getContent());
        return resultMap;

        /**
         * 思路:
         *  1.前端传递过来参数要匹配多个数据
         *  2.spring data 类型框架,可以通过名称进行编写查询语句
         *  3.分页形式: 需要采用PageRequest.of() 第一个参数:从什么地方开始,
         */

    }

}
