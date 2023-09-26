package org.example.client;

import org.example.model.product.Category;
import org.example.model.product.SkuInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "service-product")
public interface ProductFeignClient {

    @GetMapping("/api/product/inner/getCategory/{categoryId}")
    public Category getCategory(@PathVariable("categoryId") Long categoryId);

    @GetMapping("/api/product/inner/getSkuInfo/{skuId}")
    public SkuInfo getSkuInfo(@PathVariable("skuId") Long skuId);

    @GetMapping("api/product/inner/findSkuInfoList/")
    List<SkuInfo> findSkuInfoList(@RequestBody List<Long> skuIdList);

    @GetMapping("api/product/inner/finSkuInfoByKeyword/")
    List<SkuInfo> finSkuInfoByKeyword(@PathVariable String keyword);

    @GetMapping("api/product/inner/finCategoryList/")
    List<Category> finCategoryList(@RequestBody List<Long> randList);
}
