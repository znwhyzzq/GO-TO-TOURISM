package com.zzq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzq.comon.ResponseResult;
import com.zzq.entity.Comment;


public interface CommentService extends IService<Comment> {

    ResponseResult getComment();

    public ResponseResult publisher(Comment comment);

    /**
     * 查找所有评论
     *
     * @return
     */
    public ResponseResult comments(Comment comment);

    ResponseResult getcommentsByPid(Long id);

    ResponseResult detete(Comment comment);

    ResponseResult getCommentAll(Long foreignId);
}
