package org.example.ssym.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mysql.cj.util.StringUtils;
import com.ssym.model.acl.AdminRole;
import com.ssym.model.acl.Role;
import com.ssym.vo.acl.RoleQueryVo;
import org.example.ssym.mapper.RoleMapper;
import org.example.ssym.service.AdminRoleService;
import org.example.ssym.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Autowired
    private RoleMapper mapper;
    @Autowired
    private AdminRoleService adminRoleService;
    @Override
    public IPage<Role> selectRolePage(Page<Role> rolePage, RoleQueryVo roleVo) {
        //获取条件
        String roleName = roleVo.getRoleName();
        //创建map条件对象
        LambdaQueryWrapper<Role> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //判断是否是空
        if (!StringUtils.isNullOrEmpty(roleName)) {
            lambdaQueryWrapper.like(Role::getRoleName, roleName);
        }
        return mapper.selectPage(rolePage, lambdaQueryWrapper);
    }

    @Override
    public Map<String, Object> getRoleByAdminId(Long adminId) {
        //先查询所有角色
        List<Role> allRoles = baseMapper.selectList(null);
        //在根据用户Id分配角色列表
        LambdaQueryWrapper<AdminRole> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(AdminRole::getAdminId, adminId);
        List<AdminRole> adminRoleList = adminRoleService.list(wrapper);
        /*
        List<AdminRole>  -> List<Long>
         */
        List<Long> roleIdList = adminRoleList.stream().map(AdminRole::getRoleId).collect(Collectors.toList());

        ArrayList<Role> assignRoleList = new ArrayList<>();
        for (Role role : assignRoleList) {
            if (roleIdList.contains(role.getId())) {
                assignRoleList.add(role);
            }
        }
        //封装map
        HashMap<String, Object> result = new HashMap<>();
        //全部role
        result.put("allRoleList", allRoles);
        // 单前人role
        result.put("assignRoles", assignRoleList);
        return result;
    }
}
