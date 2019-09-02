package com.xuan.blog.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Created by hx on 2019/8/23
 */
@Getter
@Setter
@ToString
public class Article {

    private Integer id;

    private String title;

    private String content;

    private Integer userId;

    private Date createTime;

    private String userAccout;

}
