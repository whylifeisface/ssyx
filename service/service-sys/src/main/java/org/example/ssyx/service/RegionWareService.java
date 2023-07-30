package org.example.ssyx.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssym.vo.sys.RegionWareQueryVo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.ssyx.entity.RegionWare;

/**
 * <p>
 * 城市仓库关联表 服务类
 * </p>
 *
 * @author ${author}
 * @since 2023-07-30
 */
public interface RegionWareService extends IService<RegionWare> {

    IPage<RegionWare> selectPageRegionWare(Page<RegionWare> pageParam, RegionWareQueryVo regionWareQueryVo);

    void saveRegionWare(RegionWare regionWare);
}
