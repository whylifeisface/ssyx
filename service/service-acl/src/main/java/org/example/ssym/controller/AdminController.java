package org.example.ssym.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssym.model.acl.Admin;
import com.ssym.vo.acl.AdminQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.ssym.service.AdminService;
import org.example.ssym.service.RoleService;
import org.example.ssyx.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Api("角色接口")
@RestController
@RequestMapping("/admin/acl/user/")
@CrossOrigin //跨域

public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private RoleService roleService;

    ///获取用户角色
    @ApiOperation("获取用户角色")
    @GetMapping("toAssign/{adminId}")
    public Result toAssign(
            @PathVariable Long adminId
    ){
        Map<String, Object> map = roleService.getRoleByAdminId(adminId);
        return Result.ok(map);
    }

    //获取列表
    @ApiOperation("获取列表")
    @GetMapping("{current}/{limit}")
    public Result list(
            @PathVariable Long current,
            @PathVariable Long limit,
            AdminQueryVo adminQueryVo
    ) {
        Page<Admin> adminPage = new Page<Admin>(current, limit);
        IPage<Admin> adminIPage = adminService.selectRolePage(adminPage, adminQueryVo);
        return Result.ok(adminIPage);

    }
    //通过id获取用户
    @ApiOperation("获取列表")
    @GetMapping("get/{id}")
    public Result  getById(
            @PathVariable Long id
    ){
        Admin admin = adminService.getById(id);
        return Result.ok(admin);
    }

    //添加用户
    @ApiOperation("添加用户")
    @PostMapping("save")
    public Result save(@RequestBody Admin admin) {
        boolean save = adminService.save(admin);


        //获取用户密码
        String password = admin.getPassword();

        //进行md5加密
        String md5DigestAsHex = DigestUtils.md5DigestAsHex(password.getBytes());
        /*
        重新设置到Admin对象
         */
        admin.setPassword(md5DigestAsHex);
        /* 添加 */
        if (!save) {
            return Result.fail(null);
        }
        return Result.ok(null);
    }

    //修改删除
    @ApiOperation("修改删除")
    @PostMapping("update")
    public Result update(@RequestBody Admin admin){
        adminService.updateById(admin);
        return Result.ok(null);
    }

    //通过id 删除
    @ApiOperation("通过id 删除")
    @DeleteMapping("/remove/{id}")
    public Result remove(
            @PathVariable Long id
    ) {
        adminService.removeById(id);
        return Result.ok(null);
    }
    // 批量删除
    @ApiOperation("批量删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        adminService.removeByIds(idList);
        return Result.ok(null);
    }



}