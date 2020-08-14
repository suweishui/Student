package com.dao;

import com.entity.Reader;

/**
 *
 * @author 17586
 */
public interface ReaderDao {
    /**
     * 传入用户名和密码 返回用户对象
     * @param username 用户名
     * @param password 密码
     * @return Reader 对象
     */
    public Reader login(String username, String password);
}
