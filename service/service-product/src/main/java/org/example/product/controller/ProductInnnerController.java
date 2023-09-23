package org.example.product.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.model.product.Category;
import org.example.model.product.SkuInfo;
import org.example.product.service.CategoryService;
import org.example.product.service.SkuInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@Api("xxx/todo")
//TODO api
public class ProductInnnerController {
//    @Autowired
//    private CategoryService categoryService;
//    @Autowired
//    private SkuInfoService skuInfoService;
//
//    @ApiOperation("根据分类id获取分类信息")
//    @GetMapping("inner/getCategory/{categoryId}")
//    public Category getCategory(@PathVariable Long categoryId) {
//        return categoryService.getById(categoryId);
//    }
//
//    @ApiOperation("根据skuId获取sku信息")
//    @GetMapping("inner/getSkuInfo/{skuId}")
//    public SkuInfo getSkuInfo(@PathVariable("skuId") Long skuId) {
//        return skuInfoService.getById(skuId);
//    }
}
