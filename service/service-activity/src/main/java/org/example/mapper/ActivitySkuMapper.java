package org.example.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.model.activity.ActivitySku;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ActivitySkuMapper extends BaseMapper<ActivitySku> {
}
