package com.example.springboot.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot.entity.Role;
import com.example.springboot.entity.UserRole;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    @Select("select * from user_role where user_id = #{userId}")
    List<UserRole> getUserRoleByUserId(Integer userId);

    @Delete("delete from user_role where user_id = #{userId}")
    void deleteRoleByUserId(Integer userId);
    @Insert("insert into user_role(user_id, role_id) values(#{userId}, #{roleId})")
    void insertUserRole(Integer userId, Integer roleId);

    @Select("SELECT user_role.role_id FROM user_role where user_id = #{userId}")
    List<Integer> getRoleIdByUserId(Integer userid);

    @Select("select role.* from role,user_role "+"${ew.customSqlSegment}")
    List<Role> getRoleByUserId(@Param("ew") Wrapper wrapper);
}