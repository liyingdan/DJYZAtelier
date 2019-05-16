package com.djyz.service;

import com.djyz.domain.Comment;
import com.djyz.util.AjaxRes;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentsWithAid(Long articleId);

    AjaxRes addComment(Comment comment);

    int getCommentsAmount(Long articleId);
}
