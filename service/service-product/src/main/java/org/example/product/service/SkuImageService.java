package org.example.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.model.product.SkuImage;
import org.springframework.stereotype.Service;

import java.util.List;

public interface SkuImageService extends IService<SkuImage> {
    List<SkuImage> findBySkuId(Long skuId);
}
