package org.example.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.common.result.Result;
import org.example.model.activity.CouponInfo;
import org.example.service.CouponInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 优惠券信息 前端控制器
 * </p>
 *
 * @author ssyx
 * @since 2023-09-24
 */
@RestController
@RequestMapping("/service-activity/coupon-info")
public class CouponInfoController {


    @Autowired
    private CouponInfoService couponInfoService;


    //    优惠券分页查询
    public Result list(@PathVariable Long page,
                       @PathVariable Long limit) {
        IPage<CouponInfo> pageModel = couponInfoService.selectPageCouponInfo(page, limit);
        return Result.ok(pageModel);
    }

/*
    添加优惠券

 */

    @PostMapping("save")
    public Result save(@RequestBody CouponInfo couponInfo) {
        couponInfoService.save(couponInfo);
        return Result.ok();
    }

    /*
    根据id查询优惠券
     */
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        CouponInfo couponInfo = couponInfoService.getById(id);
        couponInfo.setCouponTypeString(couponInfo.getCouponType().getComment());
        if (couponInfo.getRangeType() != null) {
            couponInfo.setRangeTypeString(couponInfo.getRangeType().getComment());
        }
        return Result.ok(couponInfo);
    }

    //根据优惠券id查询规则数据
    @GetMapping("findCouponRuleList/{id}")
    public Result findCouponRuleList(@PathVariable Long id){
       Map<String,Object> map =
        couponInfoService.findCouponRuleList(id);
    return Result.ok(map);
    }


}

