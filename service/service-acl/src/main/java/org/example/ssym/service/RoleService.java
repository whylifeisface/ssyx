package org.example.ssym.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ssym.model.acl.Role;
import com.ssym.vo.acl.RoleQueryVo;
import org.springframework.stereotype.Service;

import java.util.Map;

//import javax.management.relation.Role;

public interface RoleService extends IService<Role> {
    IPage<Role> selectRolePage(Page<Role> rolePage, RoleQueryVo roleVo);

    Map<String, Object> getRoleByAdminId(Long adminId);
}
