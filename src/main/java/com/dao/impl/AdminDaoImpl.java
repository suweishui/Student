package com.dao.impl;

import com.dao.AdminDao;
import com.entity.Admin;
import com.untils.JdbcHelper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 17586
 */
public class AdminDaoImpl implements AdminDao {
    public ResultSet rs = null;
    @Override
    public Admin login(String username, String password) {
        Admin admin = null;
        String sql  = "select * from bookadmin where username = ? and password = ?";
        Object[] params = {username,password};
        rs = JdbcHelper.executeQuery(sql,params);
        try {
            if (rs != null) {
                while (rs.next()){
                    admin = new Admin(rs.getInt(1), rs.getString(2), rs.getString(3));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        } finally {
            JdbcHelper.release(null,null,rs);
        }
        return admin;
    }
}
