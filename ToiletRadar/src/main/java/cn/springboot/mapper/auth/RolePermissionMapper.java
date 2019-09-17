package cn.springboot.mapper.auth;

import org.apache.ibatis.annotations.Mapper;

import cn.springboot.mapper.BaseMapper;
import cn.springboot.model.auth.RolePermission;

/**
 * @author sh
 * @Description 角色与菜单关系Mapper
 * @date Apr 12, 2019 9:13:04 AM
 */
@Mapper
public interface RolePermissionMapper extends BaseMapper<String, RolePermission> {

    public RolePermission findRolePermission(RolePermission per);

}
