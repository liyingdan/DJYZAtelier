package com.djyz.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter@ToString
public class QueryVo {
    private int pageNum;
    private int rows;
    private int cloType;
    private Double price;
    private String keyword;

}
