package org.example.ssym.controller;


import java.util.List;

@Api("角色接口")
@RestController
@ResquestMapping("/admin/acl/user")
@CrossOrigin //跨域

public class AdminController {
    @Autowired
    private AdminService adminService;

    //获取列表
    @ApiOperation("获取列表")
    @GetMapping("{current}/{limit}")
    public Result list(
            @PathVariable Long current,
            @PathVariable Long limit,
            AdminQueryVo adminQueryVo
    ) {
        Page<Admin> page = new Page<Admin>(current, limit);
        IPage<Admin> adminIPage = roleService.selectRolePage(rolePage, adminQueryVo);
        return Result.ok(adminIPage);

    }
    //通过id获取用户
    @ApiOperation("获取列表")
    @GetMapping("get/{id}")
    public Result  getById(
            @PathVariable Long id
    ){
        Role role = adminService.getById(id);
        return Result.ok(role);
    }

    //添加用户
    @ApiOperation("添加用户")
    @PostMapping("save")
    public Result save(@RequestBody Admin admin) {
        boolean save = adminService.save(admin);
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
    @PostMapping("/remove/{id}")
    public Result remove(
            @PathVariable Long id
    ) {
        adminService.removeById(id);
        return Result.ok(null);
    }
    // 批量删除
    @ApiOperation("批量删除")
    public Result batchRemove(@RequestBody List<Long> idList) {
        adminService.removeByIds(idList);
        return Result.ok(null);
    }



}