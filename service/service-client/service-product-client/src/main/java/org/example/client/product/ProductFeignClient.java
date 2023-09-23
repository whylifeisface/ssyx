package org.example.client.product;

import org.example.model.product.Category;
import org.example.model.product.SkuInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProductFeignClient {
    @GetMapping("api/product/inner/getCategory/{categoryId}")
    public Category getCategory(@PathVariable("categoryId") Long categoryId);
    @GetMapping("api/product/inner/getSkuInfo/{skuId}")
    public SkuInfo getSkuInfo(@PathVariable("skuId") Long skuId);
    //TODO
    @GetMapping("api/product/inner/findSkuInfoList/{skuId}")
    List<SkuInfo> findSkuInfoList(List<Long> skuIdList);


    @GetMapping("api/product/inner/finSkuInfoByKeyword/")

    List<SkuInfo> finSkuInfoByKeyword(@RequestBody String keyword);
}
