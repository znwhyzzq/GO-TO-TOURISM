package com.zzq.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzq.DTO.RoleMenuAddDTO;
import com.zzq.DTO.UserRoleAddVo;
import com.zzq.DTO.UserRoleDTO;
import com.zzq.entity.Role;
import com.zzq.entity.UserRole;
import com.zzq.exception.GlobalExceptionHandler;
import com.zzq.qo.RoleQuery;
import com.zzq.qo.RoleUserListQuery;

public interface RoleService extends IService<Role> {

    /**
     * 获取角色详情
     *
     * @param id
     * @return
     * @throws GlobalExceptionHandler
     */
    Role getRole(Long id) throws GlobalExceptionHandler;

    /**
     * 删除角色
     *
     * @param id
     * @return
     * @throws GlobalExceptionHandler
     */
    void delete(Long id) throws GlobalExceptionHandler;

    /**
     * 新增or修改角色
     *
     * @param role
     * @return
     * @throws GlobalExceptionHandler
     */
    Boolean addOrUpdateRole(Role role) throws Exception;

    /**
     * 是否启用
     *
     * @return
     * @throws GlobalExceptionHandler
     */
    Boolean updateState(Role role) throws GlobalExceptionHandler;

    /**
     * 关联用户
     */
    Boolean associatedUser(UserRoleAddVo userRoleAddVo) throws Exception;

    /**
     * 取消关联
     *
     * @param userRoleDTO
     * @return
     */
    Boolean deleteAssociated(UserRoleDTO userRoleDTO) throws GlobalExceptionHandler;

    /**
     * 角色列表
     *
     * @param roleQuery
     * @return
     */
    IPage<Role> list(RoleQuery roleQuery);

    /**
     * 获取关联用户列表
     *
     * @param query
     * @return
     * @throws GlobalExceptionHandler
     */
    IPage<UserRole> roleUserList(RoleUserListQuery query) throws GlobalExceptionHandler;

    /**
     * 批量授权
     *
     * @param roleMenuAddDTO
     * @throws GlobalExceptionHandler
     */
    void volumeLicensing(RoleMenuAddDTO roleMenuAddDTO) throws GlobalExceptionHandler;
}
