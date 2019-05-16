package com.djyz.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter@Getter@ToString
public class PageList {
    private Long total;
    private List<?> rows = new ArrayList<>();
}
