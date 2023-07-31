package org.example.ssyx.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssym.vo.sys.RegionWareQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.ssyx.common.result.Result;
import org.example.ssyx.entity.RegionWare;
import org.example.ssyx.service.RegionWareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 城市仓库关联表 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2023-07-30
 */
@Api("开通区域接口")

@RestController
@RequestMapping("/admin/sys/regionWare")
public class RegionWareController {
    @Autowired
    private RegionWareService regionWareService;

    @ApiOperation("开通区域列表")
    @GetMapping("{page}/{limit}")
    public Result list(
            @PathVariable Long page,
            @PathVariable Long limit,
            RegionWareQueryVo regionWareQueryVo
    ) {
        Page<RegionWare> pageParam = new Page<>(page, limit);
        IPage<RegionWare> pageModel = regionWareService.selectPageRegionWare(pageParam, regionWareQueryVo);
        return Result.ok(pageModel);
    }
    /*
    添加开通区域
     */
    @ApiOperation(" 添加开通区域")
    @PostMapping("save")
    public Result addRegionWare(@RequestBody RegionWare regionWare) {
        regionWareService.saveRegionWare(regionWare);
        return Result.ok(null);
    }

    @ApiOperation("删除开通区域")
    @DeleteMapping("remove/{id}")
    public Result delete(@PathVariable Long id){
        regionWareService.removeById(id);
        return Result.ok(null);
    }

    @ApiOperation("取消开通区域")
    @PostMapping("update/{id}/{status}")
    public Result updateStatus(@PathVariable Long id,@PathVariable Integer status){
        regionWareService.updateStatus(id, status);
        return Result.ok(null);
    }

}

