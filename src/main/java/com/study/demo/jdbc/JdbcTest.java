package com.study.demo.jdbc;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Author: Chenhexiang
 * @Description:
 * @Date: 2019-04-30 08:33
 */
public class JdbcTest {
    public static void main(String[] args) throws Exception{

        Connection connection = null;
        Statement statement = null;
        try {
            connection = JdbcTest.getConnection();
            String sql = "insert into mkcms_fav (name, url, userid) values ('chx', 'www.baidu.com', 1)";
            statement = connection.createStatement();
            String updateSql = "update mkcms_fav set name='ddd' where id=1";
            String deletSql = "truncate table mkcms_fav";
            System.out.println(statement.executeUpdate(deletSql));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (connection != null) {
                    connection.close();
                }
            }
        }


    }

    public void getInput() {
        InputStream in = getClass().getClassLoader().getResourceAsStream("application.yml");
        Properties properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(properties.toString());
    }

    public static Connection getConnection() throws Exception{
        String driverName = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://192.168.8.102:3306/movie";
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "123456");

        Class.forName(driverName);
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, properties);
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
