package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.entity.Permission;
import com.example.springboot.entity.RolePermission;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {
    @Select("select * from role_permission where role_id = #{roleId}")
    List<RolePermission> getRolePermissionByRoleId(Integer roleId);

    @Delete("delete from role_permission where role_id = #{roleId}")
    void deletePermissionsByRoleId(Integer roleId);

    @Insert("insert into role_permission(role_id, permission_id) values(#{roleId}, #{permissionId})")
    void insertRoleAndPermission(@Param("roleId") Integer roleId, @Param("permissionId") Integer permissionId);

    @Select("SELECT permission.* FROM role_permission,permission "+"${ew.customSqlSegment}")
    List<Permission> getPermissionByUserId(@Param("ew") Wrapper wrapper);

}