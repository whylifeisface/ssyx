package org.example.ssyx.controller;


import io.swagger.annotations.ApiOperation;
import org.example.ssyx.common.result.Result;
import org.example.ssyx.entity.Ware;
import org.example.ssyx.service.WareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 仓库表 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2023-07-30
 */
@CrossOrigin
@RestController
@RequestMapping("/ssyx/ware")
public class WareController {
    @Autowired
    private WareService wareService;
    //查询所有仓库
    @ApiOperation("查询所有仓库")
    @GetMapping("findAllList")
    public Result findAllList(){
        List<Ware> list = wareService.list();
        return Result.ok(list);
    }
}

