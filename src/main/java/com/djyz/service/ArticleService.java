package com.djyz.service;

import com.djyz.domain.Article;
import com.djyz.util.AjaxRes;

import java.util.List;

public interface ArticleService {
    AjaxRes addArticle(Article article);

    AjaxRes articleSupport(Long aid);

    AjaxRes articleNonSupport(Long aid);

    List<Article> getAllArticles();
}
