package org.example.product.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ssym.vo.product.AttrGroupQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.example.product.entity.Attr;
import org.example.product.entity.AttrGroup;
import org.example.product.service.AttrGroupService;
import org.example.ssyx.common.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 属性分组 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2023-07-31
 */
@RestController
@RequestMapping("/admin/product/attrGroup")
public class AttrGroupController {

    @Autowired
    private AttrGroupService attrGroupService;

    @ApiOperation("平台属性分组列表")
    @GetMapping("{page}/{limit}")
    public Result list(@PathVariable Long page,
                       @PathVariable Long limit,
                       AttrGroupQueryVo attrGroupQueryVo
    ) {
        Page<AttrGroup> pageParam = new Page<>(page, limit);
       IPage<AttrGroup> attrGroupIPage = attrGroupService.selectPageAttrGroup(pageParam, attrGroupQueryVo);
       return Result.ok(attrGroupIPage);
    }


    @ApiOperation("查询所有平台属性分组列表")
    @GetMapping("findAllList")
    public Result finAllList(){
        List<AttrGroup> list = attrGroupService.findAllAttrGroup();
        return Result.ok(list);
    }


    @ApiOperation("获取")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id){
        AttrGroup attrGroupServiceById = attrGroupService.getById(id);
        return Result.ok(attrGroupServiceById);
    }
    @PostMapping("save")
    @ApiOperation("新增")
    public Result save(@RequestBody AttrGroup attrGroup){
        boolean save = attrGroupService.save(attrGroup);
        return Result.ok(null);
    }
    @DeleteMapping("remove/{id}")
    @ApiOperation("删除")
    public Result remove(@PathVariable Long id){
        boolean remove = attrGroupService.removeById(id);
        return Result.ok(null);
    }
    @PostMapping("update")
    @ApiOperation("修改")
    public Result update(@RequestBody AttrGroup attrGroup){
        boolean b = attrGroupService.updateById(attrGroup);
        return Result.ok(null);
    }
    @ApiOperation("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList){
        boolean b = attrGroupService.removeByIds(idList);
        return Result.ok(null);
    }
}

