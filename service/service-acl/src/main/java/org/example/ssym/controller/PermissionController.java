package org.example.ssym.controller;

import com.ssym.model.acl.Permission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.ssym.service.PermissionService;
import org.example.ssyx.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/acl/permission")
@Api("菜单管理")
@CrossOrigin /* 跨域*/
public class PermissionController {
    @Autowired
    private PermissionService permissionService;

    /*
    查询所有
     */
    @GetMapping("")
    public Result list() {
        List<Permission> list = permissionService.queryAllPermission();
        return Result.ok(list);
    }

    /*
    添加菜单
     */
    @ApiOperation("")
    @PostMapping("save")
    public Result save(@RequestBody Permission permission) {
        boolean save = permissionService.save(permission);
        return Result.ok(null);
    }

    /*
修改菜单
     */
    @ApiOperation("修改菜单")
    @PutMapping("update")
    public Result update(@RequestBody Permission permission) {
        permissionService.updateById(permission);
        return Result.ok(null);
    }


    /*
        递归删除菜单
     */
    @ApiOperation("删除菜单")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        boolean removeById = permissionService.removeChildById(id);
        return Result.ok(null);
    }
}
