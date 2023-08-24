package org.example.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.model.product.SkuAttrValue;

import java.util.List;

public interface SkuAttrValueService extends IService<SkuAttrValue> {
    List<SkuAttrValue> findBySkuId(Long skuId);
}
