package com.ezhomesixgod.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author renyang
 * @description
 * @createTime 2018-10-13 14:03
 */
public class ConnectionHolder {

    private static String url ="jdbc:mysql://gz-cdb-jm6bdf98.sql.tencentcdb.com:63946/db_share_zcharge?useUnicode=true&characterEncoding=utf8&characterSetResults=utf8";
    private static String name ="root";
    private static String pwd ="testdb2018!@#$%^^";
    private static String driverClassName="com.mysql.jdbc.Driver";

    private static Connection connection=null;

    private ConnectionHolder(){}

    public static Connection getConnection(){
        if(connection ==null){
            try {
                try {
                    Class.forName(driverClassName);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                connection = DriverManager.getConnection(url,name,pwd);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

}
