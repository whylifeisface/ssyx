package org.example.search.api;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.common.result.Result;
import org.example.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api("api/search/sku")
public class SkuApiController {

    @Autowired
    private SkuService skuService;
    @ApiOperation("上架商品")
    @GetMapping("inner/upperSku/{skuId}")
    public Result upperGoods(@PathVariable("skuId") Long skuId){
        skuService.upperSku(skuId);
        return Result.ok();
    }
    @ApiOperation("下架商品")
    @GetMapping("inner/lowerSku/{skuId}")
    public Result lowerGoods(@PathVariable("skuId") Long skuId){
        skuService.lowerSku(skuId);
        return Result.ok();
    }
}
