package com.pos.menu;

import com.pos.menu.reports.SalesReport;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SRO_SUK
 */
public class CashCalculation {

    Connection conn = DbConnect.getConnection();
    String orderDate;

// calculate sum of orders cash amount
    public double cashAmount(String orderDate) throws SQLException {
        double amount = 0;
        ResultSet r1;
        Statement st1 = conn.createStatement();
        String sqlcount = "SELECT sum(amount) as amount FROM orders o,orders_detail od where o.ORDER_ID=od.ORDER_ID and order_date='" + orderDate + "'";
        r1 = st1.executeQuery(sqlcount);

        while (r1.next()) {
            amount = r1.getDouble("amount");

        }//end while

        return amount;
    }
//calculate sum of sales tax amount

    public double taxAmount(String orderDate) throws SQLException {
        double taxAmount = 0;
        ResultSet r1;
        Statement st1 = conn.createStatement();
        String sqlcount = "SELECT sum(order_sales_tax_amount) as tax"
                + " FROM ORDERS where order_date='" + orderDate + "'";
        r1 = st1.executeQuery(sqlcount);

        while (r1.next()) {
            taxAmount = r1.getDouble("tax");

        }//end while

        return taxAmount;
    }

    public String setDateFormat(String todayDate) {
        Format formatter2;
        String dbdate = null;
        try {
            //SQLFormatter=new SimpleDateFormat("yyyy-mm-dd").parse(txtDateFrom.getText());
            Date todate = new SimpleDateFormat("dd.MM.yyyy").parse(todayDate);
            formatter2 = new SimpleDateFormat("yyyy-MM-dd");
            dbdate = formatter2.format(todate);

        } catch (ParseException ex) {
            Logger.getLogger(SalesReport.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dbdate;
    }

}
