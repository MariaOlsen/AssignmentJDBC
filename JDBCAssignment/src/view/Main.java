/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.DBUtil;
import dbTables.States;
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

        String query = "SELECT stateId, stateName FROM states";

        //Try-with resource - can initialize auto-closeable objects that are needed in the try-catch block
        //This automatically closes connections, statements and resultsets after use
        try (
                Connection con = DBUtil.getConnection(DBType.POSTRESQL);
                //sets resultset type to a scrollable type (read-only)
                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet rs = stmt.executeQuery(query);) {

            rs.first();

           
            States.displayData(rs);
                    
                    
            System.out.println("CONNECTED!");

        } catch (SQLException ex) {
            System.out.println("CONNECTION FAIL");
            System.err.println(ex);

        }

    }

}
