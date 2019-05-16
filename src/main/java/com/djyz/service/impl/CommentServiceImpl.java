package com.djyz.service.impl;

import com.djyz.domain.Article;
import com.djyz.domain.Comment;
import com.djyz.mapper.CommentMapper;
import com.djyz.service.CommentService;
import com.djyz.util.AjaxRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    /*根据文章id获取评论*/
    @Override
    public List<Comment> getCommentsWithAid(Long articleId) {
        return commentMapper.getCommentsWithAid(articleId);
    }

    /*根据文章id添加评论*/
    @Override
    public AjaxRes addComment(Comment comment) {
        System.out.println("service----------------"+comment);
        AjaxRes ajaxRes = new AjaxRes();
        try{
            //添加评论
            commentMapper.insert(comment);
            //更新文章表中的数量
            int commentsAmount = commentMapper.getCommentsAmount(comment.getArticleId());
            Article article1 = new Article();
            article1.setAid(comment.getArticleId());
            article1.setNumComment((long) commentsAmount);
            commentMapper.updateArticleCommentAmount(article1);

            ajaxRes.setMsg("评论成功");
            ajaxRes.setSuccess(true);
        }catch (Exception e){
            ajaxRes.setMsg("评论失败");
            ajaxRes.setSuccess(false);
        }
        return ajaxRes;
    }

    /*根据文章id查询评论数量*/
    @Override
    public int getCommentsAmount(Long articleId) {
        return commentMapper.getCommentsAmount(articleId);
    }
}
