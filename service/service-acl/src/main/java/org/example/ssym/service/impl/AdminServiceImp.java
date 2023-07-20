package org.example.ssym.service.impl;


public class AdminServiceImp extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    @Autowired
    private RoleMapper mapper;
    @Override
    public IPage<Role> selectRolePage(Page<Admin> adminPage, AdminQueryVo adminQueryVo) {
        //获取条件
        String username = adminQueryVo.getRoleName();
        String name = adminQueryVo.getName();
        //创建map条件对象
        LambdaQueryWrapper<Admin> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        //判断是否是空
        if (!StringUtils.isNullOrEmpty(username)) {
            lambdaQueryWrapper.eq(adminPage::getUserame, username);
        }
        if (!StringUtils.isNullOrEmpty(name)){
            lambdaQueryWrapper.like(adminPage::getUserame, name);
        }
        return mapper.selectPage(adminPage, lambdaQueryWrapper);
    }
}
