package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot.common.Result;
import com.example.springboot.entity.Permission;
import com.example.springboot.entity.User;
import com.example.springboot.mapper.PermissionMapper;
import com.example.springboot.mapper.RoleMapper;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserMapper userMapper;
    @Resource
    RoleMapper roleMapper;
    @Resource
    PermissionMapper permissionMapper;
    //注入bcrypt加密
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    public UserController(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    @PostMapping("/login")
    public Result<?> login(@RequestBody User userParam) {
        User userPwd = userMapper.selectByName(userParam.getUsername());
        if (userPwd == null){
            return Result.error("-1","we do not found the username");
        }
        //System.out.println(bCryptPasswordEncoder.encode("a111111"));
        if(!bCryptPasswordEncoder.matches(userParam.getPassword(),userPwd.getPassword())){
            return Result.error("-1","password is error");
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", userParam.getUsername());
        queryWrapper.eq("password", userPwd.getPassword());
        User res = userMapper.selectOne(queryWrapper);

        //userid->role id
        Integer userId = res.getId();
        res.setRoles(roleMapper.getRoleIdByUserId(userId));
        //List<UserRole> userRoles = roleMapper.getUserRoleByUserId(userId);
        //res.setRoles(userRoles.stream().map(UserRole::getRoleId).distinct().collect(Collectors.toList()));

        HashSet<Permission> permissions = new HashSet<>();
        for (Integer role : res.getRoles()) {
            QueryWrapper<Permission> wrapper = new QueryWrapper<>();
            wrapper.eq("role_permission.role_id",role);
            wrapper.apply("permission.id = permission_id");
            permissions.addAll(permissionMapper.getPermissionByUserId(wrapper));
        }
        LinkedHashSet<Permission> sortedSet = permissions
                .stream().sorted(Comparator.comparing(Permission::getId))
                .collect(Collectors.toCollection(LinkedHashSet::new));
        res.setPermissions(sortedSet);

        // 生成token
        String token = TokenUtils.getToken(res);
        res.setToken(token);
        return Result.success(res);

    }




    @GetMapping("/{id}")
    public Result<?> getById(@PathVariable Long id) {
        return Result.success(userMapper.selectById(id));
    }

}