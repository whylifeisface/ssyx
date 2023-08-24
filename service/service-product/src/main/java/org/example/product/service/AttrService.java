package org.example.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.model.product.Attr;

import java.util.List;

public interface AttrService extends IService<Attr> {
    List<Attr> findByAttrGroupId(Long attrGroupId);
}
