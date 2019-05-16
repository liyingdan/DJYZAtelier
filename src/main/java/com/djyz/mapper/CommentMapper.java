package com.djyz.mapper;

import com.djyz.domain.Article;
import com.djyz.domain.Comment;
import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Long comId);

    int insert(Comment record);

    Comment selectByPrimaryKey(Long comId);

    List<Comment> selectAll();

    int updateByPrimaryKey(Comment record);

    List<Comment> getCommentsWithAid(Long articleId);

    int getCommentsAmount(Long articleId);


    void updateArticleCommentAmount(Article article1);
}