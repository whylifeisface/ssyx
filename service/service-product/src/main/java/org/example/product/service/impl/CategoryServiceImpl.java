package org.example.product.service.impl;

import org.example.product.entity.Category;
import org.example.product.mapper.CategoryMapper;
import org.example.product.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 商品三级分类 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2023-07-31
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
