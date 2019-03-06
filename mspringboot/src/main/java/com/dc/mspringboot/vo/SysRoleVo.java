package com.dc.mspringboot.vo;


import com.dc.mspringboot.pojo.SysRole;
import com.dc.mspringboot.pojo.SysRolePermission;

import java.io.Serializable;
import java.util.List;

/**
 * @author Enzo
 * @Description TODO
 * @date 2018-8-17 10:18
 */
public class SysRoleVo implements Serializable {
    int role_id;
    SysRole role;
    List<SysRolePermission> listRolePermission;

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public SysRole getRole() {
        return role;
    }

    public void setRole(SysRole role) {
        this.role = role;
    }

    public List<SysRolePermission> getListRolePermission() {
        return listRolePermission;
    }

    public void setListRolePermission(List<SysRolePermission> listRolePermission) {
        this.listRolePermission = listRolePermission;
    }
}
