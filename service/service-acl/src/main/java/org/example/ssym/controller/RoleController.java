package org.example.ssym.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssym.model.acl.Role;
import com.ssym.vo.acl.RoleQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.ssym.service.RoleService;
import org.example.ssyx.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "角色接口")
@RestController
@RequestMapping("/admin/acl/role")
@CrossOrigin //跨域
public class RoleController {

    //注入service
    @Autowired
    private RoleService roleService;

    //查询角色列表
    @ApiOperation("查询角色列表")
    @GetMapping("{current}/{limit}")
    public Result pageList(
            @PathVariable Long current,
            @PathVariable Long limit,
            RoleQueryVo roleVo
    ){
        //创建page对象, 传递page 和 limit
        Page<Role> rolePage = new Page<>(current, limit);
        //
        IPage<Role> pageModel = roleService.selectRolePage(rolePage, roleVo);
        return Result.ok(pageModel);
    }
    //根据id获取角色
    @ApiOperation("根据id获取角色")
    @GetMapping("get/{Id}")
    public Result getById(@PathVariable Long id) {
        Role role = roleService.getById(id);
        return Result.ok(role);
    }
    //添加角色
    @PostMapping("save")
    public Result save(@RequestBody Role role) {
        boolean save = roleService.save(role);
        if (!save) {
            return Result.fail(null);
        }
        return Result.ok(null);
    }


//    修改角色

//    根据id删除角色

//            批量删除角色
}
