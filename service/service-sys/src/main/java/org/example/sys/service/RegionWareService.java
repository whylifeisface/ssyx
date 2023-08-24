package org.example.sys.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.model.sys.RegionWare;
import org.example.vo.sys.RegionWareQueryVo;

public interface RegionWareService extends IService<RegionWare> {

    //开通区域列表
    IPage<RegionWare> selectPage(Page<RegionWare> pageParam,
                                 RegionWareQueryVo regionWareQueryVo);
    void saveRegionWare(RegionWare regionWare);

    void updateStatus(Long id, Integer status);
}
