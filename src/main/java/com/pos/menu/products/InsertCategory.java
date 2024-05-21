
package com.pos.menu.products;

import com.pos.menu.DbConnect;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertCategory {
   
String catId;
String catName;
String productImage;

    public void setCatId(String catId) {
        this.catId = catId;
    }

   

    public void setProductName(String catName) {
        this.catName = catName;
    }


    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    //getters
    public String getCatId()
    {
    return catId;
    }
   
    public String getcatName() {
        return catName;
    }

 

    public String getProductImage() {
        return productImage;
    }

public void insertCat() throws FileNotFoundException
{
   Connection conn = DbConnect.getConnection();
    try {   
            
     PreparedStatement pstmt = conn.prepareStatement("INSERT INTO category(category_id,category_name)"
           + " VALUES(?,?)");
      pstmt.setString(1, this.getCatId());
      
      pstmt.setString(2, this.getcatName());
           
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
