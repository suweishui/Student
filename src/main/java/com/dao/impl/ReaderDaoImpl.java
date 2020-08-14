package com.dao.impl;

import com.dao.ReaderDao;
import com.entity.Reader;
import com.untils.JdbcHelper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author 17586
 */
public class ReaderDaoImpl implements ReaderDao {
    public ResultSet rs = null;
    @Override
    public Reader login(String username, String password) {
        Reader reader = null;
        String sql = "select * from reader where username = ? and password = ?";
        Object[] params = {username,password};
        rs = JdbcHelper.executeQuery(sql,params);
        try {
            if (rs != null) {
                    while (rs.next()){
                        reader = new Reader();
                        reader.setId(rs.getInt(1));
                        reader.setUsername(rs.getString(2));
                        reader.setPassword(rs.getString(3));
                        reader.setName(rs.getString(4));
                        reader.setTel(rs.getString(5));
                        reader.setCarid(rs.getString(6));
                        reader.setGender(rs.getString(7));
                    }
            }
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        } finally {
            JdbcHelper.release(JdbcHelper.conn,JdbcHelper.ps,rs);
        }
        return reader;
    }
}
