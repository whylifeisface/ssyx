package org.example.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mysql.cj.util.StringUtils;
import com.ssym.model.product.SkuAttrValue;
import com.ssym.model.product.SkuImage;
import com.ssym.model.product.SkuPoster;
import com.ssym.vo.product.SkuInfoQueryVo;
import com.ssym.vo.product.SkuInfoVo;
import org.example.product.entity.SkuInfo;
import org.example.product.mapper.SkuInfoMapper;
import org.example.product.service.SkuAttrValueService;
import org.example.product.service.SkuImageService;
import org.example.product.service.SkuInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.product.service.SkuPosterService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.security.Key;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * sku信息 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2023-07-31
 */
@Service
public class SkuInfoServiceImpl extends ServiceImpl<SkuInfoMapper, SkuInfo> implements SkuInfoService {

    @Autowired
    private SkuImageService skuImageService;
    @Autowired
    private SkuAttrValueService skuAttrValueService;
    @Autowired
    private SkuPosterService skuPosterService;
    @Override
    public IPage<SkuInfo> selectPageSkuInfo(Page<SkuInfo> pageParam, SkuInfoQueryVo skuInfoQueryVo) {
        String keyword = skuInfoQueryVo.getKeyword();
        Long categoryId = skuInfoQueryVo.getCategoryId();
        String skuType = skuInfoQueryVo.getSkuType();
        LambdaQueryWrapper<SkuInfo> skuInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isNullOrEmpty(keyword)) {
            skuInfoLambdaQueryWrapper.like(SkuInfo::getSkuName, keyword);
        }
        if (categoryId != null) {
            skuInfoLambdaQueryWrapper.eq(SkuInfo::getCategoryId, categoryId);
        }
        if (!StringUtils.isNullOrEmpty(skuType)) {
            skuInfoLambdaQueryWrapper.like(SkuInfo::getSkuType, skuType);
        }
        return baseMapper.selectPage(pageParam, skuInfoLambdaQueryWrapper);
    }

    @Override
    public void saveSkuInfo(SkuInfoVo skuInfoVo) {
//        添加sku基本信息
//        skuinfovo -> skuinfo
        SkuInfo skuInfo = new SkuInfo();
        BeanUtils.copyProperties(skuInfoVo, skuInfo);
        baseMapper.insert(skuInfo);

        //SKU海报
        List<SkuPoster> skuPosterList = skuInfoVo.getSkuPosterList();
        if (!CollectionUtils.isEmpty(skuPosterList)) {
            for (SkuPoster skuPoster : skuPosterList) {
                skuPoster.setSkuId(skuInfo.getId());
            }
            skuPosterService.saveBatch(skuPosterList);

        }
        //sku图片
        List<SkuImage> skuImagesList = skuInfoVo.getSkuImagesList();
        if (!CollectionUtils.isEmpty(skuImagesList)) {
            for (SkuImage skuImage : skuImagesList) {
                skuImage.setSkuId(skuInfo.getId());
            }
            skuImageService.saveBatch(skuImagesList);
        }
        //平台属性
        List<SkuAttrValue> skuAttrValueList = skuInfoVo.getSkuAttrValueList();
        if (!CollectionUtils.isEmpty(skuAttrValueList)) {
            for (SkuAttrValue skuAttrValue : skuAttrValueList) {
                skuAttrValue.setSkuId(skuInfo.getId());
            }
            skuAttrValueService.saveBatch(skuAttrValueList);
        }
    }

}
