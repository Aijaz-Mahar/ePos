
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

public class UpdateCurrency {
   
String currencyId,currencyName,currencyShortName,currencySign;

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public void setCurrencyShortName(String currencyShortName) {
        this.currencyShortName = currencyShortName;
    }

    public void setCurrencySign(String currencySign) {
        this.currencySign = currencySign;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getCurrencyShortName() {
        return currencyShortName;
    }

    public String getCurrencySign() {
        return currencySign;
    }

      

public void updateCurrency() throws FileNotFoundException
{
   Connection conn = DbConnect.getConnection();
   
   try {   
            
    {
     PreparedStatement pstmt = conn.prepareStatement("update Currency set currencyname=?,currncyShortName=?,CurrencySign=?"
            + "where upper(currencyid)='"+this.getCurrencyId()+"'");
           
      pstmt.setString(1, this.getCurrencyName());
      //pstmt.setString(2, this.getProductId());
      pstmt.setString(2, this.getCurrencyShortName());
      pstmt.setString(3, this.getCurrencySign());
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
