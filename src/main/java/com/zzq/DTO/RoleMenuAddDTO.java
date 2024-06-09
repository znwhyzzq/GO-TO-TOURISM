package com.zzq.DTO;

import lombok.Data;

import java.util.List;

@Data
public class RoleMenuAddDTO {
    private Long roleId;
    private List<Long> menuIds;
}
