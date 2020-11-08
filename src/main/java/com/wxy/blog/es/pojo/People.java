package com.wxy.blog.es.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
@Document(
        //映射的索引的名字
        indexName="es_test_02"
        //类型，一般和实体类型一样
        ,type="article")
public class People implements Serializable {
    @Id
    private Integer id;
    @Field(
            //类型
            type = FieldType.Text,
            //是否生成索引,默认是true，如果是false，则保存的时候，不生成索引词条
            index=true,
            //存储文档的时候，生成索引词条所使用的分词器
            analyzer="ik_max_word",
            //进行字段分词搜索的时候，使用的分词器
            searchAnalyzer="ik_max_word"
    )
    private String username;
    @Field(
            //类型
            type = FieldType.Text,
            //是否生成索引,默认是true，如果是false，则保存的时候，不生成索引词条
            index=true,
            //存储文档的时候，生成索引词条所使用的分词器
            analyzer="ik_max_word",
            //进行字段分词搜索的时候，使用的分词器
            searchAnalyzer="ik_max_word"
    )
    private String password;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
