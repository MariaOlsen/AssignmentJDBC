/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maria
 */
public class Main {

    private static final String USERNAME = "dbuser";
    private static final String PASSWORD = "dbpassword";
    private static final String CONN_STRING = "jdbc:postgresql://localhost:5432/explorecalifornia";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

        Connection con = null;
        try {
            con = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            System.out.println("CONNECTION FAIL");
            System.err.println(ex);
        } finally {
            if (con != null) {
                con.close();
            }
        }

    }

}
