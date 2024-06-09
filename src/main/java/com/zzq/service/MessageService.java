package com.zzq.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzq.entity.Message;
import com.zzq.exception.GlobalExceptionHandler;
import com.zzq.exception.GlobalExceptionMyHandler;
import com.zzq.qo.MessageQuery;
import com.zzq.vo.MessageVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public interface MessageService extends IService<Message> {

    ArrayList<MessageVo> getMessage() throws GlobalExceptionHandler;

    ArrayList<MessageVo> getMessageUser(Long id) throws GlobalExceptionHandler;

    Boolean addMessage(Message message) throws GlobalExceptionHandler;

    Message findMessageById(Long id) throws GlobalExceptionMyHandler;

    Boolean deleteById(Message message) throws GlobalExceptionHandler;


    List<Map<String, Object>> stateAll() throws GlobalExceptionHandler;

    IPage<Message> listPage(MessageQuery query) throws GlobalExceptionHandler;

    Boolean reply(Message message) throws GlobalExceptionHandler;


    IPage<Message> listMessage(MessageQuery query) throws GlobalExceptionHandler;

    Integer stateReply() throws GlobalExceptionHandler;

    List<Message> listReply(Long id) throws GlobalExceptionHandler;
}
