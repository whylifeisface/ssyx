package org.example.sys.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.example.common.result.Result;
import org.example.model.sys.RegionWare;
import org.example.sys.service.RegionService;
import org.example.sys.service.RegionWareService;
import org.example.vo.sys.RegionWareQueryVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Api(value = "RegionWare管理", tags = "RegionWare管理")
@RestController
@RequestMapping(value="/admin/sys/regionWare")
//@SuppressWarnings({"unchecked", "rawtypes"})
public class RegionWareController {

    @Resource
    private RegionWareService regionWareService;

    /*
    添加开通区域
     */
    @ApiOperation(value = "新增")
    @PostMapping("save")
    public Result save(@RequestBody RegionWare regionWare) {
        regionWareService.saveRegionWare(regionWare);
        return Result.ok();
    }
    /*
    开通区域列表
     */
    @ApiOperation(value = "获取开通区域列表")
    @GetMapping("{page}/{limit}")
    public Result index(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            @ApiParam(name = "regionWareVo", value = "查询对象", required = false)
            RegionWareQueryVo regionWareQueryVo) {

        Page<RegionWare> pageParam = new Page<>(page, limit);

        IPage<RegionWare> pageModel = regionWareService.selectPage(pageParam, regionWareQueryVo);

        return Result.ok(pageModel);
    }

    /*
    删除开通区域
     */
    @ApiOperation(value = "删除")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        regionWareService.removeById(id);
        return Result.ok();
    }

    @ApiOperation(value = "取消开通区域")
    @PostMapping("updateStatus/{id}/{status}")
    public Result updateStatus(@PathVariable Long id,@PathVariable Integer status) {
        regionWareService.updateStatus(id, status);
        return Result.ok();
    }
}