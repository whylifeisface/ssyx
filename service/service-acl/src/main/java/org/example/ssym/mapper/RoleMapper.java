package org.example.ssym.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ssym.model.acl.Role;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
}
