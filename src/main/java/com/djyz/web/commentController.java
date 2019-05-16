package com.djyz.web;

import com.djyz.domain.Comment;
import com.djyz.service.CommentService;
import com.djyz.util.AjaxRes;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Api(value = "/comment", tags = "comment接口")
public class commentController {
    @Autowired
    private CommentService commentService;

    /*根据文章id获取评论*/
    @GetMapping("/getCommentsWithAid/{articleId}")
    @ResponseBody
    public List<Comment> getCommentsWithAid(@PathVariable Long articleId){
        return commentService.getCommentsWithAid(articleId);
    }

    /*根据文章id添加评论--用户id*/
    @PostMapping("/addComment")
    @ResponseBody
    public AjaxRes addComment(Comment comment){
        return commentService.addComment(comment);
    }

    /*根据文章id查询评论数量*/
    @GetMapping("/getCommentsAmount/{articleId}")
    @ResponseBody
    public int getCommentsAmount(@PathVariable Long articleId){
        return commentService.getCommentsAmount(articleId);
    }



}
