package com.dao;

import com.entity.Admin;

/**
 * @author 17586
 */
public interface AdminDao {
    /**
     *  传入用户名密码 返回对象
     * @param username 用户名
     * @param password 密码
     * @return 返回Admin对象
     */
    public Admin login(String username,String password);
}
