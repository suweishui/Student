package com.service;

/**
 * @author 17586
 */
public interface ReaderService {
    /**
     * 传入用户名和密码 然后返回查询出的用户对象
     * @param username 用户名
     * @param password 密码
     * @param type 用户类型
     * @return Reader对象
     */
    public Object login(String username, String password,String type);
}
