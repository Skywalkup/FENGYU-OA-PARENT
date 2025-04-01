package com.fengyu.vo.system;

import java.io.Serializable;

/**
 * 角色查询实体类
 */
public class SysRoleQueryVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
