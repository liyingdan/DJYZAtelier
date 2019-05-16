package com.djyz.mapper;

import com.djyz.domain.Article;
import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(Long aid);

    int insert(Article record);

    Article selectByPrimaryKey(Long aid);

    List<Article> selectAll();

    int updateByPrimaryKey(Article record);


}