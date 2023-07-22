package org.example.ssym.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ssym.model.acl.Permission;

import java.util.List;

public interface PermissionService extends IService<Permission> {
    List<Permission> queryAllPermission();

    boolean removeChildById(Long id);
}
