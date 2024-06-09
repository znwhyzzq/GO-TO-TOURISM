package com.zzq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzq.entity.Message;
import org.apache.ibatis.annotations.Update;


public interface MessageMapper extends BaseMapper<Message> {
    /**
     * 改变状态
     *
     * @param pId
     * @return
     */
    @Update("UPDATE `message` SET STATE=1 WHERE ID=#{pId}")
    public boolean updateStateByPid(Long pId);

}
