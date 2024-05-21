
package com.pos.menu.products;

import com.pos.menu.DbConnect;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertProduct {
   
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

public void insertProduct() throws FileNotFoundException
{
   Connection conn = DbConnect.getConnection();
    try {   
            
     PreparedStatement pstmt = conn.prepareStatement("INSERT INTO master_product(category_id,product_id,product_name,product_image,product_price,product_size)"
           + " VALUES(?,?,?,?,?,?)");
      pstmt.setString(1, this.getCatId());
      pstmt.setString(2, this.getProductId());
      pstmt.setString(3, this.getProductName());
           
      //Inserting Blob type
      InputStream in;
      in = new FileInputStream(this.getProductImage());
        //in = new FileInputStream("e:\\posimgs\\mt1.jpg");
      pstmt.setBlob(4, in);
      pstmt.setString(5,this.getProductPrice());
      pstmt.setString(6,this.getProductSize());
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
