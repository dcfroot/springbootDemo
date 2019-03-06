package com.dc.mspringboot.em;

/**
 * @author Enzo
 * @Description 错误信息枚举类
 * @date 2018-8-15 14:04
 */
public enum EnumError {
    SYS_ERROR(1001, "系统异常，请联系管理员！"),
    NETWORK(1002, "网络异常"),
    ENCRYPTION(1003, "加密异常"),
    RESUBMIT(1004, "【请勿重复提交请求】"),
    NOT_TOKEN(1024, "【Token不能为空】"),

    NO_LOGIN(1005, "未登录或会话超时，请重新登录！"),
    NO_SEARCH(1006, "无查询权限"),
    NO_PERMISSIONS(1007, "对不起，您无  {module} {type} 权限，不能进行此操作！"),

    LOGIN_SECONDARY(1008, "您的账户在异地登录,如不是本人操作,请及时修改密码！"),
    LOGIN_NULL_USER(1009, "帐号或密码不能为空"),
    LOGIN_USER(1010, "帐号或密码错误"),
    LOGIN_ACCOUNT(1011, "帐号不存在"),
    LOGIN_INACTIVE(1012, "帐号未激活，请联系管理员"),
    LOGIN_PASSWORD(1013, "密码错误或加密异常"),
    ACCOUT_LOCK(1014, "30分钟内连续5次登录错误，您的帐号暂时被锁定"),

    SQL_ERROR(1015, "SQL异常，请修改SQL语句后重试！"),
    QUERY_ERROR(1016, "查询条件异常，请修改查询条件后重试！"),
    QUERY_ERROR_TIME(1017, "时间查询条件异常不支持此关系查询！"),
    UPDATE_VES(1018, "更新失败，操作的记录已被更新"),
    UPDATE_NULL(1019, "【更新失败，字段不允许为空】"),
    UPDATE_PK(1020, "主键未标记"),
    ADD(1021, "新增数据异常"),
    UPDATE(1022, "修改数据异常"),

    SUBMIR_PARAMS(1025,"非法操作，请求参数异常")
    ,DELETE(1023, "删除数据异常");

    int code;
    String msg;

    EnumError(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
