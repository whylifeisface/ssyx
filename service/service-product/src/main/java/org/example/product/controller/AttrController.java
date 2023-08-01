package org.example.product.controller;


import io.swagger.annotations.ApiOperation;
import org.example.product.entity.Attr;
import org.example.product.entity.AttrGroup;
import org.example.product.service.AttrService;
import org.example.ssyx.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 商品属性 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2023-07-31
 */
@RestController
@RequestMapping("/admin/product/attr")
public class AttrController {
    @Autowired
    private AttrService attrService;

    @ApiOperation("根据平台熟悉分组id查询")
    @GetMapping("{groupId}")
    public Result list(@PathVariable Long groupId){
      List<Attr> list = attrService.getAttrListById(groupId);
      return Result.ok(list);
    }


    @ApiOperation("获取")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id){
        Attr attrGroupServiceById = attrService.getById(id);
        return Result.ok(attrGroupServiceById);
    }
    @PostMapping("save")
    @ApiOperation("新增")
    public Result save(@RequestBody Attr attr){
        boolean save = attrService.save(attr);
        return Result.ok(null);
    }
    @DeleteMapping("remove/{id}")
    @ApiOperation("删除")
    public Result remove(@PathVariable Long id){
        boolean remove = attrService.removeById(id);
        return Result.ok(null);
    }
    @PostMapping("update")
    @ApiOperation("修改")
    public Result update(@RequestBody Attr attr){
        boolean b = attrService.updateById(attr);
        return Result.ok(null);
    }
    @ApiOperation("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList){
        boolean b = attrService.removeByIds(idList);
        return Result.ok(null);
    }
}

