package com.pos.menu.reports;
import com.pos.menu.DatePicker;
import com.pos.menu.DbConnect;
import java.awt.Image;
import java.sql.Connection;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class SalesReportByProduct extends javax.swing.JFrame {
String repDateFrom,repDateTo;
 Connection conn = null;
    
    public SalesReportByProduct() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelSalesReport = new javax.swing.JLabel();
        btnView = new javax.swing.JButton();
        btnclose = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtDateFrom = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDateTo = new javax.swing.JTextField();
        btnDateFrom = new javax.swing.JButton();
        btnDateTo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabelSalesReport.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelSalesReport.setForeground(new java.awt.Color(255, 255, 255));
        jLabelSalesReport.setText("Sales Report by Product");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelSalesReport)
                .addGap(143, 143, 143))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelSalesReport, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        btnView.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });

        btnclose.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnclose.setText("Close");
        btnclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("From");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("To");

        btnDateFrom.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDateFrom.setText("Select Date");
        btnDateFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDateFromActionPerformed(evt);
            }
        });

        btnDateTo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDateTo.setText("Select Date");
        btnDateTo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDateToActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDateFrom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDateTo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtDateFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDateFrom))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDateTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDateTo))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(46, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(btnView)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(btnclose))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(btnclose))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnView))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
    Image image = new ImageIcon("\\ePOS\\images\\eTech.png").getImage();
        //   Image icon = Toolkit.getDefaultToolkit().getImage("/MaharAccounting/src/Images/mtech.jpg");
        //this.setIconImage(icon);
        this.setIconImage(image);
        conn = DbConnect.getConnection();
           Date curdate=new Date();
        Format formatter;
        
        formatter = new SimpleDateFormat("dd-MMM-yyyy");
    String strCurrentDate = formatter.format(curdate);
    this.txtDateFrom.setText(strCurrentDate);
    this.txtDateTo.setText(strCurrentDate);
   
    //forSQLDateFrom= SQLFormatter.format(txtDateFrom.getText());
    //forSQLDateTo= SQLFormatter.format(txtDateFrom.getText());
   
   
    }//GEN-LAST:event_formComponentShown

    private void btncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
    }//GEN-LAST:event_btncloseActionPerformed

    private void btnDateFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDateFromActionPerformed
        // TODO add your handling code here:
        this.pack();
        this.txtDateFrom.setText(new DatePicker(this).setPickedDate());
    }//GEN-LAST:event_btnDateFromActionPerformed

    private void btnDateToActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDateToActionPerformed
        // TODO add your handling code here:
         this.pack();
        this.txtDateTo.setText(new DatePicker(this).setPickedDate());
    }//GEN-LAST:event_btnDateToActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        printSalesReport();
    }//GEN-LAST:event_btnViewActionPerformed
    
     private void printSalesReport() {
       
         setReportDateFormat();
        String jrxmlFile = "\\ePOS\\src\\main\\java\\com\\pos\\menu\\reports\\SalesReportByProduct.jrxml";
        HashMap param = new HashMap();
        param.put("dateFrom", repDateFrom);
        param.put("dateTo",repDateTo);
        PrintReport reportview = new PrintReport();
        reportview.viewReport(jrxmlFile, param, conn);

    }
  private void setReportDateFormat()
  {
       Format formatter2;
   try {
        //SQLFormatter=new SimpleDateFormat("yyyy-mm-dd").parse(txtDateFrom.getText());
        Date dateFrom=new SimpleDateFormat("dd-MMM-yyyy").parse(txtDateFrom.getText());
        Date dateTo=new SimpleDateFormat("dd-MMM-yyyy").parse(txtDateTo.getText());
        formatter2=new SimpleDateFormat("yyyy-MM-dd");
        repDateFrom=formatter2.format(dateFrom);
        repDateTo=formatter2.format(dateTo);
        
         System.out.println("rep date:"+repDateFrom);
         System.out.println("rep date to:"+repDateTo);
    } catch (ParseException ex) {
        Logger.getLogger(SalesReportByProduct.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SalesReportByProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalesReportByProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalesReportByProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalesReportByProduct.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalesReportByProduct().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDateFrom;
    private javax.swing.JButton btnDateTo;
    private javax.swing.JButton btnView;
    private javax.swing.JButton btnclose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelSalesReport;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtDateFrom;
    private javax.swing.JTextField txtDateTo;
    // End of variables declaration//GEN-END:variables
}