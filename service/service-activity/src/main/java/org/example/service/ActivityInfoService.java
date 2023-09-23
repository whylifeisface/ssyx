package org.example.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.model.activity.ActivityInfo;
import org.example.model.product.SkuInfo;
import org.example.vo.activity.ActivityRuleVo;

import java.util.List;
import java.util.Map;

public interface ActivityInfoService extends IService<ActivityInfo> {
    Map<String,Object> findActivityRuleList(Long id);

    void saveActivityRule(ActivityRuleVo activityRuleVo);

    IPage<ActivityInfo> selectPage(Page<ActivityInfo> activityInfoPage);

    List<SkuInfo> finSkuInfoByKeyword(String keyword);
}
