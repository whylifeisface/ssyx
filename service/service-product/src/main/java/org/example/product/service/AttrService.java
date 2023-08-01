package org.example.product.service;

import org.example.product.entity.Attr;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品属性 服务类
 * </p>
 *
 * @author ${author}
 * @since 2023-07-31
 */
public interface AttrService extends IService<Attr> {

    List<Attr> getAttrListById(Long groupId);
}
