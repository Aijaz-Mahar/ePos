package com.pos.menu;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
public class FetchProducts{

String paraCatId,paraproductid,productId;
 int rowscount=0;
 Connection conn=DbConnect.getConnection();

public int getNumberOfProducts(String paraCatId) throws SQLException
{

this.paraCatId=paraCatId;
ResultSet r1;
      Statement st1=conn.createStatement();
      String sqlcount="select count(product_id) as totalproducts from master_product where category_id='"+this.paraCatId+"'";
      r1=st1.executeQuery(sqlcount);
      
        while (r1.next())
        {
        rowscount= r1.getInt("totalproducts");
        System.out.println("Total Rows "+rowscount);
        }//end while
        return rowscount;
}// end of method

    public String[][] getProductInfo(String paraCatId) throws SQLException
    {
     this.paraCatId=paraCatId;
     String[][] productList=new String[rowscount][4];
      Statement st1=conn.createStatement();
     String sqlselect="select product_id,product_name,Product_size,product_price from master_product where category_id='"+this.paraCatId+"' order by product_id";
     ResultSet rs=st1.executeQuery(sqlselect);
     int row=0,col=0;
       
      while (rs.next()) {
      try{ 
               
            productList[row][0]=rs.getString("product_id");
            productList[row][1]=rs.getString("product_name");
            productList[row][2]=rs.getString("product_size");
            productList[row][3]=rs.getString("product_price");
           
       // System.out.println(productList[row][0]+productList[row][1]+productList[row][2]+productList[row][3]);
        
         row++;
      } // end catch
      catch (SQLException e) {
      System.out.println(e);
    }//end catch
       
      }//end while
        

System.out.println("Product Cat Id:"+this.paraCatId);
return productList;
}//end method
    
public ImageIcon[] getProductImage(String pataCatId) throws SQLException
{
    ImageIcon[] productImage=new ImageIcon[rowscount];
    Blob vproductimage;
    
    Statement st1=conn.createStatement();
     String sqlselect="select product_image from master_product where category_id='"+this.paraCatId+"' order by product_id";
     ResultSet rs=st1.executeQuery(sqlselect);
     int row=0;
       
      while (rs.next()) {
      try{ 
               
            vproductimage=rs.getBlob("product_image");
            long a = vproductimage.length();
	    byte barr[]=new byte[(int) a];
	    barr=vproductimage.getBytes(1,(int)a);
            productImage[row]=new ImageIcon(barr);
            
       // System.out.println(productList[row][0]+productList[row][1]+productList[row][2]+productList[row][3]);
        
         row++;
      } // end catch
      catch (SQLException e) {
      System.out.println(e);
    }//end catch
       
      }//end while
        
 
 return productImage;				
}

public String[] getProductRow(String productid) throws SQLException
{
    this.paraproductid=productid;
     String[] productcol=new String[4];
     Statement st1=conn.createStatement();
     String sqlselect="select product_id,product_name,Product_size,product_price from master_product where product_id='"+this.paraproductid+"' order by product_id";
     ResultSet rs=st1.executeQuery(sqlselect);
     int col=0;
     while (rs.next()) {
      try{ 
              
            productcol[0]=rs.getString("product_id");
            productcol[1]=rs.getString("product_name");
            productcol[2]=rs.getString("product_size");
            productcol[3]=rs.getString("product_price");
            
           
       // System.out.println(productList[row][0]+productList[row][1]+productList[row][2]+productList[row][3]);
        
         col++;
      } // end catch
      catch (SQLException e) {
      System.out.println(e);
    }//end catch
       
      }//end while
     return productcol;
}


 public String getCurrency() throws SQLException
    {
     
     String currencySign = null;
     Statement stCurrency=conn.createStatement();
     String sqlselect="select currencySign from currency";
     ResultSet rsCurrency=stCurrency.executeQuery(sqlselect);
            
      while (rsCurrency.next()) {
      try{ 
               
            currencySign=rsCurrency.getString("currencySign");
                           
      } // end catch
      catch (SQLException e) {
      System.out.println(e);
    }//end catch
       
      }//end while
       
return currencySign;
}//end method
   

 
}//closing FetchProducts

