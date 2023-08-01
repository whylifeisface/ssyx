package org.example.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mysql.cj.util.StringUtils;
import com.ssym.vo.product.AttrGroupQueryVo;
import org.example.product.entity.AttrGroup;
import org.example.product.mapper.AttrGroupMapper;
import org.example.product.service.AttrGroupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 属性分组 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2023-07-31
 */
@Service
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupMapper, AttrGroup> implements AttrGroupService {

    @Override
    public IPage<AttrGroup> selectPageAttrGroup(Page<AttrGroup> pageParam, AttrGroupQueryVo attrGroupQueryVo) {
        String name = attrGroupQueryVo.getName();
        LambdaQueryWrapper<AttrGroup> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNullOrEmpty(name)) {
            lambdaQueryWrapper.like(AttrGroup::getName, name);
        }
        return baseMapper.selectPage(pageParam, lambdaQueryWrapper);
    }

    @Override
    public List<AttrGroup> findAllAttrGroup() {

//        LambdaQueryWrapper<AttrGroup> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        QueryWrapper<AttrGroup> queryWrapper = new QueryWrapper<>();
//        lambdaQueryWrapper.orderByDesc(AttrGroup)
        queryWrapper.orderByDesc("id");
        return baseMapper.selectList(queryWrapper);
    }
}
