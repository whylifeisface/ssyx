package org.example.ssyx.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mysql.cj.util.StringUtils;
import com.ssym.vo.sys.RegionWareQueryVo;
import org.example.ssyx.common.exception.SsymException;
import org.example.ssyx.common.result.ResultCodeEnum;
import org.example.ssyx.entity.RegionWare;
import org.example.ssyx.mapper.RegionWareMapper;
import org.example.ssyx.service.RegionWareService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 城市仓库关联表 服务实现类
 * </p>
 *
 * @author ${author}
 * @since 2023-07-30
 */
@Service
public class RegionWareServiceImpl extends ServiceImpl<RegionWareMapper, RegionWare> implements RegionWareService {


    @Override
    public IPage<RegionWare> selectPageRegionWare(Page<RegionWare> pageParam, RegionWareQueryVo regionWareQueryVo) {
        String keyword = regionWareQueryVo.getKeyword();
        LambdaQueryWrapper<RegionWare> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (!StringUtils.isNullOrEmpty(keyword)) {
            lambdaQueryWrapper.like(RegionWare::getRegionName, keyword)
                    .or().like(RegionWare::getWareName, keyword);
        }
        return baseMapper.selectPage(pageParam, lambdaQueryWrapper);
    }

    @Override
    public void saveRegionWare(RegionWare regionWare) {
        //是否已经
        LambdaQueryWrapper<RegionWare> regionWareLambdaQueryWrapper = new LambdaQueryWrapper<>();
        regionWareLambdaQueryWrapper.eq(RegionWare::getRegionId, regionWare.getRegionId());
        Integer count = baseMapper.selectCount(regionWareLambdaQueryWrapper);
        if (count > 0) {
            //已经存在
            throw new SsymException(ResultCodeEnum.FAIL);
        }
        baseMapper.insert(regionWare);
    }
}
