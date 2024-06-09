package com.zzq.controller;


import com.zzq.comon.ResponseResult;
import com.zzq.entity.Comment;
import com.zzq.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/comment")
//@PreAuthorize("hasRole('Admin')")
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * 获取所有评论列表-父级-子级
     *
     * @return
     */
    @GetMapping("/getComment")
    public ResponseResult getComment() {
        return commentService.getComment();

    }

    /**
     * 获取模块业务所有评论列表-父级-子级
     *
     * @return
     */
    @GetMapping("/getCommentAll")
    public ResponseResult getCommentAll(Long foreignId) {
        return commentService.getCommentAll(foreignId);

    }

    /**
     * 发表评论
     *
     * @param comment
     * @return
     */
    @PostMapping("/publisher")
    public ResponseResult publisher(@RequestBody Comment comment) {
        return commentService.publisher(comment);
    }

    /**
     * 评论
     *
     * @param comment
     * @return
     */
    @PostMapping("/comments")
    public ResponseResult comments(@RequestBody Comment comment) {
        return commentService.comments(comment);
    }

    /**
     * 获取所有子评论
     *
     * @param id
     * @return
     */
    @GetMapping("/getcommentsByPid")
    public ResponseResult getcommentsByPid(@PathVariable Long id) {
        return commentService.getcommentsByPid(id);
    }

    @PostMapping("/detete")
    public ResponseResult detete(@RequestBody Comment comment) {
        return commentService.detete(comment);
    }


}
