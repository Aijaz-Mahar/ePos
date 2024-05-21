package com.pos.menu;

import com.pos.menu.order.Order;
import com.pos.menu.reports.PrintReport;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import com.pos.menu.QtyDialog;
import com.pos.menu.company.UpdateCompanyForm;
import com.pos.menu.order.SearchOrder;
import com.pos.menu.products.AddCategory;
import com.pos.menu.products.AddMasterProduct;
import com.pos.menu.products.AddProduct;
import com.pos.menu.products.UpdateCategoryForm;
import com.pos.menu.products.UpdateMasterProduct;
import com.pos.menu.reports.ReportPrinter;
import com.pos.menu.reports.SalesReport;
import com.pos.menu.setting.UpdateCurrencyForm;
import com.pos.menu.setting.UpdateTaxForm;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SwingConstants;
import javax.swing.table.*;
import com.pos.menu.QueryTableList;
import com.pos.menu.order.CancelOrder;
import com.pos.menu.order.OrdersList;
import com.pos.menu.reports.SalesReportByProduct;
import com.pos.menu.reports.SalesReportOrderType;
import com.pos.menu.setting.AddTable;
import com.pos.menu.setting.UpdateTables;

/**
 *
 * @aijazmahar
 */
// Main POS class Jframe
public class PosScreen extends javax.swing.JFrame {
 private DefaultTableModel model;
// class variables to use for rows and columns in jtable and integer buttons to count buttons
  private int buttons,rows=0,cols=0,tableinputrow=0,vnumberOfRows=0,productSearchFlag=0;    
  // creating jbutton arrays
  static JButton[] btnarray;
  // creating jlist model for category list
   DefaultListModel listModel=new DefaultListModel();
   // Connection type variable
   private static Connection conn = null;
   // variables used to category list value and category id on selection
   String listvalue,vcatId,vProductIdSearch;
   String[] itemID,itemName,itemSize,itemPrice;
   String currencySign,orderType;
   //vamount variable to find price*qty 
   double vamount=0;
   //variables to return current row and current col
   int crow=0,ccol=0;
   // array to return selected row and col
   public int rowcolumn[]=new int[2];
 //setting date format
  private SimpleDateFormat formatter;
    private String taxRate;
  FetchTax Tax=new FetchTax();
// PosScreen class constructor
    public PosScreen() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
       // implementing interface method onDelete to stop cell editing and delete row on click in column cut
        TableActionEvent event=new TableActionEvent()
        {
              @Override
         public void onDelete(int row) {
            if(jTableInvoice.isEditing())
                {jTableInvoice.getCellEditor().stopCellEditing();
                  }          
               
                model.removeRow(row);
                rows--;
                tableinputrow--;
                vnumberOfRows=model.getRowCount();
                  try {
                      calculateTotal();
                  } catch (SQLException ex) {
                      Logger.getLogger(PosScreen.class.getName()).log(Level.SEVERE, null, ex);
                  }
                
            }
        }    ;
          
