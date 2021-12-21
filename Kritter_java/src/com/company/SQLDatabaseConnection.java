package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;


public class SQLDatabaseConnection {
    private static final String url = "jdbc:mysql://localhost";
    private static final String user = "root";
    private static final String password = "emmalujsp";
    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) {

        String MySQLURL = "jdbc:mysql://localhost:3306/sampledb?useSSL=false";
        String databseUserName = "root";
        String databasePassword = "emmalujsp";
        Connection con = null;
        try {
            con = DriverManager.getConnection(MySQLURL, databseUserName, databasePassword);
            if (con != null) {
                System.out.println("Database connection is successful !!!!");
                Statement stmt=con.createStatement();
                ResultSet rs=stmt.executeQuery("select * from emp");
                while(rs.next())
                    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
                con.close();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}