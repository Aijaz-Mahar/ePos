/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.menu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @aijazmahar
 */
public class QueryCatJlist {
    private static Connection conn = DbConnect.getConnection();
   
   
 public String[] GetCatList()throws SQLException
 {    String[] CatList;
       
      ResultSet r1;
      Statement st1=conn.createStatement();
      String sqlcount="select count(category_name) as list from category";
      r1=st1.executeQuery(sqlcount);
       // int n=Integer.parseInt(r1.getString("list"));
       int n=0;
        while (r1.next())
        {
        n= r1.getInt("list");
        //System.out.println("Total Rows "+n);}
        
        }
     String sqlselect="select category_name from category order by category_id";
     ResultSet rs=st1.executeQuery(sqlselect);
     int c=0;
     CatList=new String[n]; 
    
      while (rs.next()) {
      try{ 
          
         // String cName = rs.getString("category_name");
          CatList[c]=rs.getString("category_name");
         
        // System.out.println(CatList[c]);
         c++;
      } // end catch
      catch (SQLException e) {
      System.out.println(e);
    }//end catch
       
      }//end while
  //System.out.println("connected");
  return CatList;
 } //end method
 }//end class 
 

