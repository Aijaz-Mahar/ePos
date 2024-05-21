
package com.pos.menu.company;

import com.pos.menu.products.*;
import com.pos.menu.DbConnect;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateCompany {
   
String companyId,companyName,address,contact,website;
String companyLogo;
   
  

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

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }
  public void setWebsite(String website) {
        this.website = website;
    }

    public String getCompanyId() {
        return companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddress() {
        return address;
    }

    public String getContact() {
        return contact;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }
     public String getWebsite() {
        return website;
    }
public void updateCompany() throws FileNotFoundException
{
   Connection conn = DbConnect.getConnection();
   String imagePath=this.getCompanyLogo();
   System.out.println(imagePath);
  
   
   try {   
            
     if (!imagePath.equals(""))
   { 
    PreparedStatement pstmt = conn.prepareStatement("update COMPANY set name=?,ADDRESS=?,CONTACT=?,WEBSITE=?,"
            + "LOGO=? where upper(companyid)='"+this.getCompanyId()+"'");
           
      pstmt.setString(1, this.getCompanyName());
      //pstmt.setString(2, this.getProductId());
      pstmt.setString(2, this.getAddress());
      pstmt.setString(3, this.getContact());
      pstmt.setString(4, this.getWebsite());
      //Inserting Blob type
      InputStream in;
     in = new FileInputStream(this.getCompanyLogo());
    // in = new FileInputStream("e:\\posimgs\\mt1.jpg");
     pstmt.setBlob(5, in);
      
      //Executing the statement
      pstmt.execute();
      System.out.println("updateed....");
    
   }
        else {
     PreparedStatement pstmt = conn.prepareStatement("update COMPANY set name=?,ADDRESS=?,CONTACT=?,WEBSITE=?"
            + "where upper(companyid)='"+this.getCompanyId()+"'");
           
      pstmt.setString(1, this.getCompanyName());
      //pstmt.setString(2, this.getProductId());
      pstmt.setString(2, this.getAddress());
      pstmt.setString(3, this.getContact());
      pstmt.setString(4, this.getWebsite());
   
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
