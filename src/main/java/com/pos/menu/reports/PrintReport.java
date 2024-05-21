/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pos.menu.reports;

import java.sql.Connection;
import java.util.HashMap;

public class PrintReport {
 
    
    public void viewReport(String fileName, HashMap param,Connection conn)
    {
    
     MyiReportViewer viewer=new MyiReportViewer(fileName,param,conn);
     viewer.setVisible(true);
    }
}
