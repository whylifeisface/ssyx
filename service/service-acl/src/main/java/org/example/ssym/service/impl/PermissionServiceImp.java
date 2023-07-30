package org.example.ssym.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssym.model.acl.Permission;
import org.example.ssym.mapper.PermissionMapper;
import org.example.ssym.service.PermissionService;
import org.example.ssym.util.PermissionHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImp extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
    @Override
    public List<Permission> queryAllPermission() {

        List<Permission> permissionList = baseMapper.selectList(null);
        return PermissionHelper.buildPermission(permissionList);
    }

    @Override
    public boolean removeChildById(Long id) {

      return baseMapper.deleteById(id) >= 0;
    }
}
