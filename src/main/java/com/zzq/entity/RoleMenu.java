package com.zzq.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data
@TableName("sys_role_menu")
public class RoleMenu {
    @TableField("role_id")
    private Long roleId;
    @TableField("menu_id")
    private Long menuId;
    @TableId(value = "role_menu_code",type = IdType.AUTO)
    private String roleMenuCode;
    @TableField("is_accredit")
    private Integer isAccredit;
    @TableField("create_by")
    private String createBy;
    @TableField("create_time")
    private Date createTime;
    @TableLogic
    @TableField("is_deleted")
    private Long isDeleted;


}
