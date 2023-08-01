package org.example.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssym.vo.product.AttrGroupQueryVo;
import org.example.product.entity.AttrGroup;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 属性分组 服务类
 * </p>
 *
 * @author ${author}
 * @since 2023-07-31
 */
public interface AttrGroupService extends IService<AttrGroup> {

    IPage<AttrGroup> selectPageAttrGroup(Page<AttrGroup> pageParam, AttrGroupQueryVo attrGroupQueryVo);

    List<AttrGroup> findAllAttrGroup();

}
