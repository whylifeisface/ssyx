package org.example.product.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.model.product.AttrGroup;
import org.example.product.mapper.AttrGroupMapper;
import org.example.product.service.AttrGroupService;
import org.example.vo.product.AttrGroupQueryVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;


@Service
public class AttrGroupServiceImp extends ServiceImpl<AttrGroupMapper, AttrGroup> implements AttrGroupService {
    @Override
    public IPage<AttrGroup> selectPage(Page<AttrGroup> pageParam, AttrGroupQueryVo attrGroupQueryVo) {
        String name = attrGroupQueryVo.getName();
        LambdaQueryWrapper<AttrGroup> wrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isEmpty(name)) {
            wrapper.like(AttrGroup::getName,name);
        }
        IPage<AttrGroup> attrGroupPage = baseMapper.selectPage(pageParam, wrapper);
        return attrGroupPage;
    }

    //查询所有属性分组
    @Override
    public List<AttrGroup> findAllList() {
        return this.list();
    }
}
