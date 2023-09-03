package org.example.service.imp;

import org.example.repository1.SkuRepository;
import org.example.service.ProductFeignClient;
import org.example.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;

public class SkuServiceImpl implements SkuService {
    @Autowired
    private ProductFeignClient productFeignClient;

    @Autowired
    private SkuRepository skuEsRepository;

    @Autowired
    private RestHighLevelClient restHighLevelClient;
    @Override
    public void upperSku(Long skuId) {

    }

    @Override
    public void lowerSku(Long skuId) {

    }
}
