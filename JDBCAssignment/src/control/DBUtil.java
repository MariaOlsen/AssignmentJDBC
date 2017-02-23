/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.*;
import model.DBType;

/**
 *
 * @author maria
 */
public class DBUtil {

    private static final String USERNAME = "dbuser";
    private static final String PASSWORD = "dbpassword";
    private static final String H_CONN_STRING = "jdcb:hsqldb:data/explorecalifornia";
    private static final String M_CONN_STRING = "jdbc:mysql://localhost/explorecalifornia";
    private static final String P_CONN_STRING = "jdbc:postgresql://localhost:5432/explorecalifornia";

    public static Connection getConnection(DBType dbType) throws SQLException {

        switch (dbType) {
            case HSQLDB:
                //Return for HyperSQL database 
                return DriverManager.getConnection(H_CONN_STRING, USERNAME, PASSWORD);

            case MYSQL:
                //Return for MySQL database
                return DriverManager.getConnection(M_CONN_STRING, USERNAME, PASSWORD);

            case POSTRESQL:
                //Return for PostgreSQL database
                return DriverManager.getConnection(P_CONN_STRING, USERNAME, PASSWORD);

            default:
                return null;
        }

    }

    public static void processException(SQLException e) {
        //Codes to identifying errors in various databases.
        //Since each database have their own codes and descriptions,
        //error handling like this is necessary to keep track of everything
        System.err.println("Error message: " + e.getMessage());
        System.err.println("Error code: " + e.getErrorCode());
        System.err.println("SQL State: " + e.getSQLState());

    }

}
