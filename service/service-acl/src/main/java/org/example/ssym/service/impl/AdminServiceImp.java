package org.example.ssym.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mysql.cj.util.StringUtils;
import com.ssym.model.acl.Admin;
import com.ssym.vo.acl.AdminQueryVo;
import org.example.ssym.mapper.AdminMapper;
import org.example.ssym.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImp extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    @Autowired
    private AdminMapper mapper;
    @Override
    public IPage<Admin> selectRolePage(Page<Admin> adminPage, AdminQueryVo adminQueryVo) {
        //获取条件
        String username = adminQueryVo.getUsername();
        String name = adminQueryVo.getName();
        //创建map条件对象
        LambdaQueryWrapper<Admin> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //判断是否是空
        if (!StringUtils.isNullOrEmpty(username)) {
            lambdaQueryWrapper.eq(Admin::getUsername, username);
        }
        if (!StringUtils.isNullOrEmpty(name)){
            lambdaQueryWrapper.like(Admin::getName, name);
        }
        return mapper.selectPage(adminPage, lambdaQueryWrapper);
    }
}
