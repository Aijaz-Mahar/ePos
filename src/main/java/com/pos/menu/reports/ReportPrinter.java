/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pos.menu.reports;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.swing.JRViewer;

public class ReportPrinter 
{
   public ReportPrinter(String fileName,HashMap parameter, Connection conn)
{
//super("Report View");
//Image image = new ImageIcon("/MaharAccounting/src/Images/mainwinicon.jpg").getImage();
     //   Image icon = Toolkit.getDefaultToolkit().getImage("/MaharAccounting/src/Images/mtech.jpg");
//this.setIconImage(icon);
// this.setIconImage(image);
try
{
//Way 1
/*JasperDesign jasperDesign = JasperManager.loadXmlDesign(fileName);
JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
JasperPrint print = JasperFillManager.fillReport(jasperReport, parameter, con);*/

//Way 2
JasperReport jasperReport = JasperCompileManager.compileReport(fileName);
JasperPrint print = JasperFillManager.fillReport(jasperReport, parameter, conn);

/*Way 3 (Here the parameter file should be in .jasper extension i.e., the compiled report)*/
//JasperPrint print = JasperFillManager.fillReport(fileName, parameter,conn);

JasperPrintManager.printReport(print,false);


}
catch(JRException jre)
{
jre.printStackTrace();
}



}
/*
public static void main(String args[])
{
// A sample calling 
HashMap param=new HashMap();
//param.put("reportParameterName",valueForTheParameter);
MyiReportViewer viewer=new MyiReportViewer("/test/src/test/report2.jasper",param);
viewer.setVisible(true);
}*/
}

