package org.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.client.product.ProductFeignClient;
import org.example.mapper.ActivityInfoMapper;
import org.example.mapper.ActivityRuleMapper;
import org.example.mapper.ActivitySkuMapper;
import org.example.model.activity.ActivityInfo;
import org.example.model.activity.ActivityRule;
import org.example.model.activity.ActivitySku;
import org.example.model.product.SkuInfo;
import org.example.service.ActivityInfoService;
import org.example.vo.activity.ActivityRuleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ActivityInfoServiceImp extends ServiceImpl<ActivityInfoMapper, ActivityInfo> implements ActivityInfoService {

    @Autowired
    private ActivityInfoMapper activityInfoMapper;

    @Autowired
    private ActivityRuleMapper activityRuleMapper;

    @Autowired
    private ActivitySkuMapper activitySkuMapper;

    @Autowired
    private ProductFeignClient productFeignClient;

    @Override
    public Map<String, Object> findActivityRuleList(Long id) {
        HashMap<String, Object> stringObjectHashMap = new HashMap<>();
        QueryWrapper<ActivityRule> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("activity_id", id);
        List<ActivityRule> activityRules = activityRuleMapper.selectList(queryWrapper);
        stringObjectHashMap.put("activityRuleList", activityRules);

        QueryWrapper<ActivitySku> activitySkuQueryWrapper = new QueryWrapper<>();
        activitySkuQueryWrapper.eq("activity_id", id);
        List<ActivitySku> activitySkuList = activitySkuMapper.selectList(activitySkuQueryWrapper);
        List<Long> skuIdList = activitySkuList.stream().map(ActivitySku::getSkuId).collect(Collectors.toList());
        List<SkuInfo> skuInfos = productFeignClient.findSkuInfoList(skuIdList);
        stringObjectHashMap.put("skuInfoList", skuInfos);

        return stringObjectHashMap;
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveActivityRule(ActivityRuleVo activityRuleVo) {
        activityRuleMapper.delete(new
                QueryWrapper<ActivityRule>().eq("activity_id", activityRuleVo.getActivityId()));
        activitySkuMapper.delete(new QueryWrapper<ActivitySku>().eq("activity_id", activityRuleVo.getActivityId()));
        List<ActivityRule> activityRuleList = activityRuleVo.getActivityRuleList();
        List<ActivitySku> activitySkuList = activityRuleVo.getActivitySkuList();
        List<Long> couponIdList = activityRuleVo.getCouponIdList();

        ActivityInfo activityInfo = activityInfoMapper.selectById(activityRuleVo.getActivityId());
        for (ActivityRule activityRule : activityRuleList) {
            activityRule.setActivityId(activityRuleVo.getActivityId());
            activityRule.setActivityType(activityInfo.getActivityType());
            activityRuleMapper.insert(activityRule);
        }
        for (ActivitySku activitySku : activitySkuList) {
            activitySku.setActivityId(activityRuleVo.getActivityId());
            activitySkuMapper.insert(activitySku);
        }

    }

    @Override
    public IPage<ActivityInfo> selectPage(Page<ActivityInfo> activityInfoPage) {
        QueryWrapper<ActivityInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("id");

        Page<ActivityInfo> selectPage = activityInfoMapper.selectPage(activityInfoPage, queryWrapper);
        selectPage.getRecords().stream().forEach(item -> {
            item.setActivityTypeString(item.getActivityType().getComment());
        });

        return selectPage;
    }

    @Override
    public List<SkuInfo> finSkuInfoByKeyword(String keyword) {

        List<SkuInfo> skuInfos = productFeignClient.finSkuInfoByKeyword(keyword);
        List<Long> skuList
                = skuInfos.stream().map(SkuInfo::getId).collect(Collectors.toList());
        ArrayList<SkuInfo> notExistSkuInfoList = new ArrayList<>();
        List<Long> existSkuList = activityInfoMapper.selectExistSkuIdList(skuList);
        String existSkuIdString = "," + StringUtils.join(existSkuList.toArray(), ",") + ",";
        for (SkuInfo skuInfo : skuInfos) {
            if (!existSkuIdString.contains("," + skuInfo.getId() + ",")) {
                notExistSkuInfoList.add(skuInfo);
            }
        }

        return notExistSkuInfoList;
    }
}
