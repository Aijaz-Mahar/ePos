/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.menu.order;

import com.pos.menu.DbConnect;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;


public class Order {

    String orderId, orderSalesTax, serviceCharges, productId, productQty, salesPrice, amount;
   String orderDate,orderType,tableName,customerName;
   
    Connection conn = DbConnect.getConnection();
    //java.util.Date curdate=new java.util.Date();
    
  
    // generate bill number
    public String genrateOrderNo() throws SQLException {
        ResultSet resultSetMaxOrderId;
        Statement statementCreateBillno = conn.createStatement();
        String sqlMaxOrderId = "select  max(order_id)+1 as orderno from orders";
        resultSetMaxOrderId = statementCreateBillno.executeQuery(sqlMaxOrderId);
        String orderNo = null;
        while (resultSetMaxOrderId.next()) {
            orderNo = resultSetMaxOrderId.getString("orderno");
            
        }//end while
        return orderNo;
    }
// value setters
    public void setOrderId(String orderId) {
        this.orderId = orderId;
        
    }

    public void setOrderDate(String orderDate)   {
    
   this.orderDate=orderDate;
       
       
    }
    
    public void setOrderType(String orderType)   {
    
   this.orderType=orderType;
              
    }

  public void setTableName(String tableName)   {
    
   this.tableName=tableName;
              
    }
  public void setCustomerName(String customerName)   {
    
   this.customerName=customerName;
              
    }
    public void setOrderSalesTax(String orderSalesTax) {
        this.orderSalesTax = orderSalesTax;
    }

    public void setServicesCharges(String serviceCharges) {
        this.serviceCharges = serviceCharges;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setProductQty(String productQty) {
        this.productQty = productQty;
    }

    public void setSalesPrice(String salesPrice) {
        this.salesPrice = salesPrice;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
//  insert order in database table
    public void insertMasterOrder()
{
    if(orderType=="Take Away")
    {
     tableName="0";
    }
   try {   
            
    PreparedStatement psMasterOrders = conn.prepareStatement("INSERT INTO orders(order_id,order_date,order_type,tablename,customer_name,order_sales_tax_amount) VALUES(?,?,?,?,?,?)");
      psMasterOrders.setString(1, this.orderId);
      psMasterOrders.setString(2, this.orderDate);
      psMasterOrders.setString(3, this.orderType);
      psMasterOrders.setString(4, this.tableName);
      psMasterOrders.setString(5, this.customerName);
        psMasterOrders.setString(6, this.orderSalesTax);
      
     //Executing the statement
      psMasterOrders.execute();
       
      
      
       
 } catch (SQLException ex) {
            ex.printStackTrace();
        }

} //ending method insertOrders()
    public void insertDetailOrder(String[] productId,String[] qty,String[] price,double[] amount,int rows) throws SQLException
    {   System.out.println("order id "+orderId);
        String varProductId,varQty,varPrice,varAmount;      
         for(int index=0;index<rows;index++)
         { varProductId=productId[index];
           varQty=qty[index];
           varPrice=price[index];
           varAmount=Double.toString(amount[index]);
       
       PreparedStatement psOrdersDetail = conn.prepareStatement("INSERT INTO orders_detail(order_id,product_id,product_qty,"
               + "s_price,amount) VALUES(?,?,?,?,?)");
       psOrdersDetail.setString(1, this.orderId);
       psOrdersDetail.setString(2, varProductId);
       psOrdersDetail.setString(3, varQty);
       psOrdersDetail.setString(4, varPrice);
       psOrdersDetail.setString(5, varAmount);
       psOrdersDetail.execute();
         }//for loop
    }
}//end class Bill

