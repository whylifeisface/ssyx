package org.example.ssyx.controller;


import io.swagger.annotations.Api;
import org.example.ssyx.common.result.Result;
import org.example.ssyx.entity.Region;
import org.example.ssyx.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 地区表 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2023-07-30
 */
@Api("")
@CrossOrigin
@RestController
@RequestMapping("admin/sys/region")
public class RegionController {
    @Autowired
    private RegionService regionService;

    //根据区域关键词查询地区信息
    @GetMapping("findRegionByKeyWord/{keyword}")
    public Result findRegionByKeyWord(
            @PathVariable("keyword") String keyword
    ){
       List<Region> list = regionService.getRegionByKeyword(keyword);
       return Result.ok(list);
    }
}

