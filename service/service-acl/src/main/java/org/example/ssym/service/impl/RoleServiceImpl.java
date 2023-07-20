package org.example.ssym.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mysql.cj.util.StringUtils;
import com.ssym.model.acl.Role;
import com.ssym.vo.acl.RoleQueryVo;
import org.example.ssym.mapper.RoleMapper;
import org.example.ssym.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Autowired
    private RoleMapper mapper;
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
}
