package org.example.product.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssym.vo.product.SkuInfoQueryVo;
import com.ssym.vo.product.SkuInfoVo;
import io.swagger.annotations.ApiOperation;
import org.example.product.entity.SkuInfo;
import org.example.product.service.SkuInfoService;
import org.example.ssyx.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * sku信息 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2023-07-31
 */
@RestController
@RequestMapping("/admin/sku-info")
public class SkuInfoController {
    @Autowired
    private SkuInfoService skuInfoService;

    @ApiOperation("sku列表")
    @GetMapping("{page}/{limit}")
    public Result list(@PathVariable Long page, @PathVariable Long limit, SkuInfoQueryVo skuInfoQueryVo) {
        Page<SkuInfo> pageParam = new Page<>(page, limit);
        IPage<SkuInfo> skuInfoIPage = skuInfoService.selectPageSkuInfo(pageParam, skuInfoQueryVo);
        return Result.ok(skuInfoIPage);
    }

    @ApiOperation("添加商品sku信息")
    @PostMapping("save")
    public Result save(@RequestBody SkuInfoVo skuInfoVo){
        skuInfoService.saveSkuInfo(skuInfoVo);
        return Result.ok(null);
    }
}

