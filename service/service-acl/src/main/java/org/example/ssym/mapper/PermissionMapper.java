package org.example.ssym.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ssym.model.acl.Permission;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {
}
