package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.model.activity.ActivityInfo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper

public interface ActivityInfoMapper extends BaseMapper<ActivityInfo> {
    List<Long> selectExistSkuIdList(@Param("skuIdList") List<Long> skuList);

}
