package org.example.product.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.model.product.Attr;
import org.example.product.mapper.AttrMapper;
import org.example.product.service.AttrService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AttrServiceImp extends ServiceImpl<AttrMapper, Attr> implements AttrService {




    //根据属性分组id 获取属性列表
    @Override
    public List<Attr> findByAttrGroupId(Long attrGroupId) {
        LambdaQueryWrapper<Attr> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Attr::getAttrGroupId,attrGroupId);
        List<Attr> attrList = baseMapper.selectList(wrapper);
        return attrList;
    }
}
