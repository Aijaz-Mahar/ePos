package com.pos.menu.setting;
import com.pos.menu.*;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
public class FetchTables{

String paraCatId,paraproductid,productId;
 int rowscount=0;
 Connection conn=DbConnect.getConnection();

public int getNumberOfTables() throws SQLException
{

//this.paraCatId=paraCatId;
ResultSet r1;
      Statement st1=conn.createStatement();
      String sqlcount="select count(tableid) as totaltables from tables";
      r1=st1.executeQuery(sqlcount);
      
        while (r1.next())
        {
        rowscount= r1.getInt("totaltables");
        System.out.println("Total Rows "+rowscount);
        }//end while
        return rowscount;
}// end of method

    public String[][] getTableInfo() throws SQLException
    {
     //this.paraCatId=paraCatId;
     int totalRows=this.getNumberOfTables();
     String[][] tableList=new String[totalRows][4];
      Statement st1=conn.createStatement();
     String sqlselect="select tableid,tablename,description from tables order by tableid";
     ResultSet rs=st1.executeQuery(sqlselect);
     int row=0,col=0;
       
      while (rs.next()) {
      try{ 
               
            tableList[row][0]=rs.getString("tableid");
            tableList[row][1]=rs.getString("tablename");
            tableList[row][2]=rs.getString("description");
            
           
       // System.out.println(productList[row][0]+productList[row][1]+productList[row][2]+productList[row][3]);
        
         row++;
      } // end catch
      catch (SQLException e) {
      System.out.println(e);
    }//end catch
       
      }//end while
        
return tableList;
}//end method
  
public String[][] getTableRow(String productid) throws SQLException
{
    this.paraproductid=productid;
     String[][] tablesrowcol=new String[rowscount][3];
     Statement st1=conn.createStatement();
     String sqlselect="select tableid,tablename,description from tables order by tableid";
     ResultSet rs=st1.executeQuery(sqlselect);
     int row=0,col=0;
     while (rs.next()) {
      try{ 
              
            tablesrowcol[row][0]=rs.getString("tableid");
            tablesrowcol[row][1]=rs.getString("tablename");
            tablesrowcol[row][2]=rs.getString("description");
            
            
           
       // System.out.println(productList[row][0]+productList[row][1]+productList[row][2]+productList[row][3]);
         
         row++;
      } // end catch
      catch (SQLException e) {
      System.out.println(e);
    }//end catch
       
      }//end while
     return tablesrowcol;
}

  

 
}//closing FetchProducts

