package com.example.springboot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot.entity.Permission;
import com.example.springboot.entity.User;
import com.example.springboot.mapper.PermissionMapper;
import com.example.springboot.mapper.RoleMapper;
import com.example.springboot.mapper.UserMapper;

import com.example.springboot.utils.TokenUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.stream.Collectors;

@SpringBootTest
class ApplicationTests {
//    @Resource
//    UserMapper userMapper;
    @Resource
    PermissionMapper permissionMapper;
    @Resource
    RoleMapper roleMapper;
    @Resource
    UserMapper userMapper;
    @Test
    void contextLoads() {
//        QueryWrapper<Permission> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("role_permission.role_id",1);
//        queryWrapper.apply("permission.id = permission_id");
//        System.out.println(permissionMapper.getPermissionByUserId(queryWrapper));
//        QueryWrapper<Permission> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("user_role.user_id",1);
//        queryWrapper.apply("role.id=user_role.role_id");
//        System.out.println(roleMapper.getRoleByUserId(queryWrapper));
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        System.out.println(bCryptPasswordEncoder.encode("a11111111"));

    }

}