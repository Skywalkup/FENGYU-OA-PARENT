package com.fengyu.auth;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fengyu.auth.mapper.SysRoleMapper;
import com.fengyu.auth.service.ISysRoleService;
import com.fengyu.model.system.SysRole;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
//@MapperScan("com.fengyu.auth")
public class TestMapperDemo2 {

    @Autowired
    private ISysRoleService sysRoleService;

    // 查询所有记录
    @Test
    public void getAll(){
        List<SysRole> list = sysRoleService.list();
        System.out.println(list);
    }

}
