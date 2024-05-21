package com.pos.menu;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
public class FetchTax{


 Connection conn=DbConnect.getConnection();

       
      

 public String getTax() throws SQLException
    {
     
     String taxName = null;
     String taxRate=null;
     Statement stTax=conn.createStatement();
     String sqlselect="select taxShortName,taxRate from taxes";
     ResultSet rsTax=stTax.executeQuery(sqlselect);
            
      while (rsTax.next()) {
      try{ 
               
            taxName=rsTax.getString("taxShortName");
            taxRate=rsTax.getString("taxRate");
      } // end catch
      catch (SQLException e) {
      System.out.println(e);
    }//end catch
       
      }//end while
       
return taxRate;
}//end method
   

}//closing FetchProducts

