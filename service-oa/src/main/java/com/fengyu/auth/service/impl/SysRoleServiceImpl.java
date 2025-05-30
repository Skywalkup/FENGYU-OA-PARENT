package com.fengyu.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fengyu.auth.mapper.SysRoleMapper;
import com.fengyu.auth.service.ISysRoleService;
import com.fengyu.model.system.SysRole;
import org.springframework.stereotype.Service;

@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements ISysRoleService {
}
