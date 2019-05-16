package com.djyz.domain;

import lombok.Data;

@Data
public class Comment {
    private Long comId;

    private Long articleId;

    private String comContent;

    private Customer customer;


}