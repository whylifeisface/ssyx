package org.example.service.imp;

import com.alibaba.fastjson.JSON;
import org.elasticsearch.client.RestHighLevelClient;
import org.example.enums.SkuType;
import org.example.model.product.Category;
import org.example.model.product.SkuInfo;
import org.example.model.search.SkuEs;
import org.example.repository1.SkuRepository;
import org.example.service.ProductFeignClient;
import org.example.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.Objects;

@Slf4j
@Service
public class SkuServiceImpl implements SkuService {
    @Autowired
    private ProductFeignClient productFeignClient;

    @Autowired
    private SkuRepository skuEsRepository;

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    /**
     * 上架商品列表
     * @param skuId
     */
    @Override
    public void upperSku(Long skuId) {
        log.info("upperSku",skuId);
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

        }else {
            //TODO
        }
        skuEsRepository.save(skuEs);
        log.info("upperSku" + JSON.toJSONString(skuEs));
    }
    /**
     * 下架商品列表
     * @param skuId
     */
    @Override
    public void lowerSku(Long skuId) {
        this.skuEsRepository.deleteById(skuId);
    }
}
