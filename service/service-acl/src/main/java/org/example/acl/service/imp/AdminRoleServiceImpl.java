package org.example.acl.service.imp;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.acl.mapper.AdminRoleMapper;
import org.example.acl.service.AdminRoleService;
import org.example.model.acl.AdminRole;
import org.springframework.stereotype.Service;

@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole>
        implements AdminRoleService {

}