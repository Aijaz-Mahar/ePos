
package com.pos.menu.setting;

import com.pos.menu.products.*;
import com.pos.menu.DbConnect;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTable {
   
String tableId;
String tableName;
String description;

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setDescroption(String description) {
        this.description = description;
    }

    public String getTableId() {
        return tableId;
    }

    public String getTableName() {
        return tableName;
    }

    public String getDescription() {
        return description;
    }


public void insertTable() throws FileNotFoundException
{
   Connection conn = DbConnect.getConnection();
    try {   
            
     PreparedStatement pstmt = conn.prepareStatement("INSERT INTO tables(tableid,tablename,description)"
           + " VALUES(?,?,?)");
      pstmt.setString(1, this.getTableId());
      
      pstmt.setString(2, this.getTableName());
      pstmt.setString(3, this.getDescription());
           
      //Inserting Blob type
     /* InputStream in;
      in = new FileInputStream(this.getProductImage());
        //in = new FileInputStream("e:\\posimgs\\mt1.jpg");
      pstmt.setBlob(4, in); */
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
        } //end catch


}// end of method insertProduct


}//end of class insertProduct
