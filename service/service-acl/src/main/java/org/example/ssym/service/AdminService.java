package org.example.ssym.service;


public interface AdminService extends IService<Admin> {
    IPage<Role> selectRolePage(Page<Admin> adminPage, AdminQueryVo adminQueryVo);
}