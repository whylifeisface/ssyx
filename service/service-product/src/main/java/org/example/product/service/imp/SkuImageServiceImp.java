package org.example.product.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.model.product.SkuImage;
import org.example.product.mapper.SkuImageMapper;
import org.example.product.service.SkuImageService;
import org.springframework.stereotype.Service;

import java.util.List;



public class SkuImageServiceImp extends ServiceImpl<SkuImageMapper, SkuImage> implements SkuImageService {
    @Override
    public List<SkuImage> findBySkuId(Long skuId) {
  /*
        TODO  好像错了
         */
        QueryWrapper<SkuImage> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", skuId);
        return baseMapper.selectList(queryWrapper);
    }
}
