package com.dc.mspringboot.base;


import com.dc.mspringboot.em.EnumError;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.List;

/**
 * @author Enzo
 * @ClassName BaseModel
 * @Description 辅助类
 * @date 2015-8-18
 */
@SuppressWarnings("serial")
public class BaseModel implements Serializable {
    @ApiModelProperty(value = "存放消息状态值，0表示正常，非0表示异常")
    private int resultCode;// 正确消息是0；错误是1,未登录9，登录后无权限8
    @ApiModelProperty(value = "存放返回的响应消息")
    private String message = "";// 存放返回的消息（9未登录或会话超时，请重新登录！）
    @ApiModelProperty(value = "存放返回的结果集")
    private Object data;// 存放查询结果集

    @ApiModelProperty(value = "存放上传的文件")
    private MultipartFile[] tempMFile;// 用于文件导入时存放文件
    @ApiModelProperty(value = "用于存放上传文件的id")
    private String filesArray;// 用于存放文件上传的路径


    @ApiModelProperty(value = "返回给aop，用于日志记录")
    private String aopMesg = "";

    @ApiModelProperty(value = "表单防重token")
    private String token;
    @ApiModelProperty(value = "操作模块权限值")
    private String permission;
    @ApiModelProperty(value = "操作模块有权限的按钮dom")
    private String permission_btns;
    @ApiModelProperty(value = "aop模块序列")
    private int aop_num;

    public int getAop_num() {
        return aop_num;
    }

    public void setAop_num(int aop_num) {
        this.aop_num = aop_num;
    }

    public String getPermission_btns() {
        return permission_btns;
    }

    public void setPermission_btns(String permission_btns) {
        this.permission_btns = permission_btns;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAopMesg() {
        return aopMesg;
    }

    public void setAopMesg(String aopMesg) {
        this.aopMesg = aopMesg;
    }

    public void setMessage(EnumError emErr) {
        this.message = emErr.getMsg();
        this.resultCode = emErr.getCode();
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public MultipartFile[] getTempMFile() {
        return tempMFile;
    }

    public void setTempMFile(MultipartFile[] tempMFile) {
        this.tempMFile = tempMFile;
    }

    public String getFilesArray() {
        return filesArray;
    }

    public void setFilesArray(String filesArray) {
        this.filesArray = filesArray;
    }
}
