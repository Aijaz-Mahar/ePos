
package com.pos.menu.products;

import com.pos.menu.DbConnect;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateCategory {
   
String catId;
String catName;
String catImage;

    public void setCatId(String catId) {
        this.catId = catId;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public void setCatImage(String catImage) {
        this.catImage = catImage;
    }

    public String getCatId() {
        return catId;
    }

    public String getCatName() {
        return catName;
    }

    public String getCatImage() {
        return catImage;
    }

    

 


public void updatetCat() throws FileNotFoundException
{
   Connection conn = DbConnect.getConnection();
    try {   
            
     PreparedStatement pstmt = conn.prepareStatement("update category set category_name=? "
             + "where category_Id='"+this.getCatId()+"'");
           
      //pstmt.setString(1, this.getCatId());
      
      pstmt.setString(1, this.getCatName());
           
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