        this.jTableInvoice.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
        this.jTableInvoice.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));  
               
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog2 = new javax.swing.JDialog();
        jLabel5 = new javax.swing.JLabel();
        dtxtId = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        dtxtItem = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        dtxtSize = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        dtxtPrice = new javax.swing.JTextField();
        jDialogQty = new javax.swing.JDialog();
        jSpinner1 = new javax.swing.JSpinner();
        btnQtyApply = new javax.swing.JButton();
        btnQtyCancel = new javax.swing.JButton();
        radioGroupOrderType = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanelMain = new javax.swing.JPanel();
        txtDate = new javax.swing.JTextField();
        jRadioButtonDineInn = new javax.swing.JRadioButton();
        jRadioButtonTakeAway = new javax.swing.JRadioButton();
        comboTablesList = new javax.swing.JComboBox<>();
        btnRefresh = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txtCashSales = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTaxAmount = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtNetCash = new javax.swing.JTextField();
        jScrollPaneCatList = new javax.swing.JScrollPane();
        jList_category = new javax.swing.JList<>();
        jScrollPaneJtable = new javax.swing.JScrollPane();
        jTableInvoice = new javax.swing.JTable();
        ItemPanel = new javax.swing.JPanel();
        jPanel_Search = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtitemsearch = new javax.swing.JTextField();
        jScrollPaneButtons = new javax.swing.JScrollPane();
        jPanelInJscrollButton = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lblTax = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        txtBillTotal = new javax.swing.JTextField();
        btnPay = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblCurrency = new javax.swing.JLabel();
        txtTax = new javax.swing.JTextField();
        txtGrandTotal = new javax.swing.JTextField();
        txtOrderNo = new javax.swing.JTextField();
        lblOrderNo = new javax.swing.JLabel();
        lblCustomerName = new javax.swing.JLabel();
        txtCustomerName = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lbleTech = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        MenuAddItem = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        MenuUpdateItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        MenuDeleteItem = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        MenuCat = new javax.swing.JMenu();
        MenuItemAddCat = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        MenuUpdateCat = new javax.swing.JMenuItem();
        jSeparator17 = new javax.swing.JPopupMenu.Separator();
        jMenuItemCatgList = new javax.swing.JMenuItem();
        jSeparator18 = new javax.swing.JPopupMenu.Separator();
        jSeparator19 = new javax.swing.JPopupMenu.Separator();
        jMenuItemProductList = new javax.swing.JMenuItem();
        MenuReports = new javax.swing.JMenu();
        jMenuItem_salesReport = new javax.swing.JMenuItem();
        jSeparator11 = new javax.swing.JPopupMenu.Separator();
        jMenuItem_product_sales = new javax.swing.JMenuItem();
        jSeparator12 = new javax.swing.JPopupMenu.Separator();
        jMenuItemDine = new javax.swing.JMenuItem();
        jSeparator13 = new javax.swing.JPopupMenu.Separator();
        MenuOrders = new javax.swing.JMenu();
        MenuFindBill = new javax.swing.JMenuItem();
        jSeparator8 = new javax.swing.JPopupMenu.Separator();
        MenuCancelOrder = new javax.swing.JMenuItem();
        jSeparator7 = new javax.swing.JPopupMenu.Separator();
        MenuOrdersList = new javax.swing.JMenuItem();
        MenuSetting = new javax.swing.JMenu();
        MenuItemTax = new javax.swing.JMenuItem();
        jSeparator9 = new javax.swing.JPopupMenu.Separator();
        MenuItemCurrency = new javax.swing.JMenuItem();
        jSeparator10 = new javax.swing.JPopupMenu.Separator();
        MenuItemBusiness = new javax.swing.JMenuItem();
        jSeparator14 = new javax.swing.JPopupMenu.Separator();
        jMenuTables = new javax.swing.JMenu();
        jMenuItemAddTable = new javax.swing.JMenuItem();
        jSeparator15 = new javax.swing.JPopupMenu.Separator();
        jMenuItemUpdateTable = new javax.swing.JMenuItem();
        jSeparator16 = new javax.swing.JPopupMenu.Separator();
        jMenuItemDeleteTable = new javax.swing.JMenuItem();
        jMenuClose = new javax.swing.JMenu();
        jMenuItemExit = new javax.swing.JMenuItem();

        jDialog2.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        jDialog2.setTitle("ITEM DETAILS");
        jDialog2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jDialog2.setResizable(false);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 51, 0));
        jLabel5.setText("ID:");

        dtxtId.setEditable(false);
        dtxtId.setBackground(new java.awt.Color(255, 255, 255));
        dtxtId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dtxtId.setAutoscrolls(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Desc:");

        dtxtItem.setEditable(false);
        dtxtItem.setBackground(new java.awt.Color(255, 255, 255));
        dtxtItem.setColumns(20);
        dtxtItem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dtxtItem.setLineWrap(true);
        dtxtItem.setRows(5);
        dtxtItem.setAutoscrolls(false);
        jScrollPane1.setViewportView(dtxtItem);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Size:");

        dtxtSize.setEditable(false);
        dtxtSize.setBackground(new java.awt.Color(255, 255, 255));
        dtxtSize.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dtxtSize.setForeground(new java.awt.Color(255, 0, 0));
        dtxtSize.setAutoscrolls(false);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Price:");

        dtxtPrice.setEditable(false);
        dtxtPrice.setBackground(new java.awt.Color(255, 255, 255));
        dtxtPrice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dtxtPrice.setAutoscrolls(false);

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialog2Layout.createSequentialGroup()
                        .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(dtxtId)))
                    .addGroup(jDialog2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dtxtSize, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                    .addGroup(jDialog2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dtxtPrice)))
                .addContainerGap())
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog2Layout.createSequentialGroup()
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(dtxtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(dtxtSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(dtxtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jSpinner1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        btnQtyApply.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnQtyApply.setText("Apply");
        btnQtyApply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQtyApplyActionPerformed(evt);
            }
        });

        btnQtyCancel.setText("X");
        btnQtyCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQtyCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogQtyLayout = new javax.swing.GroupLayout(jDialogQty.getContentPane());
        jDialogQty.getContentPane().setLayout(jDialogQtyLayout);
        jDialogQtyLayout.setHorizontalGroup(
            jDialogQtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogQtyLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDialogQtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addGroup(jDialogQtyLayout.createSequentialGroup()
                        .addComponent(btnQtyApply, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnQtyCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jDialogQtyLayout.setVerticalGroup(
            jDialogQtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogQtyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jDialogQtyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnQtyApply)
                    .addComponent(btnQtyCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("ePOS 1.0");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        setPreferredSize(new java.awt.Dimension(300, 300));
        setResizable(false);
        setSize(new java.awt.Dimension(300, 300));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanelMain.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtDate.setEditable(false);
        txtDate.setBackground(new java.awt.Color(255, 255, 255));
        txtDate.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDate.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        radioGroupOrderType.add(jRadioButtonDineInn);
        jRadioButtonDineInn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButtonDineInn.setSelected(true);
        jRadioButtonDineInn.setText("Dine In");
        jRadioButtonDineInn.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jRadioButtonDineInnStateChanged(evt);
            }
        });
        jRadioButtonDineInn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonDineInnActionPerformed(evt);
            }
        });

        radioGroupOrderType.add(jRadioButtonTakeAway);
        jRadioButtonTakeAway.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jRadioButtonTakeAway.setText("Take Away");
        jRadioButtonTakeAway.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonTakeAwayActionPerformed(evt);
            }
        });

        comboTablesList.setEditable(true);
        comboTablesList.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        comboTablesList.setToolTipText("Select Table");
        comboTablesList.setAutoscrolls(true);
        comboTablesList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnRefresh.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Cash Sales");

        txtCashSales.setEditable(false);
        txtCashSales.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        txtCashSales.setAutoscrolls(false);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Tax");

        txtTaxAmount.setEditable(false);
        txtTaxAmount.setBackground(new java.awt.Color(255, 255, 255));
        txtTaxAmount.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        txtTaxAmount.setAutoscrolls(false);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 0, 0));
        jLabel11.setText("Net Cash");

        txtNetCash.setEditable(false);
        txtNetCash.setBackground(new java.awt.Color(255, 255, 255));
        txtNetCash.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanelMainLayout = new javax.swing.GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanelMainLayout);
        jPanelMainLayout.setHorizontalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCashSales, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTaxAmount, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNetCash, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(158, 158, 158)
                .addComponent(jRadioButtonTakeAway)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButtonDineInn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboTablesList, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRefresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelMainLayout.setVerticalGroup(
            jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jRadioButtonDineInn)
                .addComponent(jRadioButtonTakeAway)
                .addComponent(comboTablesList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnRefresh)
                .addComponent(jLabel4)
                .addComponent(txtCashSales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel9)
                .addComponent(txtTaxAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel11)
                .addComponent(txtNetCash, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPaneCatList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jList_category.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jList_category.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jList_categoryMouseClicked(evt);
            }
        });
        jList_category.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList_categoryValueChanged(evt);
            }
        });
        jScrollPaneCatList.setViewportView(jList_category);

        jTableInvoice.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableInvoice.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Description", "Price", "Qty", "Amount", "Cut"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableInvoice.setRowHeight(30);
        jTableInvoice.setSelectionBackground(new java.awt.Color(153, 153, 153));
        jTableInvoice.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jTableInvoice.setShowGrid(true);
        jTableInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableInvoiceMouseClicked(evt);
            }
        });
        jTableInvoice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTableInvoiceKeyReleased(evt);
            }
        });
        jScrollPaneJtable.setViewportView(jTableInvoice);

        ItemPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ItemPanel.setAutoscrolls(true);

        jPanel_Search.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Search");

        txtitemsearch.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        txtitemsearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtitemsearchKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtitemsearchKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel_SearchLayout = new javax.swing.GroupLayout(jPanel_Search);
        jPanel_Search.setLayout(jPanel_SearchLayout);
        jPanel_SearchLayout.setHorizontalGroup(
            jPanel_SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_SearchLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtitemsearch, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel_SearchLayout.setVerticalGroup(
            jPanel_SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_SearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel_SearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtitemsearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelInJscrollButtonLayout = new javax.swing.GroupLayout(jPanelInJscrollButton);
        jPanelInJscrollButton.setLayout(jPanelInJscrollButtonLayout);
        jPanelInJscrollButtonLayout.setHorizontalGroup(
            jPanelInJscrollButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 532, Short.MAX_VALUE)
        );
        jPanelInJscrollButtonLayout.setVerticalGroup(
            jPanelInJscrollButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 637, Short.MAX_VALUE)
        );

        jScrollPaneButtons.setViewportView(jPanelInJscrollButton);

        javax.swing.GroupLayout ItemPanelLayout = new javax.swing.GroupLayout(ItemPanel);
        ItemPanel.setLayout(ItemPanelLayout);
        ItemPanelLayout.setHorizontalGroup(
            ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel_Search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(ItemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPaneButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        ItemPanelLayout.setVerticalGroup(
            ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ItemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneButtons, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTextField1.setToolTipText("Search Category");

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblTax.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTax.setForeground(new java.awt.Color(255, 0, 51));
        lblTax.setText("Tax");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotal.setText("Total");

        txtBillTotal.setEditable(false);
        txtBillTotal.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtBillTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBillTotal.setText("0");
        txtBillTotal.setRequestFocusEnabled(false);

        btnPay.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnPay.setText("PAID");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        btnCancel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCancel.setText("RESET");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        lblCurrency.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCurrency.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        txtTax.setEditable(false);
        txtTax.setBackground(new java.awt.Color(255, 255, 255));
        txtTax.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        txtGrandTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtGrandTotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGrandTotal.setText("0");
        txtGrandTotal.setToolTipText("Grand Total");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtGrandTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblTax, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBillTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                    .addComponent(txtTax))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotal)
                    .addComponent(txtBillTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCurrency, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTax)
                    .addComponent(txtTax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnPay, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                        .addComponent(txtGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        txtOrderNo.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N

        lblOrderNo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblOrderNo.setText("Oder#");

        lblCustomerName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCustomerName.setText("Customer");

        txtCustomerName.setText("Valued Customer");

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbleTech.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbleTech.setForeground(new java.awt.Color(255, 255, 255));
        lbleTech.setText("emahar");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("+923002676352");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("info.emahar@gmail.com");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbleTech)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbleTech)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );

        jRadioButton1.setText("jRadioButton1");

        jMenu1.setText("Product |");
        jMenu1.setActionCommand("");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        MenuAddItem.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        MenuAddItem.setText("Add POS Item");
        MenuAddItem.setActionCommand("MenuItemAddProduct");
        MenuAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuAddItemActionPerformed(evt);
            }
        });
        jMenu1.add(MenuAddItem);
        jMenu1.add(jSeparator3);
        jMenu1.add(jSeparator1);

        MenuUpdateItem.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        MenuUpdateItem.setText("Update POS Item");
        MenuUpdateItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuUpdateItemActionPerformed(evt);
            }
        });
        jMenu1.add(MenuUpdateItem);
        jMenu1.add(jSeparator2);
        jMenu1.add(jSeparator4);

        MenuDeleteItem.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        MenuDeleteItem.setText("Delete POS Item");
        jMenu1.add(MenuDeleteItem);
        jMenu1.add(jSeparator6);

        MenuCat.setText("Category");
        MenuCat.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N

        MenuItemAddCat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MenuItemAddCat.setText("Add Category");
        MenuItemAddCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemAddCatActionPerformed(evt);
            }
        });
        MenuCat.add(MenuItemAddCat);
        MenuCat.add(jSeparator5);

        MenuUpdateCat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MenuUpdateCat.setText("Edit Category");
        MenuUpdateCat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuUpdateCatActionPerformed(evt);
            }
        });
        MenuCat.add(MenuUpdateCat);
        MenuCat.add(jSeparator17);

        jMenuItemCatgList.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemCatgList.setText("Category List");
        jMenuItemCatgList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCatgListActionPerformed(evt);
            }
        });
        MenuCat.add(jMenuItemCatgList);
        MenuCat.add(jSeparator18);

        jMenu1.add(MenuCat);
        jMenu1.add(jSeparator19);

        jMenuItemProductList.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMenuItemProductList.setText("Product List");
        jMenuItemProductList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemProductListActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemProductList);

        jMenuBar1.add(jMenu1);

        MenuReports.setText("Reports |");
        MenuReports.setActionCommand("");
        MenuReports.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItem_salesReport.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jMenuItem_salesReport.setText("Sales Report");
        jMenuItem_salesReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_salesReportActionPerformed(evt);
            }
        });
        MenuReports.add(jMenuItem_salesReport);
        MenuReports.add(jSeparator11);

        jMenuItem_product_sales.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jMenuItem_product_sales.setText("Product-Wise Sales ");
        jMenuItem_product_sales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem_product_salesActionPerformed(evt);
            }
        });
        MenuReports.add(jMenuItem_product_sales);
        MenuReports.add(jSeparator12);

        jMenuItemDine.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jMenuItemDine.setText("Sales by Order Type");
        jMenuItemDine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemDineActionPerformed(evt);
            }
        });
        MenuReports.add(jMenuItemDine);
        MenuReports.add(jSeparator13);

        jMenuBar1.add(MenuReports);

        MenuOrders.setText("Orders |");
        MenuOrders.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        MenuFindBill.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        MenuFindBill.setText("Search Order/Invoice");
        MenuFindBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuFindBillActionPerformed(evt);
            }
        });
        MenuOrders.add(MenuFindBill);
        MenuOrders.add(jSeparator8);

        MenuCancelOrder.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        MenuCancelOrder.setActionCommand("CancelOrder");
        MenuCancelOrder.setLabel("Cancel Order/Invoice");
        MenuCancelOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuCancelOrderActionPerformed(evt);
            }
        });
        MenuOrders.add(MenuCancelOrder);
        MenuOrders.add(jSeparator7);

        MenuOrdersList.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        MenuOrdersList.setLabel("List of Orders");
        MenuOrdersList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuOrdersListActionPerformed(evt);
            }
        });
        MenuOrders.add(MenuOrdersList);

        jMenuBar1.add(MenuOrders);

        MenuSetting.setText("Setting |");
        MenuSetting.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        MenuItemTax.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        MenuItemTax.setText("Update Tax");
        MenuItemTax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemTaxActionPerformed(evt);
            }
        });
        MenuSetting.add(MenuItemTax);
        MenuSetting.add(jSeparator9);

        MenuItemCurrency.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        MenuItemCurrency.setText("Update Currency");
        MenuItemCurrency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemCurrencyActionPerformed(evt);
            }
        });
        MenuSetting.add(MenuItemCurrency);
        MenuSetting.add(jSeparator10);

        MenuItemBusiness.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        MenuItemBusiness.setText("Update Business Info");
        MenuItemBusiness.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuItemBusinessActionPerformed(evt);
            }
        });
        MenuSetting.add(MenuItemBusiness);
        MenuSetting.add(jSeparator14);

        jMenuTables.setText("Manage Tables");
        jMenuTables.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N

        jMenuItemAddTable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemAddTable.setText("Add Table");
        jMenuItemAddTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAddTableActionPerformed(evt);
            }
        });
        jMenuTables.add(jMenuItemAddTable);
        jMenuTables.add(jSeparator15);

        jMenuItemUpdateTable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemUpdateTable.setText("Tables List");
        jMenuItemUpdateTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemUpdateTableActionPerformed(evt);
            }
        });
        jMenuTables.add(jMenuItemUpdateTable);
        jMenuTables.add(jSeparator16);

        jMenuItemDeleteTable.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItemDeleteTable.setText("Delete Table");
        jMenuTables.add(jMenuItemDeleteTable);

        MenuSetting.add(jMenuTables);

        jMenuBar1.add(MenuSetting);

        jMenuClose.setMnemonic('x');
        jMenuClose.setText("Close");
        jMenuClose.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        jMenuItemExit.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jMenuItemExit.setText("Exit");
        jMenuItemExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExitActionPerformed(evt);
            }
        });
        jMenuClose.add(jMenuItemExit);

        jMenuBar1.add(jMenuClose);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1)
                    .addComponent(jScrollPaneCatList, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ItemPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPaneJtable, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCustomerName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblOrderNo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOrderNo, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ItemPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtOrderNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblOrderNo)
                                    .addComponent(lblCustomerName)
                                    .addComponent(txtCustomerName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPaneJtable, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPaneCatList, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
   // get current date and set format
Image image = new ImageIcon("\\ePOS\\\\images\\eTech.png").getImage();
     //   Image icon = Toolkit.getDefaultToolkit().getImage("/MaharAccounting/src/Images/mtech.jpg");
//this.setIconImage(icon);
 this.setIconImage(image);

   conn=DbConnect.getConnection();
   java.util.Date curdate=new java.util.Date();
   formatter = new SimpleDateFormat("dd.MM.yyyy");
   String currentDate = formatter.format(curdate);
   this.txtDate.setText(currentDate);
    orderType="Dine In";
    this.currentCash();
   //calling method to generate new order number
     this.generateOrderNo();
  
 // setting column heading font style and size
JTableHeader tableHeader = jTableInvoice.getTableHeader();
Font headerFont = new Font("Arial", Font.BOLD, 12);
tableHeader.setFont(headerFont);

// getting table model & get columns to set columns size
    model = (DefaultTableModel)this.jTableInvoice.getModel();
   
      jTableInvoice.getColumnModel().getColumn(0).setPreferredWidth(120);
      jTableInvoice.getColumnModel().getColumn(1).setPreferredWidth(5);
      jTableInvoice.getColumnModel().getColumn(2).setPreferredWidth(4);
     
      jTableInvoice.getColumnModel().getColumn(3).setPreferredWidth(5);
      jTableInvoice.getColumnModel().getColumn(4).setPreferredWidth(3);
     
      try {
         vcatId="1";
         JlistAddElements();
         this.ItemButtons();
         this.JcomboAddElements();
     } catch (SQLException ex) {
         Logger.getLogger(PosScreen.class.getName()).log(Level.SEVERE, null, ex);
     }
         
         
    }//GEN-LAST:event_formComponentShown

    private void jList_categoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jList_categoryMouseClicked
  // get selected category id/value
        productSearchFlag=0; 
       listvalue=this.jList_category.getSelectedValue();
        //System.out.println(listvalue);
        
     try {
         getCatId();
         this.ItemButtons();
        // System.out.println(vid);
     } catch (SQLException ex) {
         Logger.getLogger(PosScreen.class.getName()).log(Level.SEVERE, null, ex); 
     }
    
    }//GEN-LAST:event_jList_categoryMouseClicked

    private void jList_categoryValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList_categoryValueChanged
        productSearchFlag=0;
        listvalue=this.jList_category.getSelectedValue();  
    
        try {
           getCatId();
           ItemButtons();
        // jPanelInJscrollButton.repaint();
     } catch (SQLException ex) {
         Logger.getLogger(PosScreen.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_jList_categoryValueChanged

    private void jTableInvoiceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTableInvoiceKeyReleased
      // get selected column if col=2 then calculate qty*price amount
      //  int col=this.jTableInvoice.getSelectedColumn();
        //System.out.println("col:"+col);
    //  if(col==2){
        //this.calculateAmount();
      //this.calculateTotal();
      //}
         int col=this.jTableInvoice.getSelectedColumn();
           int row=this.jTableInvoice.getSelectedRow();
           String qtyValue=(String) this.jTableInvoice.getValueAt(row, 2);
        int iqtyValue=Integer.valueOf(qtyValue);
        if(iqtyValue>=0){
        System.out.println("col:"+col);
      //if(col==2){
      this.calculateAmount();
             try {
                 this.calculateTotal();
             } catch (SQLException ex) {
                 Logger.getLogger(PosScreen.class.getName()).log(Level.SEVERE, null, ex);
             }
}//end if
        //   }   
    }//GEN-LAST:event_jTableInvoiceKeyReleased

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
     //cancel current input order
       this.resetTable();
        
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        // when click pay button then get value of all rows and 
        // insert order in database tables
         if(JOptionPane.showConfirmDialog(this,"Confirm..?" , "Save", 0)==0)
      {   
        int totalTableRows=model.getRowCount();
        String[] products=new String[totalTableRows];
        String[] qty=new String[totalTableRows];
        String[] price=new String[totalTableRows];
        double[] amount=new double[totalTableRows];
        int index=0;
     
     try {
         //insert order in master order table
         this.insertOrder();
     } catch (ParseException ex) {
         Logger.getLogger(PosScreen.class.getName()).log(Level.SEVERE, null, ex);
     }
     // access all table rows array and insert into detail order table
         while(index<totalTableRows)
         {
              
          products[index]= (String) model.getValueAt(index,0);
          
          int length=products[index].indexOf("-");
          products[index]=products[index].substring(0, length); 
          price[index]= (String) model.getValueAt(index,1);
          qty[index]= (String) model.getValueAt(index,2);
          
          amount[index]= (Double) model.getValueAt(index,3);
          
          System.out.println(products[index]+ " "+qty[index]+" "+price[index]+" "+amount[index]);
          index++;
         
         }// while
         Order orderDetail=new Order();    
     try {
         orderDetail.setOrderId(this.txtOrderNo.getText());
        //call method from Order class to insert detail order
         orderDetail.insertDetailOrder(products, qty, price, amount, totalTableRows);
         
     } catch (SQLException ex) {
         Logger.getLogger(PosScreen.class.getName()).log(Level.SEVERE, null, ex);
     }
     
       if(this.jRadioButtonDineInn.isSelected())
      {
        printerBill();
      }//end if
      if(this.jRadioButtonTakeAway.isSelected())
      {
      this.printerBillTakeAway();
      }//end if
         
     this.resetTable();
     currentCash();
    }//GEN-LAST:event_btnPayActionPerformed
    }//closing method
    
    private void jTableInvoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableInvoiceMouseClicked
    //get selected row and column when mouse clicked on table
    crow=this.jTableInvoice.getSelectedRow();
    ccol=this.jTableInvoice.getSelectedColumn();
       
    System.out.println("row & col:"+crow+ccol);
    
    this.setSelectedRowColumn(crow,ccol);
    if(ccol==2)
    {
        setQty();
    }
    //  this.jDialogQty.setSize(150, 200);
     // this.jDialogQty.setLocation(1100, 150);
      //this.jDialogQty.setVisible(true);
   /*
      QtyDialog qtyDialog=new QtyDialog();
      qtyDialog.setVisible(true);
      qtyDialog.qtyButtons();
      qtyDialog.buttonPane.setVisible(true);
      qtyDialog.setLocation(1100, 150);
     */
     
     
    }//GEN-LAST:event_jTableInvoiceMouseClicked
   
      public int[] setSelectedRowColumn(int row,int col)
    {  
        this.rowcolumn[0]=row;
        this.rowcolumn[1]=col;
        System.out.println("set row:"+rowcolumn[0]+"set col:"+rowcolumn[1]);
    return rowcolumn;
    }
    private void MenuAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuAddItemActionPerformed
        // TODO add your handling code here:
        new AddMasterProduct().setVisible(true);
    }//GEN-LAST:event_MenuAddItemActionPerformed

    private void MenuUpdateItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuUpdateItemActionPerformed
        // TODO add your handling code here:
        new UpdateMasterProduct().setVisible(true);
    }//GEN-LAST:event_MenuUpdateItemActionPerformed

    private void MenuItemAddCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemAddCatActionPerformed
        // TODO add your handling code here:
        new AddCategory().setVisible(true);
    }//GEN-LAST:event_MenuItemAddCatActionPerformed

    private void btnQtyApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQtyApplyActionPerformed
        // TODO add your handling code here:
         int r=this.jTableInvoice.getSelectedRow();
         String qty=this.jSpinner1.getValue().toString();
    
        this.jTableInvoice.setValueAt(qty, r, 2);
        this.calculateAmount();
     try {
         this.calculateTotal();
     } catch (SQLException ex) {
         Logger.getLogger(PosScreen.class.getName()).log(Level.SEVERE, null, ex);
     }
        this.jDialogQty.dispose();
    }//GEN-LAST:event_btnQtyApplyActionPerformed

    private void btnQtyCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQtyCancelActionPerformed
        // TODO add your handling code here:
        this.jDialogQty.dispose();
    }//GEN-LAST:event_btnQtyCancelActionPerformed

    private void txtitemsearchKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtitemsearchKeyPressed
        // TODO add your handling code here:
          if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
             searchProductByInput();
   }//end if  
    }// END OFMETHOD
 //search product by search text box
 public void searchProductByInput()
 {
   productSearchFlag=1;   
    this.txtitemsearch.setText(this.txtitemsearch.getText().toUpperCase());
             try {
                  ItemButtons();
              } catch (SQLException ex) {
                  Logger.getLogger(PosScreen.class.getName()).log(Level.SEVERE, null, ex);
              }
                System.out.println(productSearchFlag);
                
    }//GEN-LAST:event_txtitemsearchKeyPressed

    private void txtitemsearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtitemsearchKeyReleased
        // TODO add your handling code here:
        this.searchProductByInput();
    }//GEN-LAST:event_txtitemsearchKeyReleased

    private void MenuFindBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuFindBillActionPerformed
        // TODO add your handling code here:
         new SearchOrder().setVisible(true);
    }//GEN-LAST:event_MenuFindBillActionPerformed

    private void MenuItemBusinessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemBusinessActionPerformed
        // TODO add your handling code here:
        new UpdateCompanyForm().setVisible(true);
    }//GEN-LAST:event_MenuItemBusinessActionPerformed

    private void MenuUpdateCatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuUpdateCatActionPerformed
        // TODO add your handling code here:
        new UpdateCategoryForm().setVisible(true);
    }//GEN-LAST:event_MenuUpdateCatActionPerformed

    private void MenuItemCurrencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemCurrencyActionPerformed
        // TODO add your handling code here:
        new UpdateCurrencyForm().setVisible(true);
    }//GEN-LAST:event_MenuItemCurrencyActionPerformed

    private void MenuItemTaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuItemTaxActionPerformed
        // TODO add your handling code here:
        new UpdateTaxForm().setVisible(true);
    }//GEN-LAST:event_MenuItemTaxActionPerformed

    private void jMenuItem_salesReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_salesReportActionPerformed
        // TODO add your handling code here:
         new SalesReport().setVisible(true);
    }//GEN-LAST:event_jMenuItem_salesReportActionPerformed

    private void jMenuItemExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExitActionPerformed
        // TODO add your handling code here:
       
            int result = JOptionPane.showConfirmDialog(this,"Close ?", "Closing",
               JOptionPane.YES_NO_OPTION,
               JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_OPTION){
               this.dispose();
               new Login().setVisible(true);
               }
         
        
    }//GEN-LAST:event_jMenuItemExitActionPerformed

    private void jRadioButtonDineInnStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jRadioButtonDineInnStateChanged
        // TODO add your handling code here:
      if(this.jRadioButtonDineInn.isSelected())
      {
      
      }
      
    }//GEN-LAST:event_jRadioButtonDineInnStateChanged

    private void jRadioButtonDineInnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonDineInnActionPerformed
        // TODO add your handling code here:
        if(this.jRadioButtonDineInn.isSelected())
      {
        this.comboTablesList.setVisible(true);
      this.comboTablesList.setEnabled(true);
      orderType="Dine In";
      }
    }//GEN-LAST:event_jRadioButtonDineInnActionPerformed

    private void jRadioButtonTakeAwayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonTakeAwayActionPerformed
        // TODO add your handling code here:
         if(this.jRadioButtonTakeAway.isSelected())
      {
      this.comboTablesList.setEnabled(false);
      this.comboTablesList.setVisible(false);
      orderType="Take Away";
      }
                                                       
    }//GEN-LAST:event_jRadioButtonTakeAwayActionPerformed

    private void jMenuItemAddTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAddTableActionPerformed
        // TODO add your handling code here:
         new AddTable().setVisible(true);
    }//GEN-LAST:event_jMenuItemAddTableActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        this.comboTablesList.removeAllItems();
     try {
         this.JcomboAddElements();
          getCatId();
           ItemButtons();
     } catch (SQLException ex) {
         Logger.getLogger(PosScreen.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void jMenuItemUpdateTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemUpdateTableActionPerformed
        // TODO add your handling code here:
        new UpdateTables().setVisible(true);
    }//GEN-LAST:event_jMenuItemUpdateTableActionPerformed

    private void jMenuItemCatgListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCatgListActionPerformed
        // TODO add your handling code here:
         

        String jrxmlFile = "\\ePOS\\src\\main\\java\\com\\pos\\menu\\reports\\CategoryList.jrxml";
        
        HashMap param = new HashMap();
        
        PrintReport reportview = new PrintReport();
        reportview.viewReport(jrxmlFile, null, conn);

    
    }//GEN-LAST:event_jMenuItemCatgListActionPerformed

    private void jMenuItem_product_salesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem_product_salesActionPerformed
        // TODO add your handling code here:
        new SalesReportByProduct().setVisible(true);
    }//GEN-LAST:event_jMenuItem_product_salesActionPerformed

    private void MenuOrdersListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuOrdersListActionPerformed
        // TODO add your handling code here:
        new OrdersList().setVisible(true);
    }//GEN-LAST:event_MenuOrdersListActionPerformed

    private void jMenuItemDineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemDineActionPerformed
        // TODO add your handling code here:
        new SalesReportOrderType().setVisible(true);
    }//GEN-LAST:event_jMenuItemDineActionPerformed

    private void MenuCancelOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuCancelOrderActionPerformed
        // TODO add your handling code here:
        new CancelOrder().setVisible(true);
    }//GEN-LAST:event_MenuCancelOrderActionPerformed

    private void jMenuItemProductListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemProductListActionPerformed
        // TODO add your handling code here:
        String jrxmlFile = "\\ePOS\\src\\main\\java\\com\\pos\\menu\\reports\\ProductList.jrxml";
        
        HashMap param = new HashMap();
        
        PrintReport reportview = new PrintReport();
        reportview.viewReport(jrxmlFile, null, conn);

    }//GEN-LAST:event_jMenuItemProductListActionPerformed
    
 //REMOVE ALL TABLE ROWS
 public void removeAllRows(){
        int countRows=0;
        countRows=model.getRowCount();
         for (int i=countRows-1;i>=0;i--)
        {
        model.removeRow(i);
       
        
        }
    } //closing method remobeAllRows()
   
    // method to access new generated order
    private void generateOrderNo(){
        try {
         String billNo=new com.pos.menu.order.Order().genrateOrderNo();
         this.txtOrderNo.setText(billNo);
     } catch (SQLException ex) {
         Logger.getLogger(PosScreen.class.getName()).log(Level.SEVERE, null, ex);
     }
    }
    // method to insert Master order
    private void insertOrder() throws ParseException
    {
    Order order=new Order();
    order.setOrderId(this.txtOrderNo.getText().toUpperCase());
    order.setOrderDate(this.txtDate.getText().toUpperCase());
    order.setOrderSalesTax(this.txtTax.getText().toUpperCase());
    order.setOrderType(orderType);
    order.setTableName(this.comboTablesList.getSelectedItem().toString());
    order.setCustomerName(this.txtCustomerName.getText());
    order.insertMasterOrder();
    
    }
    private void printBill()
    {
    String jrxmlFile = "\\ePOS\\src\\main\\java\\com\\pos\\menu\\reports\\PrintBill.jrxml";
   //String myreport="./src/main/java/myreport/PrintBill.jrxml";
      // String myfile="/PrintBill.jrxml";
        String orderNo=this.txtOrderNo.getText();
         HashMap param=new HashMap();
         param.put("p_orderid",orderNo);
         PrintReport reportview=new PrintReport();
         reportview.viewReport(jrxmlFile, param, conn);
    }
     private void printBillTakeAway()
    {
    String jrxmlFile = "\\ePOS\\src\\main\\java\\com\\pos\\menu\\reports\\PrintBillTakeAway.jrxml";
   //String myreport="./src/main/java/myreport/PrintBill.jrxml";
      // String myfile="/PrintBill.jrxml";
        String orderNo=this.txtOrderNo.getText();
         HashMap param=new HashMap();
         param.put("p_orderid",orderNo);
         PrintReport reportview=new PrintReport();
         reportview.viewReport(jrxmlFile, param, conn);
    }
    private void printerBill()
    {
      String myfile="\\ePOS\\src\\main\\java\\com\\pos\\menu\\reports\\PrintBill.jrxml";
        String orderNo=this.txtOrderNo.getText();
         HashMap param=new HashMap();
         param.put("p_orderid",orderNo);
         //PrintReport reportview=new PrintReport();
         //reportview.viewReport(myfile, param, conn);
        new ReportPrinter(myfile, param, conn);
    }
    
     private void printerBillTakeAway()
    {
      String myfile="\\ePOS\\src\\main\\java\\com\\pos\\menu\\reports\\PrintBillTakeAway.jrxml";
        String orderNo=this.txtOrderNo.getText();
         HashMap param=new HashMap();
         param.put("p_orderid",orderNo);
         //PrintReport reportview=new PrintReport();
         //reportview.viewReport(myfile, param, conn);
        new ReportPrinter(myfile, param, conn);
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
            java.util.logging.Logger.getLogger(PosScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PosScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PosScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PosScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
         conn=DbConnect.getConnection();
         
         
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PosScreen().setVisible(true);
            }
        });
        
          }
    // Items buttons to show item image , name etc on POS Screen
     public void ItemButtons() throws SQLException
   { 
       String[][] vproductInfo=null;
       ImageIcon[] vproductImage=null;
       FetchProducts products=new FetchProducts();
       FetchProductsBySearch productsSearch=new FetchProductsBySearch();
       //find total products of selected category
       int numOfButtons=products.getNumberOfProducts(vcatId);
       // get product information from database using FetchProducts class    
        buttons=products.getNumberOfProducts(vcatId);
        // Find products by search box
        if (productSearchFlag==1){
             
            String txtproductId=this.txtitemsearch.getText();
            numOfButtons=productsSearch.getNumberOfProductsBySearch(txtproductId);
            buttons=productsSearch.getNumberOfProductsBySearch(txtproductId);
            vproductInfo=productsSearch.getProductInfoBySearch(txtproductId);
            vproductImage=productsSearch.getProductImageBySearch(txtproductId);
        }
        
        else{
            vproductInfo=products.getProductInfo(vcatId);
            vproductImage=products.getProductImage(vcatId);
        } //end else
         
        
       // get currency sign
       currencySign= products.getCurrency();
       //initialize buttons on number of products in selected category
       btnarray = new JButton[numOfButtons];
             
             //set grid layout 4 buttons per row
             jPanelInJscrollButton.setLayout(new GridLayout(0,4));
             //remove all buttons from the grid
             jPanelInJscrollButton.removeAll();
             //main.setBounds(350,250,350,350);
             //main.setResizable(true);
           itemID=new String[numOfButtons];
           itemName=new String[numOfButtons];
           itemSize=new String[numOfButtons];
           itemPrice=new String[numOfButtons];
             //set label on buttons
              for (int i = 0; i <numOfButtons ; i++)
             	{ int counter=i;
                    //get product image according to number of products
                    ImageIcon icon=vproductImage[i];
                    Image img=icon.getImage();
                    Image newicon = img.getScaledInstance( 120, 70,  java.awt.Image.SCALE_SMOOTH ) ; 
                   //store product inform into variables
                    itemID[i]=vproductInfo[i][0];
                    itemName[i]=vproductInfo[i][1];
                    itemSize[i]=vproductInfo[i][2];
                    itemPrice[i]=vproductInfo[i][3];
                  //get product info into string for button label  
                   String buttonlabel=vproductInfo[i][0]+"-"+vproductInfo[i][1]+"-"+vproductInfo[i][2]+
                           "-"+currencySign+vproductInfo[i][3];
                   
                //set product infor as label on buttons   
                btnarray[i] = new JButton(buttonlabel,icon);
              //  btnarray[i] = new JButton("<html>"+buttonlabel.replaceAll("\\-","<br>")+"</html>",icon);
                
              //  btnarray[i].setHorizontalAlignment(SwingConstants.CENTER);
                //set image of product on buttons
                btnarray[i].setIcon(new ImageIcon(newicon));
                // resize product buttons size
                btnarray[i].setPreferredSize(new Dimension(100, 100));
               // set button label text at bottom and center of button
                btnarray[i].setVerticalTextPosition(SwingConstants.BOTTOM);
                btnarray[i].setHorizontalTextPosition(SwingConstants.CENTER);
                //add button into Jpanel
                
                jPanelInJscrollButton.add(btnarray[i]);
                jPanelInJscrollButton.repaint();
                jPanelInJscrollButton.validate();
             //Add action listener to button
              btnarray[i].addActionListener(new ActionListener()
        	{
             // action on when button pressed
             public void actionPerformed(ActionEvent g)
            {
                //Execute when button is pressed
                addProducttoJtable();
                String buttonText = g.getActionCommand();
                int length=buttonText.indexOf("-");
                System.out.println("You clicked the button:"+buttonText);
                String productid=buttonText.substring(0, length); 
               
                String[] product;
                 try {
                     product=products.getProductRow(productid);
                     model.setValueAt(product[0]+"-"+product[1], tableinputrow, 0);
                     model.setValueAt(product[3],tableinputrow, 1);
                     model.setValueAt("1",tableinputrow, 2);
                    //calculate amount on selection of item to table
                    String vprice=(String) model.getValueAt(tableinputrow,1);
                     String vqty=(String) model.getValueAt(tableinputrow,2);
                     
                     vamount=(Double.parseDouble(vqty)*Double.parseDouble(vprice));
                      model.setValueAt(vamount,tableinputrow, 3);
                 } catch (SQLException ex) {
                     Logger.getLogger(PosScreen.class.getName()).log(Level.SEVERE, null, ex);
                 }
                  vnumberOfRows=model.getRowCount();
                  System.out.println("number of rows"+ vnumberOfRows);
                tableinputrow++;
                 
                 try {
                     calculateTotal();
                 } catch (SQLException ex) {
                     Logger.getLogger(PosScreen.class.getName()).log(Level.SEVERE, null, ex);
                 }
            } // end of actionPerfomed/event             
          
                }); // end of action listener
        btnarray[i].addMouseListener(new MouseAdapter()
        	{
                 
        @Override
        public void mouseEntered(MouseEvent e)
        {
         
       //dialog to show item information on mouse over     
         jDialog2.setLocation(10, 400);
         jDialog2.setSize(200, 250);
         dtxtId.setText(itemID[counter]);
         dtxtItem.setText(itemName[counter]);
         dtxtSize.setText(itemSize[counter]);
         dtxtPrice.setText(currencySign+itemPrice[counter]);
        
//         ProductInfo=btnarray[i].getText();
            jDialog2.show();
        }
          public void mouseExited(MouseEvent e)
        {
           jDialog2.dispose();
        }           
                });
             
          }//end for loop
          
           
      } //end itembuttons
     
     // adding elements(category names) in jlist 
     public void JlistAddElements() throws SQLException
     {
       //creating object of class QueryCatJList
       QueryCatJlist q=new  QueryCatJlist();
       // getting category names and storing in ItemCatList
       String[] ItemCatList=q.GetCatList();
       //setting jList model
       this.jList_category.setModel(listModel);
       //finding number of items in list/length
       int len=ItemCatList.length;
      //adding elements/category in jlist 
        for(int i=0;i<=len-1;i++)
        {
         listModel.addElement(ItemCatList[i]);
        }//end for
     } // method JlistAddElement
  
     //method to get category id on selection of category name in list
  public void getCatId() throws SQLException
  { 
      Statement st1=conn.createStatement();
    String sqlselect="select category_id from category where category_name='"+listvalue+"'";
     ResultSet rs=st1.executeQuery(sqlselect);
      while (rs.next())
        {
        vcatId= rs.getString("category_id");
        //System.out.println("Total Rows "+n);}
        
        }
     
  }//closing getCatId()
  public void addProducttoJtable()
  {
   model.addRow(new Object[rows]);
   rows++;
       
  }
  // method to calculate qty*price (amount)
 public void calculateAmount()
 {
              int row=this.jTableInvoice.getSelectedRow();
              String vprice=(String) model.getValueAt(row,1);
              String vqty=(String) model.getValueAt(row,2);      
               vamount=(Double.parseDouble(vqty)*Double.parseDouble(vprice));
               model.setValueAt(vamount,row, 3);
     
 } //closing calculateAmount()
 
 // calculate grand total of all items
 public void  calculateTotal() throws SQLException
 { double amount=0.0, vtaxRate=0.0,vTaxAmount=0.0;
   double  total=0,gtotal=0.0;
  
    for (int row=0;row<vnumberOfRows;row++)
    {    amount=(Double) model.getValueAt(row, 3);
        
         total=total+amount;
         
    }//end for loop row
    this.txtBillTotal.setText(Double.toString(total));
    this.lblCurrency.setText(currencySign);
    vtaxRate=Double.parseDouble(Tax.getTax());
    vTaxAmount=(vtaxRate*total)/100;
    this.txtTax.setText(Double.toString(vTaxAmount));
    gtotal=(total+vTaxAmount);
    this.txtGrandTotal.setText(Double.toString(gtotal));
 } //end calculateTotal
 
 private void setQty()    
 {      
     int r=this.jTableInvoice.getSelectedRow();
     //int c=this.jTableInvoice.getSelectedColumn();
     String itemDescription=(String) this.jTableInvoice.getValueAt(r, 0);
     this.jDialogQty.setTitle("Qty for: "+itemDescription);
     this.jDialogQty.setSize(180, 120);
     this.jDialogQty.setLocation(900, 350);
     this.jDialogQty.show();
     this.jSpinner1.setValue(1);
 }
 private void resetTable()
 {
        removeAllRows();
        tableinputrow=0;vnumberOfRows=0;vamount=0;
        this.txtBillTotal.setText("0");
        this.txtTax.setText("0");
        this.txtGrandTotal.setText("0");
      this.generateOrderNo();
 }//end of method resetTable
 
 
     public void JcomboAddElements() throws SQLException
     {DefaultComboBoxModel tablesComboModel = new DefaultComboBoxModel();
     conn=DbConnect.getConnection();
       //creating object of class QueryCatJList
       QueryTableList q=new  QueryTableList();
       // getting category names and storing in ItemCatList
       String[] ItemTableList=q.GetTablesList();
       //setting jList model
       this.comboTablesList.setModel(tablesComboModel);
       //finding number of items in list/length
       int len=ItemTableList.length;
      //adding elements/category in jlist 
        for(int i=0;i<=len-1;i++)
        {
         tablesComboModel.addElement(ItemTableList[i]);
        }//end for
     } // method JlistAddElement
   private void currentCash()
   {
     CashCalculation cash=new CashCalculation();
     
     try {
        String orderDate= cash.setDateFormat(this.txtDate.getText());
        Double amount=cash.cashAmount(orderDate);
        this.txtCashSales.setText(amount.toString());
        Double taxAmount=cash.taxAmount(orderDate);
        this.txtTaxAmount.setText(taxAmount.toString());
        Double netCash=(amount+taxAmount);
        this.txtNetCash.setText(netCash.toString());
     } catch (SQLException ex) {
         Logger.getLogger(PosScreen.class.getName()).log(Level.SEVERE, null, ex);
     }
   }// ending method
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ItemPanel;
    private javax.swing.JMenuItem MenuAddItem;
    private javax.swing.JMenuItem MenuCancelOrder;
    private javax.swing.JMenu MenuCat;
    private javax.swing.JMenuItem MenuDeleteItem;
    private javax.swing.JMenuItem MenuFindBill;
    private javax.swing.JMenuItem MenuItemAddCat;
    private javax.swing.JMenuItem MenuItemBusiness;
    private javax.swing.JMenuItem MenuItemCurrency;
    private javax.swing.JMenuItem MenuItemTax;
    private javax.swing.JMenu MenuOrders;
    private javax.swing.JMenuItem MenuOrdersList;
    private javax.swing.JMenu MenuReports;
    private javax.swing.JMenu MenuSetting;
    private javax.swing.JMenuItem MenuUpdateCat;
    private javax.swing.JMenuItem MenuUpdateItem;
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnQtyApply;
    private javax.swing.JButton btnQtyCancel;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JComboBox<String> comboTablesList;
    private javax.swing.JTextField dtxtId;
    private javax.swing.JTextArea dtxtItem;
    private javax.swing.JTextField dtxtPrice;
    private javax.swing.JTextField dtxtSize;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JDialog jDialogQty;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList_category;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu jMenuClose;
    private javax.swing.JMenuItem jMenuItemAddTable;
    private javax.swing.JMenuItem jMenuItemCatgList;
    private javax.swing.JMenuItem jMenuItemDeleteTable;
    private javax.swing.JMenuItem jMenuItemDine;
    private javax.swing.JMenuItem jMenuItemExit;
    private javax.swing.JMenuItem jMenuItemProductList;
    private javax.swing.JMenuItem jMenuItemUpdateTable;
    private javax.swing.JMenuItem jMenuItem_product_sales;
    private javax.swing.JMenuItem jMenuItem_salesReport;
    private javax.swing.JMenu jMenuTables;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelInJscrollButton;
    private javax.swing.JPanel jPanelMain;
    private javax.swing.JPanel jPanel_Search;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButtonDineInn;
    private javax.swing.JRadioButton jRadioButtonTakeAway;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPaneButtons;
    private javax.swing.JScrollPane jScrollPaneCatList;
    private javax.swing.JScrollPane jScrollPaneJtable;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator10;
    private javax.swing.JPopupMenu.Separator jSeparator11;
    private javax.swing.JPopupMenu.Separator jSeparator12;
    private javax.swing.JPopupMenu.Separator jSeparator13;
    private javax.swing.JPopupMenu.Separator jSeparator14;
    private javax.swing.JPopupMenu.Separator jSeparator15;
    private javax.swing.JPopupMenu.Separator jSeparator16;
    private javax.swing.JPopupMenu.Separator jSeparator17;
    private javax.swing.JPopupMenu.Separator jSeparator18;
    private javax.swing.JPopupMenu.Separator jSeparator19;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JPopupMenu.Separator jSeparator7;
    private javax.swing.JPopupMenu.Separator jSeparator8;
    private javax.swing.JPopupMenu.Separator jSeparator9;
    private javax.swing.JSpinner jSpinner1;
    public javax.swing.JTable jTableInvoice;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblCurrency;
    private javax.swing.JLabel lblCustomerName;
    private javax.swing.JLabel lblOrderNo;
    private javax.swing.JLabel lblTax;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lbleTech;
    private javax.swing.ButtonGroup radioGroupOrderType;
    private javax.swing.JTextField txtBillTotal;
    private javax.swing.JTextField txtCashSales;
    private javax.swing.JTextField txtCustomerName;
    private javax.swing.JTextField txtDate;
    private javax.swing.JTextField txtGrandTotal;
    private javax.swing.JTextField txtNetCash;
    private javax.swing.JTextField txtOrderNo;
    private javax.swing.JTextField txtTax;
    private javax.swing.JTextField txtTaxAmount;
    private javax.swing.JTextField txtitemsearch;
    // End of variables declaration//GEN-END:variables
}
