package com.pos.menu;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FetchOrder{  

 String paraOrderId;
 int rowscount=0;
 Connection conn=DbConnect.getConnection();

 
 public void setParaOrderId(String paraOrderId) {
        this.paraOrderId = paraOrderId;
    }

    public String getParaOrderId() {
        return paraOrderId;
    }
 
public int getNumberOfProducts(String paraOrderId) throws SQLException
{

this.paraOrderId=paraOrderId;
ResultSet r1;
      Statement st1=conn.createStatement();
      String sqlcount="select count(product_id) as totalproducts from orders_view where order_id="+this.paraOrderId;
      r1=st1.executeQuery(sqlcount);
      
        while (r1.next())
        {
        rowscount= r1.getInt("totalproducts");
        System.out.println("Total Rows "+rowscount);
        }//end while
        return rowscount;
}// end of method

    public String[][] getProductInfo(String paraOrderId) throws SQLException
    {
     this.paraOrderId=paraOrderId;
     String[][] productList=new String[rowscount][5];
      Statement st1=conn.createStatement();
     String sqlselect="select product_id,product_name,Product_qty,s_price,amount from"
             + " orders_view where order_id="+this.paraOrderId;
     ResultSet rs=st1.executeQuery(sqlselect);
     int row=0,col=0;
       
      while (rs.next()) {
      try{ 
               
            productList[row][0]=rs.getString("product_id");
            productList[row][1]=rs.getString("product_name");
            productList[row][2]=rs.getString("product_qty");
            productList[row][3]=rs.getString("s_price");
            productList[row][4]=rs.getString("amount");
           
       // System.out.println(productList[row][0]+productList[row][1]+productList[row][2]+productList[row][3]);
        
         row++;
      } // end catch
      catch (SQLException e) {
      System.out.println(e);
    }//end catch
       
      }//end while
        

System.out.println("order Id:"+this.paraOrderId);
return productList;
}//end method
    

public String[][] getProductRow(String paraOrderId) throws SQLException
{
    this.paraOrderId=paraOrderId;
    int totalRows=this.getNumberOfProducts(paraOrderId);
     String[][] productList=new String[totalRows][5];
     Statement st1=conn.createStatement();
      String sqlselect="select product_id,product_name,Product_qty,s_price,amount from"
             + " orders_view where order_id="+this.paraOrderId;
    
     ResultSet rs=st1.executeQuery(sqlselect);
     int col=0,row=0;
     while (rs.next()) {
      try{ 
              
            productList[row][0]=rs.getString("product_id");
            productList[row][1]=rs.getString("product_name");
            productList[row][2]=rs.getString("product_qty");
            productList[row][3]=rs.getString("s_price");
            productList[row][4]=rs.getString("amount");
            
           
       // System.out.println(productList[row][0]+productList[row][1]+productList[row][2]+productList[row][3]);
        
         row++;
      } // end catch
      catch (SQLException e) {
      System.out.println(e);
    }//end catch
       
      }//end while
     return productList;
}

 
}//closing FetchProducts

