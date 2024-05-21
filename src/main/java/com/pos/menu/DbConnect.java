package com.pos.menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *         
 * @author aijazmahar
 */
public class DbConnect {
    // apache derby
  private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
  private static final String URL = "jdbc:derby:\\ePOS\\db\\mydb;user=aa;password=aa";
    // oracle db drivers
 // private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
  //private static final String URL = "jdbc:oracle:thin:@localhost:1521:ORCL19C";
   //mysql drivers and connection
//private static final String DRIVER = "com.mysql.jdbc.Driver";
//private static final String URL = "jdbc:mysql://emahardb.ckuehcccydvw.eu-north-1.rds.amazonaws.com:3306/pos\",\"admin\",\"channar123";

  
   
    private static Connection conn;
    
    public static Connection getConnection() {

        try {

            Class.forName(DRIVER);

            try {

                conn = DriverManager.getConnection(URL,"aa","aa");

            } catch (SQLException ex) {

                // log an exception. fro example:
                JOptionPane.showInputDialog("failed");
                System.out.println("Failed to create the database connection."); 

            }

        } catch (ClassNotFoundException ex) {

            // log an exception. for example:
           
            JOptionPane.showInputDialog("driver not found");
            System.out.println("Driver not found."); 

        }

        return conn;

    }
    
}
