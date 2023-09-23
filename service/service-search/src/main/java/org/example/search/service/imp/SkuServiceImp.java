package org.example.search.service.imp;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.example.client.ProductFeignClient;
import org.example.enums.SkuType;
import org.example.model.product.Category;
import org.example.model.product.SkuInfo;
import org.example.model.search.SkuEs;
import org.example.search.repository.SkuRepository;
import org.example.search.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;


@Service
@Slf4j
public class SkuServiceImp implements SkuService {


    @Autowired
    private ProductFeignClient productFeignClient;

    @Autowired
    private SkuRepository skuEsRepository;
    @Override
    public void upperSku(Long skuId) {
        log.info("upperSku", skuId);
        SkuEs skuEs = new SkuEs();
        /*
        查询sku信息
         */
        SkuInfo skuInfo = productFeignClient.getSkuInfo(skuId);
        if (skuInfo == null) return;
        Long categoryId = skuInfo.getCategoryId();
        /*
        查询分类
         */

        Category category = productFeignClient.getCategory(categoryId);
        if (category != null) {
            String categoryName = category.getName();

            skuEs.setCategoryId(categoryId);
            skuEs.setCategoryName(categoryName);

        }


        skuEs.setId(skuInfo.getId());
        skuEs.setKeyword(skuInfo.getSkuName() + "," + skuEs.getCategoryName());
        skuEs.setWareId(skuInfo.getWareId());
        skuEs.setIsNewPerson(skuInfo.getIsNewPerson());
        skuEs.setImgUrl(skuInfo.getImgUrl());
        skuEs.setTitle(skuInfo.getSkuName());
        if (Objects.equals(skuInfo.getSkuType(), SkuType.COMMON.getCode())) {
            skuEs.setSkuType(0);
            skuEs.setPrice(skuInfo.getPrice().doubleValue());
            skuEs.setStock(skuInfo.getStock());
            skuEs.setSale(skuInfo.getSale());
            skuEs.setPerLimit(skuInfo.getPerLimit());

        } else {
            //TODO
        }
        skuEsRepository.save(skuEs);
        log.info("upperSku" + JSON.toJSONString(skuEs));
    }

    @Override
    public void lowerSku(Long skuId) {
        this.skuEsRepository.deleteById(skuId);
    }
}
