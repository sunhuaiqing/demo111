package org.example.demo111.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

//连接mysql工具类
public class JdbcUtils {
    public static String DRIVERNAME = "com.mysql.jdbc.Driver";
    public static String URL = "jdbc:mysql://127.0.0.1:3306";
    public static String USER = "root";
    public static String PASSWORD = "123456";
    public static Connection conn = null;

    static {
        try {
            Properties props = new Properties();
            InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
            props.load(in);

            DRIVERNAME = props.getProperty("driver");
            URL = props.getProperty("url");
            USER = props.getProperty("username");
            PASSWORD = props.getProperty("password");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //获取连接
    public static Connection getConnection() throws Exception {
        if (conn != null) {
            return conn;
        }
        //注册驱动
        Class.forName(DRIVERNAME);
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
        return conn;
    }

    //关闭连接
    public static void closeResource(Connection conn, PreparedStatement st) throws SQLException {
        st.close();
        conn.close();
    }

    public static void closeResource(Connection conn, ResultSet rs, PreparedStatement st) throws SQLException {
        st.close();
        rs.close();
        conn.close();
    }
}