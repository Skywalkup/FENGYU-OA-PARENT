package com.fengyu.auth;

import com.fengyu.auth.mapper.SysRoleMapper;
import com.fengyu.model.system.SysRole;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
//@MapperScan("com.fengyu.auth")
public class TestMapperDemo1 {

    @Autowired
    private SysRoleMapper mapper;

    // 查询所有记录
    @Test
    public void getAll(){
        List<SysRole> list = mapper.selectList(null);
        System.out.println(list);
    }

    // 添加操作
    @Test
    public void add() {
        SysRole sysRole = new SysRole();

        sysRole.setRoleName("经理");
        sysRole.setRoleCode("manager");
        sysRole.setDescription("普通用户");

        int rows = mapper.insert(sysRole);
        System.out.println("======rows: " + rows);
        System.out.println("======sysRole: " + sysRole);
        System.out.println("======id: " + sysRole.getId());
    }

    // 修改操作
    @Test
    public void update() {
        // 1 根据id查询
        SysRole sysRole = mapper.selectById(12);
        // 2 设置修改值
        sysRole.setRoleName("修改管理员");
        // 3 调用方法实现修改
        int rows = mapper.updateById(sysRole);

        System.out.println(rows);
    }

    // 删除操作
    @Test
    public void deleteId() {
        int rows = mapper.deleteById(12);
    }

    // 批量删除
    @Test
    public void testDeleteBatchIds() {
        int result = mapper.deleteBatchIds(Arrays.asList(12, 13));
        System.out.println(result);
    }
}
