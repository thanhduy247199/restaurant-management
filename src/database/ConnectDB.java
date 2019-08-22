/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Administrator
 */
public class ConnectDB {
     public Connection getConnect() {
        try {
            String connectionUrl = "jdbc:sqlserver://localhost:1433;"
                    + "databaseName=RestaurantManagementDB;user=sa;password=songlong";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(connectionUrl);
            System.out.println("Kết nối thành công!");
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public static void main(String[] args) {
        ConnectDB cdb = new ConnectDB();
        Connection conn = cdb.getConnect();
        if(conn != null)
        {
            System.out.println("Connected");
        }
    }
    
    
}
