package com.dc.service.impl;

import com.dc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @Auther: dcf
 * @Date: 2019/2/20
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {

    /**
     * JdbcTemplate主要提供以下五类方法：
     *
     * execute方法：可以用于执行任何SQL语句，一般用于执行DDL语句；
     * update方法及batchUpdate方法：update方法用于执行新增、修改、删除等语句；batchUpdate方法用于执行批处理相关语句；
     * query方法及queryForXXX方法：用于执行查询相关语句；
     * call方法：用于执行存储过程、函数相关语句。
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String name, Integer age) {
        jdbcTemplate.update("insert into t_user(name, age) values(?, ?)", name, age);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete from t_user where NAME = ?", name);
    }

    @Override
    public Integer getAllUsers() {
        return jdbcTemplate.queryForObject("select count(id) from t_user", Integer.class);
    }

    @Override
    public void deleteAllUsers() {
        jdbcTemplate.update("delete from t_user");
    }
}
