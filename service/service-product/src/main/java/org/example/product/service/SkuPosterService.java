package org.example.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.model.product.SkuPoster;

import java.util.List;

public interface SkuPosterService extends IService<SkuPoster> {
    List<SkuPoster> findBySkuId(Long skuId);
}
