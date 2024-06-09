package com.zzq.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author zzq
 * @since 2024-01-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "StrategyNum对象", description = "")
@TableName("t_strategy_num")
public class StrategyNum implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "发表id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @ApiModelProperty(value = "攻略id")
    private Long strategyId;
    @ApiModelProperty(value = "攻略收藏数")
    private Integer collectCount;
    @ApiModelProperty(value = "点赞数")
    private Integer numberOfLikes;
    @ApiModelProperty(value = "发表用户")
    private Long userId;
    @ApiModelProperty(value = "0为为未删除 1为删除")
    @TableLogic
    private Integer deleteStates;
    @ApiModelProperty(value = "攻略标题")
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "添加时间")
    private Date addTime;


}
