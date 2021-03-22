package com.udemy.spring.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {

    public static void main(String[] args) {

        try {
            System.out.println("Connecting....");

            Connection connection = getConnection();

            System.out.println("Connection is successful...");

            //connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        System.out.println("driverClassName is downloading ... ");
        try {
            Class.forName(DBConfig.driverClassName);
        } catch (ClassNotFoundException e) {
            System.out.println("error while driver downloading ... ");

            e.printStackTrace();

        }
        System.out.println("driverClassName is successfully downloaded !!!");

        System.out.println("Connection is creating ... ");
        connection = DriverManager.getConnection(DBConfig.dbURL, DBConfig.user, DBConfig.password);

        return connection;
    }
}
