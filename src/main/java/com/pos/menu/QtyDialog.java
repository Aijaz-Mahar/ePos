package com.pos.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

class QtyDialog extends JFrame {
    // class variables to use for rows and columns in jtable and integer buttons to count buttons

    public int qtyRow = 0, qtyCol = 0;

    QtyDialog() {

        this.setSize(150, 250);
        //this.setResizable(false);
        this.setVisible(true);
        //this.setState(QtyDialog.NORMAL);
    }
    private int buttons = 0;
    // creating jbutton arrays
    static JButton[] btnarray;
    String btnValue = "";
    JPanel buttonPane = new JPanel();
    JPanel txtPanel = new JPanel();
    JPanel okCancelPanel = new JPanel();
    JTextField txtQty = new JTextField();
    int btnOk = 0;

    public void qtyButtons() {
        //initialize buttons on number of products in selected category
        btnarray = new JButton[10];

        this.txtPanel.setLayout(new GridLayout(0, 1));
        txtPanel.add(txtQty);

        txtQty.setVisible(true);
        this.add(txtPanel, BorderLayout.NORTH);
        this.txtPanel.repaint();
        this.txtPanel.validate();

        //set grid layout 4 buttons per row
        this.buttonPane.setLayout(new GridLayout(0, 3));
        //remove all buttons from the grid

        //main.setBounds(350,250,350,350);
        //main.setResizable(true);
        //set label on buttons
        for (int i = 0; i < 10; i++) {
            String btnLabel = Integer.toString(i);
            btnarray[i] = new JButton(btnLabel);
            btnarray[i].setPreferredSize(new Dimension(50, 50));

            this.buttonPane.add(btnarray[i]);
            this.add(this.buttonPane);
            this.buttonPane.repaint();
            this.buttonPane.validate();
            //Add action listener to button
            btnarray[i].addActionListener(new ActionListener() {
                // action on when button pressed

                public void actionPerformed(ActionEvent g) {
                    //Execute when button is pressed

                    btnValue = g.getActionCommand();
                    setTxtQty();

                } // end of actionPerfomed/event

            });

        } //end for loop

        JButton[] btnOkCancel = new JButton[2];
        btnOkCancel[0] = new JButton("Ok");
        btnOkCancel[1] = new JButton("Cancel");
        btnOkCancel[0].setPreferredSize(new Dimension(75, 50));
        btnOkCancel[1].setPreferredSize(new Dimension(75, 50));
        this.okCancelPanel.setLayout(new GridLayout(0, 2));
        this.okCancelPanel.add(btnOkCancel[0]);
        this.okCancelPanel.add(btnOkCancel[1]);
        this.add(this.okCancelPanel, BorderLayout.SOUTH);
        this.okCancelPanel.repaint();
        this.okCancelPanel.validate();

        btnOkCancel[1].addActionListener(new ActionListener() {
            // action on when button pressed

            public void actionPerformed(ActionEvent eventCancel) {
                if (eventCancel.getSource().equals(btnOkCancel[1])) {
                    System.out.println("cancel pressed");
                    txtQty.setText("");

                }
            }//action formed
        });
        btnOkCancel[0].addActionListener(new ActionListener() {
            // action on when button pressed

            public void actionPerformed(ActionEvent eventOk) {
                if (eventOk.getSource().equals(btnOkCancel[0])) {
                    System.out.println("ok pressed");
                    String newQty = getProductQty();
                    //PosScreen posScreen=new PosScreen();

                    //int rr[]=posScreen.setSelectedRowColumn();
                    //  System.out.println("selected row column:"+rowcolumn[0]+" nd "+rowcolumn[1]);
                    //posScreen.jTableInvoice.setValueAt("100", 0, 2);
                }
            }//action formed
        });
    }

    public void setTxtQty() {
        String qty = txtQty.getText();
        qty = qty + btnValue;
        txtQty.setText(qty);
        System.out.println("You clicked the button:" + qty);

    }

    public String getProductQty() {
        String newQty = txtQty.getText();
        System.out.println("inner qty" + newQty);
        System.out.println("inner txt qty" + txtQty.getText());
        return newQty;
    }

    public void setQtyRowCol(int row, int col) {
        this.qtyRow = row;
        this.qtyRow = col;
        System.out.println(qtyRow + "qtyRowsCol " + qtyCol);
    }

}
