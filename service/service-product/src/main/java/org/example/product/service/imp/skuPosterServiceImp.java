package org.example.product.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.model.product.SkuAttrValue;
import org.example.model.product.SkuPoster;
import org.example.product.mapper.SkuPosterMapper;
import org.example.product.service.SkuPosterService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class skuPosterServiceImp extends ServiceImpl<SkuPosterMapper, SkuPoster> implements SkuPosterService {
    @Override
    public List<SkuPoster> findBySkuId(Long skuId) {
  /*
        TODO  好像错了
         */
        QueryWrapper<SkuPoster> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", skuId);
        return baseMapper.selectList(queryWrapper);
    }
}
