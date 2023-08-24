package org.example.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.model.sys.Region;

import java.util.List;

public interface RegionService extends IService<Region> {
    /*
    根据关键字获取地区列表
     */
    List<Region> findRegionByKeyword(String keyword);
}
