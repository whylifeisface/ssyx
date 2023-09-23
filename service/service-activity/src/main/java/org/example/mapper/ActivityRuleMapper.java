package org.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.checkerframework.common.aliasing.qual.MaybeAliased;
import org.example.model.activity.ActivityRule;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ActivityRuleMapper extends BaseMapper<ActivityRule> {
}
