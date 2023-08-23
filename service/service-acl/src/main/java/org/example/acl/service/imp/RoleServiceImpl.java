package org.example.acl.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.acl.mapper.RoleMapper;
import org.example.acl.service.AdminRoleService;
import org.example.acl.service.RoleService;
import org.example.model.acl.AdminRole;
import org.example.model.acl.Role;
import org.example.vo.acl.RoleQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
        implements RoleService {


    @Autowired
    private AdminRoleService adminRoleService;
    //角色分页列表
    @Override
    public IPage<Role> selectPage(Page<Role> pageParam, RoleQueryVo roleQueryVo) {
        /* 获取条件值：角色名称*/
        String roleName = roleQueryVo.getRoleName();
        /*创建条件构造器对象*/
        LambdaQueryWrapper<Role> wrapper = new LambdaQueryWrapper<>();
        /*判断条件值是否为空*/
        if(!StringUtils.isEmpty(roleName)) {
            /*封装条件*/
            wrapper.like(Role::getRoleName,roleName);
//            wrapper.eq(Role::getIsDeleted, 0);
        }
        /*调用mapper方法实现条件分页查询*/
        IPage<Role> pageModel = baseMapper.selectPage(pageParam, wrapper);
        return pageModel;
    }

    @Override
    public Map<String, Object> findRoleByUserId(Long adminId) {

        /*查询所有的角色*/
        List<Role> allRolesList =baseMapper.selectList(null);

        /* 拥有的角色id*/
        List<AdminRole> existUserRoleList = adminRoleService.list(new QueryWrapper<AdminRole>().eq("admin_id", adminId).select("role_id"));
        List<Long> existRoleList = existUserRoleList.stream().map(AdminRole::getRoleId).collect(Collectors.toList());

        /*对角色进行分类*/
        List<Role> assignRoles = new ArrayList<Role>();
        for (Role role : allRolesList) {
            /*已分配*/
            if(existRoleList.contains(role.getId())) {
                assignRoles.add(role);
            }
        }

        Map<String, Object> roleMap = new HashMap<>();
        roleMap.put("assignRoles", assignRoles);
        roleMap.put("allRolesList", allRolesList);
        return roleMap;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveUserRoleRealtionShip(Long adminId, Long[] roleIds) {
        /*
        删除用户分配的角色数据
         */
        adminRoleService.remove(new QueryWrapper<AdminRole>().eq("admin_id", adminId));

        /*分配新的角色*/
        List<AdminRole> userRoleList = new ArrayList<>();
        for(Long roleId : roleIds) {
            if(StringUtils.isEmpty(roleId.toString())) continue;
            AdminRole userRole = new AdminRole();
            userRole.setAdminId(adminId);
            userRole.setRoleId(roleId);
            userRoleList.add(userRole);
        }
        adminRoleService.saveBatch(userRoleList);
    }

}