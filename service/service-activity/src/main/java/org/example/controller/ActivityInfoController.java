package org.example.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.example.common.result.Result;
import org.example.model.activity.ActivityInfo;
import org.example.service.ActivityInfoService;
import org.example.service.impl.ActivityInfoServiceImp;
import org.example.vo.activity.ActivityRuleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@ApiOperation("ActivityInfoController")
@RestController
@RequestMapping("/admin/activity/activityinfo")
public class ActivityInfoController {
    @Autowired
    private ActivityInfoService activityInfoServiceImp;

    @ApiOperation(value = "获取分页列表")
    @GetMapping("{page}/{limit}")
    public Result index(
            @ApiParam(name = "page", value = "当前页面", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit
    ) {
        Page<ActivityInfo> activityInfoPage = new Page<ActivityInfo>(page, limit);
        IPage<ActivityInfo> activityInfoIPage = activityInfoServiceImp.selectPage(activityInfoPage);
        return Result.ok(activityInfoIPage);
    }

    @ApiOperation(value = "获取活动")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        ActivityInfo activityInfo = activityInfoServiceImp.getById(id);
        activityInfo.setActivityTypeString(activityInfo.getActivityType().getComment());
        return Result.ok(activityInfo);
    }
    @ApiOperation(value = "新增活动")
    @GetMapping("save")
    public Result get(@RequestBody ActivityInfo activityInfo) {
        activityInfo.setCreateTime(new Date());
        activityInfoServiceImp.save(activityInfo);
        return Result.ok();
    }
    @ApiOperation(value = "修改活动")
    @GetMapping("update")
    public Result updateById(@RequestBody ActivityInfo activityInfo) {
        activityInfoServiceImp.updateById(activityInfo);
        return Result.ok();
    }
    @ApiOperation(value = "删除活动")
    @GetMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        activityInfoServiceImp.removeById(id);
        return Result.ok();
    }

    @ApiOperation(value = "批量删除活动")
    @GetMapping("batchRemove/")
    public Result batchRemove(@RequestBody List<String> idList) {
        activityInfoServiceImp.removeByIds(idList);
        return Result.ok();
    }


    @ApiOperation(value = "获取活动规则")
    @GetMapping("findActivityRuleList/{id}")
    public Result findActivityRuleList(@PathVariable Long id) {
        ;
        return Result.ok(activityInfoServiceImp.findActivityRuleList(id));
    }


    @ApiOperation(value = "新增活动规则")
    @GetMapping("saveActivityRule/")
    public Result saveActivityRule(@RequestBody ActivityRuleVo activityRuleVo) {
        activityInfoServiceImp.saveActivityRule(activityRuleVo);
        return Result.ok();
    }
    @ApiOperation(value = "根据关键词获取sku列表")
    @GetMapping("finSkuInfoByKeyWord/{keyword}")
    public Result finSkuInfoByKeyword(@PathVariable String keyword) {
        return Result.ok(activityInfoServiceImp.finSkuInfoByKeyword(keyword));
    }

    ///TODO findActivityRule
}
