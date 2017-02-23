/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.DBUtil;
import java.sql.*;
import model.DBType;

/**
 *
 * @author maria
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {

        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        try {
            con = DBUtil.getConnection(DBType.POSTRESQL);
            
            //sets resultset type to a scrollable type (read-only)
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            String query = "SELECT * FROM states";
            rs = stmt.executeQuery(query);
            
            rs.last();
            System.out.println("Number of rows: " + rs.getRow());
            
            System.out.println("CONNECTED!");
            
        } catch (SQLException ex) {
            System.out.println("CONNECTION FAIL");
            System.err.println(ex);
            
        } finally {
            //Closes the connection to the database in reverse order as their creation
            if (rs != null){
                rs.close();
            }
            if (stmt != null){
                stmt.close();
            }
            if (con != null) {
                con.close();
            }
        }

    }

}
