package com.djyz.domain;

import lombok.Data;

@Data
public class Article {
    private Long aid;

    private String title;

    private String artDescribe;

    private Long numSupport;

    private Long numNonsupport;

    private Long numComment;

    private String content;

    private Customer customer;

}