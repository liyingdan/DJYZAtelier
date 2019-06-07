package com.djyz.web;

import com.djyz.domain.Article;
import com.djyz.domain.Customer;
import com.djyz.service.ArticleService;
import com.djyz.util.AjaxRes;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(value = "/Article", tags = "Article接口")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /*增加文章*/
    @PostMapping("/addArticle")
    @ResponseBody
    public AjaxRes addArticle(Article article){
        return articleService.addArticle(article);
    }

    /*文章点赞*/
    @PostMapping("/articleSupport/{aid}")
    @ResponseBody
    public AjaxRes articleSupport(@PathVariable Long aid){
        return articleService.articleSupport(aid);
    }

    /*踩文章*/
    @PostMapping("/articleNonSupport/{aid}")
    @ResponseBody
    public AjaxRes articleNonSupport(@PathVariable Long aid){
        return articleService.articleNonSupport(aid);
    }

    /*查询全部文章*/
    @GetMapping("/getAllArticles")
    @ResponseBody
    public List<Article> getAllArticles(){
        return articleService.getAllArticles();
    }

   /* *//*根据用户id查询文章*//*
    @GetMapping("/getArticlesWithCustId")
    @ResponseBody
    public List<Article> getArticlesWithCustId(Customer customer){
        return articleService.getArticlesWithCustId(customer);
    }*/

    /*根据用户id查询文章*/
    @GetMapping("/getArticlesWithCustId/{custId}")
    @ResponseBody
    public List<Article> getArticlesWithCustId(@PathVariable Long custId){
        return articleService.getArticlesWithCustId(custId);
    }

    /*根据id删除文章*/
    @DeleteMapping("/deleteArticlesWithaid/{aid}")
    @ResponseBody
    public AjaxRes deleteArticlesWithCustId(@PathVariable Long aid){
        return articleService.deleteArticlesWithCustId(aid);

    }




}
