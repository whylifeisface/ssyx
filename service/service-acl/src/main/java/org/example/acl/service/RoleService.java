package org.example.acl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.model.acl.Role;
import org.example.vo.acl.RoleQueryVo;

import java.util.Map;

public interface RoleService extends IService<Role> {
    //角色分页列表
    IPage<Role> selectPage(Page<Role> pageParam, RoleQueryVo roleQueryVo);

    Map<String, Object> findRoleByUserId(Long adminId);

    void saveUserRoleRealtionShip(Long adminId, Long[] roleId);
}