package com.fengyu.auth.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fengyu.auth.service.ISysRoleService;
import com.fengyu.common.Result;
import com.fengyu.common.config.exception.FengyuException;
import com.fengyu.model.system.SysRole;
import com.fengyu.vo.system.SysRoleQueryVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "角色管理接口")
@RestController
@RequestMapping("/admin/system/sysRole")
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
             // 封装 like-模糊查询 eq-精准查询
            queryWrapper.like(SysRole::getRoleName, roleName);
        }

        // 3 调用 service 的方法实现
        IPage<SysRole> pageModel = sysRoleService.page(pageParam, queryWrapper);
        return Result.ok(pageModel);
    }

    // 添加角色
    @ApiOperation("添加角色")
    @PostMapping("save")
    public Result save(@RequestBody SysRole sysRole){
        // 调用 service 的方法
        boolean is_success = sysRoleService.save(sysRole);
        if (is_success) return Result.ok();
        else return Result.fail();
    }

    // 修改角色——根据Id查询
    @ApiOperation("根据id查询角色")
    @GetMapping("get/{id}")
    public Result getById(@PathVariable Long id){
        try{
            int i = 10/0;
        } catch (Exception e){
            throw new FengyuException(2025, "执行了自定义异常处理");
        }
        SysRole sysRole = sysRoleService.getById(id);
        return Result.ok(sysRole);
    }

    // 修改角色
    @ApiOperation("修改角色")
    @PutMapping("update")
    public Result updateById(@RequestBody SysRole sysRole){
        // 调用 service 的方法
        boolean is_success = sysRoleService.updateById(sysRole);
        if (is_success) return Result.ok();
        else return Result.fail();
    }

    // 根据Id删除
    @ApiOperation("根据Id删除")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id){
        // 调用 service 的方法
        boolean is_success = sysRoleService.removeById(id);
        if (is_success) return Result.ok();
        else return Result.fail();
    }

    // 批量删除
    @ApiOperation("批量删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList){
        // 调用 service 的方法
        boolean is_success = sysRoleService.removeByIds(idList);
        if (is_success) return Result.ok();
        else return Result.fail();
    }
}
