package com.fengyu.auth.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengyu.auth.service.ISysRoleService;
import com.fengyu.common.Result;
import com.fengyu.model.system.SysRole;
import com.fengyu.vo.system.SysRoleQueryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "角色管理接口")
@RestController
@RequestMapping("/admin/system/sysrole")
public class SysRoleController {
    // 注入service
    @Autowired
    private ISysRoleService sysRoleService;

//    // 查询所有角色
//    @GetMapping("/findAll")
//    public List<SysRole> findAll() {
//        List<SysRole> list = sysRoleService.list();
//        return list;
//    }

    @ApiOperation("查询所有角色")
    @GetMapping("/findAll")
    public Result findAll(){
        List<SysRole> list = sysRoleService.list();
        return Result.ok(list );
    }

    // 条件分页查询
    // page 代表当前页 limit 代表每页显示记录数
    @ApiOperation("条件分页查询")
    @GetMapping("{page}/{limit}")
    public Result pageQueryRole(@PathVariable Long page,
                                @PathVariable Long limit,
                                SysRoleQueryVO sysRoleQueryVO) {
        // 1 创建 Page 对象，传递分页相关参数
        Page<SysRole> pageParam = new Page<>(page, limit);

        // 2 封装条件，判断条件是否为空，不为空则进行封装
        LambdaQueryWrapper<SysRole> queryWrapper = new LambdaQueryWrapper<>();
        String roleName = sysRoleQueryVO.getRoleName();
        if (!StringUtils.isEmpty(roleName)) {
             // 封装
            queryWrapper.like(SysRole::getRoleName, roleName);
        }

        // 3 调用 service 的方法实现
        IPage<SysRole> pageModel = sysRoleService.page(pageParam, queryWrapper);
        return Result.ok(pageModel);
    }
}
