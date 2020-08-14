package com.untils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.*;

/**
 * @author 17586
 */
public class JdbcHelper {

    private static final DataSource dataSource;
    public static Connection conn;
    public static PreparedStatement ps;
    public static ResultSet rs;

    static {
        dataSource = new ComboPooledDataSource("testc3p0");

    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static PreparedStatement createPrepareStatement(String sql,Object[] params){
        try {
            ps = getConnection().prepareStatement(sql);
            if(params!=null){
                for (int i =0;i< params.length;i++){
                    ps.setObject(i+1,params[i]);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;
    }
    public static boolean executeUpdate(String sql,Object[] params){
        ps = createPrepareStatement(sql,params);
        try {
            int count = ps.executeUpdate();
            return count > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            release(conn,ps,rs);
        }
    }
    public static ResultSet executeQuery(String sql,Object[] params){
        ps = createPrepareStatement(sql,params);
        try {
            return ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void release(Connection connection, Statement statement, ResultSet resultSet){
        try {
            if(connection != null){
                connection.close();
            }
            if(statement != null){
                statement.close();
            }
            if(resultSet != null){
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
