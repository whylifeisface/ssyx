package org.example.ssym.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ssym.model.acl.Admin;
import com.ssym.vo.acl.AdminQueryVo;

public interface AdminService extends IService<Admin> {
    IPage<Admin> selectRolePage(Page<Admin> adminPage, AdminQueryVo adminQueryVo);
}