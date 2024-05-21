/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.pos.menu.products;

import com.pos.menu.DbConnect;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddProduct {

    public static void main(String[] args) throws Exception {
   
     Connection conn = DbConnect.getConnection();
    //String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
    //String databaseURL = "jdbc:derby:f:\\myProj\\mydb";
    try {   
            
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO master_product(category_id,product_id,product_name,product_image,product_price)"
                    + " VALUES(?,?,?,?,?)");
      pstmt.setString(1, "2");
      pstmt.setString(2, "mt");
      pstmt.setString(3, "Milk Tea");
      
      
      //Inserting Blob type
      InputStream in;
        in = new FileInputStream("e:\\posimgs\\mt1.jpg");
      pstmt.setBlob(4, in);
      pstmt.setString(5, "150");
      //Executing the statement
      pstmt.execute();
            /*Statement statement = conn.createStatement();
            String sql = "SELECT * FROM test";
            ResultSet result = statement.executeQuery(sql);
 
            while (result.next()) {
                System.out.println(result.getString("itemname"));
            }*/
 } catch (SQLException ex) {
            ex.printStackTrace();
        }

}
}