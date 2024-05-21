package com.pos.menu;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
public class FetchProductsBySearch{

String paraCatId,paraproductid,productId;
 int rowscount=0;
 Connection conn=DbConnect.getConnection();


public int getNumberOfProductsBySearch(String ProductIdBySearch) throws SQLException
{

this.productId=ProductIdBySearch;
System.out.println("Total Rows "+rowscount);
ResultSet r1;
      Statement st1=conn.createStatement();
      String sqlcount="select count(product_id) as totalproducts from master_product where upper(product_id||product_name) like '%'||'"+this.productId+"'||'%'";
      r1=st1.executeQuery(sqlcount);
      
        while (r1.next())
        {
            System.out.println(this.productId);
        rowscount= r1.getInt("totalproducts");
        
        }//end while
        return rowscount;
}// end of method

    
public ImageIcon[] getProductImageBySearch(String pataCatId) throws SQLException
{
    ImageIcon[] productImage=new ImageIcon[rowscount];
    Blob vproductimage;
    
    Statement st1=conn.createStatement();
     String sqlselect="select product_image from master_product where upper(product_id||product_name) like '%'||'"+this.productId+"'||'%'";
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

 public String[][] getProductInfoBySearch(String productId) throws SQLException
    {
     this.productId=productId;
     String[][] productList=new String[rowscount][4];
      Statement st1=conn.createStatement();
     String sqlselect="select product_id,product_name,Product_size,product_price from master_product where upper(product_id||product_name) like '%'||'"+this.productId+"'||'%'";
     ResultSet rs=st1.executeQuery(sqlselect);
     int row=0,col=0;
       
      while (rs.next()) {
      try{ 
               
            productList[row][0]=rs.getString("product_id");
            productList[row][1]=rs.getString("product_name");
            productList[row][2]=rs.getString("product_size");
            productList[row][3]=rs.getString("product_price");
           
        System.out.println(productList[row][0]+productList[row][1]+productList[row][2]+productList[row][3]);
        
         row++;
      } // end catch
      catch (SQLException e) {
      System.out.println(e);
    }//end catch
       
      }//end while
        

System.out.println("Product Id:"+this.productId);
return productList;
}//end method
 
}//closing FetchProducts

