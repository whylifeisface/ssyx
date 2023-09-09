package org.example.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.model.product.SkuImage;
import org.springframework.stereotype.Repository;

@Repository@Mapper

public interface SkuImageMapper extends BaseMapper<SkuImage> {
}
