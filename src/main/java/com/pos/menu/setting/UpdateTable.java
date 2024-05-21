
package com.pos.menu.setting;

import com.pos.menu.company.*;
import com.pos.menu.products.*;
import com.pos.menu.DbConnect;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateTable {
   
String tableId,tableName,description;

    public void setTableId(String tableId) {
        this.tableId = tableId;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setDescription(String description) {
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
      

public void updateTable() throws FileNotFoundException
{
   Connection conn = DbConnect.getConnection();
   
   try {   
            
    {
     PreparedStatement pstmt = conn.prepareStatement("update Tables set tablename=?,description=?"
            + "where upper(tableid)='"+this.getTableId()+"'");
           
      pstmt.setString(1, this.getTableName());
      
      pstmt.setString(2, this.getDescription());
      
      //Executing the statement
      pstmt.execute();
            /*Statement statement = conn.createStatement();
            String sql = "SELECT * FROM test";
            ResultSet result = statement.executeQuery(sql);
 
            while (result.next()) {
                System.out.println(result.getString("itemname"));
            }*/
        } //end of else
        
 } catch (SQLException ex) {
            ex.printStackTrace();
        } //end catch


}// end of method insertProduct


}//end of class insertProduct
