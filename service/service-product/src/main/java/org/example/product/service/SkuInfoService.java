package org.example.product.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssym.vo.product.SkuInfoQueryVo;
import com.ssym.vo.product.SkuInfoVo;
import org.example.product.entity.SkuInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * sku信息 服务类
 * </p>
 *
 * @author ${author}
 * @since 2023-07-31
 */
public interface SkuInfoService extends IService<SkuInfo> {

    IPage<SkuInfo> selectPageSkuInfo(Page<SkuInfo> pageParam, SkuInfoQueryVo skuInfoQueryVo);

    void saveSkuInfo(SkuInfoVo skuInfoVo);
}
