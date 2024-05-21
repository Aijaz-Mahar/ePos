
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

public class UpdateTax {
   
String taxId,taxName,taxShortName,taxRate;

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public void setTaxShortName(String taxShortName) {
        this.taxShortName = taxShortName;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    public String getTaxId() {
        return taxId;
    }

    public String getTaxName() {
        return taxName;
    }

    public String getTaxShortName() {
        return taxShortName;
    }

    public String getTaxRate() {
        return taxRate;
    }

      

public void updateTax() throws FileNotFoundException
{
   Connection conn = DbConnect.getConnection();
   
   try {   
            
    {
     PreparedStatement pstmt = conn.prepareStatement("update Taxes set taxname=?,taxShortName=?,taxrate=?"
            + "where upper(taxid)='"+this.getTaxId()+"'");
           
      pstmt.setString(1, this.getTaxName());
      //pstmt.setString(2, this.getProductId());
      pstmt.setString(2, this.getTaxShortName());
      pstmt.setString(3, this.getTaxRate());
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
