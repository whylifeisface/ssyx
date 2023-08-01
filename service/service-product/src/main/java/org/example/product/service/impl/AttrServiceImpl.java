package org.example.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.example.product.entity.Attr;
import org.example.product.mapper.AttrMapper;
import org.example.product.service.AttrService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品属性 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2023-07-31
 */
@Service
public class AttrServiceImpl extends ServiceImpl<AttrMapper, Attr> implements AttrService {

    @Override
    public List<Attr> getAttrListById(Long groupId) {
        LambdaQueryWrapper<Attr> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (groupId != null) {
            lambdaQueryWrapper.eq(Attr::getId, groupId);
        }
        return baseMapper.selectList(lambdaQueryWrapper);
    }
}
