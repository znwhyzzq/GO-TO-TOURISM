package com.zzq.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author zzq
 * @since
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "Collection对象", description = "")
@TableName("t_collection")
public class Collection implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("Product_Id")
    private Long productId;
    @TableField("USER_ID")
    private Long userId;
    @TableField("ADD_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date addTime;
    @TableField("Product_Type")
    private Integer productType;
    private String title;
    private Integer collections;
    // private Integer deleteState;


}
