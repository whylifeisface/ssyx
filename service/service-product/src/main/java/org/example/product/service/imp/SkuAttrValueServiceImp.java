package org.example.product.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.model.product.SkuAttrValue;
import org.example.product.mapper.SkuAttrValueMapper;
import org.example.product.service.SkuAttrValueService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
// STOPSHIP: 2023/8/24
public class SkuAttrValueServiceImp extends ServiceImpl<SkuAttrValueMapper, SkuAttrValue> implements SkuAttrValueService {
    @Override
    public List<SkuAttrValue> findBySkuId(Long skuId) {
  /*
        TODO  好像错了
         */
        QueryWrapper<SkuAttrValue> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", skuId);
        return baseMapper.selectList(queryWrapper);
    }
}
