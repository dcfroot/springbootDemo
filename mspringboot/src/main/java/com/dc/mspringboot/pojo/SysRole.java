package com.dc.mspringboot.pojo;


import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class SysRole implements Serializable {
    @ApiModelProperty(value = "角色自增id")
    private int role_id;
    @ApiModelProperty(value = "角色描述")
    private String memo;

    @ApiModelProperty(value = "角色名称")
    private String name;


    @ApiModelProperty(value = "   创建人用户id")
    private int create_user_id;

    @ApiModelProperty(value = "   创建人用户名")
    private String create_user_name;

    @ApiModelProperty(value = "   创建时间")
    private Date create_time;

    @ApiModelProperty(value = "   更新人用户id")
    private int update_user_id;

    @ApiModelProperty(value = "   更新人用户名")
    private String update_user_name;

    @ApiModelProperty(value = "   更新时间")
    private Date update_time;

    @ApiModelProperty(value = "   1删除0存在")
    private int is_deleted;

    @ApiModelProperty(value = " 版本号")
    private int version;

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }


    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreate_user_id() {
        return create_user_id;
    }

    public void setCreate_user_id(int create_user_id) {
        this.create_user_id = create_user_id;
    }

    public String getCreate_user_name() {
        return create_user_name;
    }

    public void setCreate_user_name(String create_user_name) {
        this.create_user_name = create_user_name;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public int getUpdate_user_id() {
        return update_user_id;
    }

    public void setUpdate_user_id(int update_user_id) {
        this.update_user_id = update_user_id;
    }

    public String getUpdate_user_name() {
        return update_user_name;
    }

    public void setUpdate_user_name(String update_user_name) {
        this.update_user_name = update_user_name;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }


}