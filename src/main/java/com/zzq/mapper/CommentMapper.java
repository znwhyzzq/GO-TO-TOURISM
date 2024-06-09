package com.zzq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzq.entity.Comment;
import com.zzq.vo.CommentVo;
import org.apache.ibatis.annotations.Insert;

import java.util.List;


public interface CommentMapper extends BaseMapper<Comment> {

    //一级评论


    public List<CommentVo> getCommentAll();

    @Insert("INSERT INTO COMMENT (content, user_id,p_id) VALUES ( #{content},#{userId},#{pId})")
    public boolean comments(Comment comment);


}
