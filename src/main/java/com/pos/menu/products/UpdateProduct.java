
package com.pos.menu.products;

import com.pos.menu.DbConnect;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateProduct {
   
String catId;
String productId,productName,productSize,productPrice;
String productImage;
/*
private void setProductValues(String catId,String productId,String productName,String productSize,
        String productPrice,String productImage)      
{
    this.catId=catId;
    this.productId=productId;
    this.productName=productName;
    this.productPrice=productPrice;
    this.productSize=productSize;
    this.productImage=productImage;
  
}//closing setProductValues
*/
    public void setCatId(String catId) {
        this.catId = catId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductSize(String productSize) {
        this.productSize = productSize;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    //getters
    public String getCatId()
    {
    return catId;
    }
    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductSize() {
        return productSize;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public String getProductImage() {
        return productImage;
    }

public void updateProduct() throws FileNotFoundException
{
   Connection conn = DbConnect.getConnection();
   String imagePath=this.getProductImage();
   System.out.println(imagePath);
  
   
   try {   
            
  if (!imagePath.equals(""))
   { 
    PreparedStatement pstmt = conn.prepareStatement("update master_product set category_id=?,product_name=?,"
             + "product_image=?, product_price=?,product_size=?"
           + " where upper(product_id)='"+this.getProductId()+"' ");
      pstmt.setString(1, this.getCatId());
      //pstmt.setString(2, this.getProductId());
      pstmt.setString(2, this.getProductName());
           
      //Inserting Blob type
      InputStream in;
     in = new FileInputStream(this.getProductImage());
    // in = new FileInputStream("e:\\posimgs\\mt1.jpg");
     pstmt.setBlob(3, in);
      pstmt.setString(4,this.getProductPrice());
      pstmt.setString(5,this.getProductSize());
      //Executing the statement
      pstmt.execute();
    
   }
        else {
     PreparedStatement pstmt = conn.prepareStatement("update master_product set category_id=?,product_name=?,"
             + "product_price=?,product_size=?"
           + " where upper(product_id)='"+this.getProductId()+"' ");
      pstmt.setString(1, this.getCatId());
      //pstmt.setString(2, this.getProductId());
      pstmt.setString(2, this.getProductName());
           
      //Inserting Blob type
   //   InputStream in;
     // in = new FileInputStream(this.getProductImage());
        //in = new FileInputStream("e:\\posimgs\\mt1.jpg");
   //   pstmt.setBlob(3, in);
      pstmt.setString(3,this.getProductPrice());
      pstmt.setString(4,this.getProductSize());
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
