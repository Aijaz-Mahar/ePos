
package com.pos.menu.products;

import com.pos.menu.DbConnect;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteProduct {
   
String catId;
String productId,productName,productSize,productPrice;
String productImage;

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

public void deleteProduct() throws FileNotFoundException
{
   Connection conn = DbConnect.getConnection();
   String imagePath=this.getProductImage();
   System.out.println(imagePath);
  
   
   try {   
            
     PreparedStatement pstmt = conn.prepareStatement("delete from master_product where upper(product_id)='"+this.getProductId()+"' ");
     
      //Executing the statement
      pstmt.execute();
        
 } catch (SQLException ex) {
            ex.printStackTrace();
        } //end catch


}// end of method insertProduct


}//end of class insertProduct
