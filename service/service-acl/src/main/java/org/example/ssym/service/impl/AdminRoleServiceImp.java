package org.example.ssym.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ssym.model.acl.AdminRole;
import org.example.ssym.mapper.AdminRoleMapper;
import org.example.ssym.service.AdminRoleService;
import org.springframework.stereotype.Service;

@Service
public class AdminRoleServiceImp extends ServiceImpl<AdminRoleMapper, AdminRole> implements AdminRoleService {
}
