package com.dc.mspringboot.vo;


import com.dc.mspringboot.pojo.SysFileLog;
import com.dc.mspringboot.pojo.SysRole;
import com.dc.mspringboot.pojo.SysUser;
import com.dc.mspringboot.pojo.SysUserRole;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
 * @author Enzo
 * @Description TODO
 * @date 2018-8-23 11:10
 */
public class SysUserVo implements Serializable {
    int user_id;
    @ApiModelProperty("角色名称")
    String role_names;
    @ApiModelProperty("原密码")
    String old_password;
    SysUser user;
    List<SysRole> listRole;
    List<SysUserRole> listUserRole;
    SysFileLog fileLog;

    public String getOld_password() {
        return old_password;
    }

    public void setOld_password(String old_password) {
        this.old_password = old_password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getRole_names() {
        return role_names;
    }

    public void setRole_names(String role_names) {
        this.role_names = role_names;
    }

    public SysFileLog getFileLog() {
        return fileLog;
    }

    public void setFileLog(SysFileLog fileLog) {
        this.fileLog = fileLog;
    }

    public List<SysUserRole> getListUserRole() {
        return listUserRole;
    }

    public void setListUserRole(List<SysUserRole> listUserRole) {
        this.listUserRole = listUserRole;
    }

    public SysUser getUser() {
        return user;
    }

    public void setUser(SysUser user) {
        this.user = user;
    }

    public List<SysRole> getListRole() {
        return listRole;
    }

    public void setListRole(List<SysRole> listRole) {
        this.listRole = listRole;
    }
}
