package com.zzq.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
@TableName("sys_user_role")
public class UserRole {
    @TableField("user_id")
    private Long userId;
    @TableField("role_id")
    private Long roleId;
    @TableField("user_name")
    private String userName;
    @TableField("add_admin")
    private String addAdmin;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @TableField("create_time")
    private Date createTime;
    @TableLogic
    private Long del;
    @TableId(value = "user_role_code",type = IdType.AUTO)
    private String UserRoleCode;


}
