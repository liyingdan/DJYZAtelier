package com.djyz.service;

import com.djyz.domain.Article;
import com.djyz.domain.Customer;
import com.djyz.util.AjaxRes;

import java.util.List;

public interface ArticleService {
    AjaxRes addArticle(Article article);

    AjaxRes articleSupport(Long aid);

    AjaxRes articleNonSupport(Long aid);

    List<Article> getAllArticles();

//    List<Article> getArticlesWithCustId(Customer customer);
    List<Article> getArticlesWithCustId(Long custId);

    AjaxRes deleteArticlesWithCustId(Long aid);
}
