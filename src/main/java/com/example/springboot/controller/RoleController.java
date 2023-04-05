package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springboot.common.Result;
import com.example.springboot.entity.Role;
import com.example.springboot.entity.RolePermission;
import com.example.springboot.mapper.PermissionMapper;
import com.example.springboot.mapper.RoleMapper;
import com.example.springboot.utils.Utils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/role")
public class RoleController {
    @Resource
    com.example.springboot.mapper.RoleMapper RoleMapper;

    @Resource
    PermissionMapper permissionMapper;
    @GetMapping
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search){
        LambdaQueryWrapper<Role> wrapper = Wrappers.lambdaQuery();
        if(Utils.isBlank(search)){
            wrapper.like(Role::getName,search);
        }
        Page<Role> RolePage = RoleMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        List<Role> records = RolePage.getRecords();
        // 给角色设置绑定的权限id数组
        for (Role record : records) {
            Integer roleId = record.getId();
            List<Integer> permissions = permissionMapper.getRolePermissionByRoleId(roleId).stream().map(RolePermission::getPermissionId).collect(Collectors.toList());
            record.setPermissions(permissions);
        }
        return Result.success(RolePage);

    }
}