/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tour;

/**
 *
 * @author acer
 */

import database.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import tour.main;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;



public class tour_package_manage_in extends javax.swing.JInternalFrame {

    
     Connection con = null;
    PreparedStatement pst = null; 
    ResultSet rs = null ; 
    
    /**
     * Creates new form tour_package_manage_in
     */
    public tour_package_manage_in() {
        initComponents();
        
        
         con = DBconnect.connect();
        
        //load table 
        tableload();
        
    }
    
    
    
      public void tableload(){
        
        String sql = " select  package_ID ,name  , rate ,type ,description  from package "  ;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField5 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton5 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(51, 0, 204));
        jPanel3.setLayout(null);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tuor_image/icon/Untitled-12.jpg"))); // NOI18N
        jLabel5.setText("next");
        jLabel5.setOpaque(true);
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel5);
        jLabel5.setBounds(790, 400, 220, 160);

        jTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.setRowHeight(20);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jPanel3.add(jScrollPane2);
        jScrollPane2.setBounds(310, 160, 730, 220);

        jTextField5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField5MouseClicked(evt);
            }
        });
        jPanel3.add(jTextField5);
        jTextField5.setBounds(360, 60, 320, 30);

        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);
        jButton3.setBounds(710, 60, 80, 30);

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tuor_image/icon/Untitled-10.jpg"))); // NOI18N
        jLabel10.setOpaque(true);
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel10);
        jLabel10.setBounds(320, 400, 210, 160);

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tuor_image/icon/Untitled-11.jpg"))); // NOI18N
        jLabel11.setOpaque(true);
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel11);
        jLabel11.setBounds(560, 400, 200, 160);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(null);

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Type  ");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 280, 60, 29);

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(0, 51, 51));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jComboBox1.setOpaque(false);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(140, 220, 150, 30);

        jToggleButton1.setText("Delete");
        jToggleButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jToggleButton1MouseClicked(evt);
            }
        });
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jToggleButton1);
        jToggleButton1.setBounds(210, 490, 90, 30);

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(110, 490, 90, 30);

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Description ");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 350, 100, 20);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Rate  ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 220, 60, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name  ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 160, 60, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ID");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(30, 120, 40, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel7);
        jLabel7.setBounds(140, 120, 150, 30);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("Details ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(150, 20, 430, 50);

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 204));
        jLabel12.setText("Package ");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(10, 20, 140, 50);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(140, 340, 150, 96);

        jButton5.setText("Add");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(10, 490, 90, 30);
        jPanel1.add(jTextField1);
        jTextField1.setBounds(140, 160, 150, 30);
        jPanel1.add(jTextField2);
        jTextField2.setBounds(140, 280, 150, 30);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(0, 80, 200, 20);

        jPanel3.add(jPanel1);
        jPanel1.setBounds(0, 0, 310, 730);

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("jLabel9");
        jLabel9.setOpaque(true);
        jPanel3.add(jLabel9);
        jLabel9.setBounds(830, 10, 180, 110);

        jButton4.setText("Add Image");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);
        jButton4.setBounds(830, 130, 180, 20);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(0, 0, 1040, 870);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1040, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int x =  JOptionPane.showConfirmDialog(null,"Do you want to Update" );

        if (x==0 ) {

            try {
                String Uid  = jLabel7.getText();

                String it160_Uname = jTextField1.getText() ;
                String it160_Urate = jComboBox1.getSelectedItem().toString();
                String it160_Utype = jTextField2.getText();
                String it160_Udis = jTextArea1.getText();

                String Update_sql = "update package set name='"+ it160_Uname+"' , rate ='"+it160_Urate +"' , type ='"+it160_Utype +"' , description ='"+it160_Udis+"'  where package_ID = '"+Uid+"'";

                pst = con.prepareStatement(Update_sql);
                pst.execute() ;
                tableload();

            }
            catch (SQLException ex) {
                System.out.println(ex) ;
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jToggleButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jToggleButton1MouseClicked

        int x =  JOptionPane.showConfirmDialog(null,"Do you want to delete  " );

        if (x==0 ) {
            try {
                String package_id = jLabel7.getText();
                String delete_sql = "delete from package where package_ID ='"+package_id+"' " ;
                pst = con.prepareStatement(delete_sql);
                pst.execute() ;
                tableload();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

        // TODO add your handling code here:

    }//GEN-LAST:event_jToggleButton1MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

         int r = jTable1.getSelectedRow();
        String id = jTable1.getValueAt(r,0).toString();
        String name = jTable1.getValueAt(r,1).toString();
         
        String rate  = jTable1.getValueAt(r,2).toString();
        String type  = jTable1.getValueAt(r,3).toString();
        String description   = jTable1.getValueAt(r,4).toString();
        
        jTextField1.setText(name);
        jTextField2.setText(type);
        jTextArea1.setText(description);
        jComboBox1.setSelectedItem(rate );
        jLabel7.setText(id);



        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked

                      tour_package_package_in pe = new tour_package_package_in();                         
                    JDesktopPane n =getDesktopPane();
                    n.add(pe);
                    pe.show();
                    this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String Sname= jTextField5.getText();
         String sql = " select  package_ID ,name  , rate ,type ,description  from package  where name like  '%"+Sname+"%'"  ;
        
         try {
              pst = con.prepareStatement(sql);
             rs = pst.executeQuery();
              jTable1.setModel(DbUtils.resultSetToTableModel(rs));
             
         } catch (SQLException ex) {
             Logger.getLogger(tour_package_manage_in.class.getName()).log(Level.SEVERE, null, ex);
         }
            
           


        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked

        tour_package_list_ln pl = new tour_package_list_ln();                         
                    JDesktopPane n =getDesktopPane();
                    n.add(pl);
                    pl.show();
        


        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    int clickCount = 0 ; 
    
    private void jTextField5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField5MouseClicked
      
        
        if(clickCount ==0){
        
    JFrame parent = new JFrame();

    JOptionPane.showMessageDialog(parent, "If you need to search a package  ... \n" + "Enter your package name");        
        }
        clickCount++;
            

// TODO add your handling code here:
    }//GEN-LAST:event_jTextField5MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked

         String it160_name = jTextField1.getText() ;
        String it160_rate = jComboBox1.getSelectedItem().toString();
        String it160_type = jTextField2.getText();
        String it160_dis = jTextArea1.getText();

        System.out.println(it160_name);

        try {
            String it160_g = "INSERT INTO package (name,rate,type,description ) values ('"+it160_name+"','"+it160_rate+"','"+it160_type+"','"+it160_dis+"')";
            pst =con.prepareStatement(it160_g);
            pst.execute();

            //load table
            tableload();
            // TODO add your handling code here:
        } catch (SQLException ex) {
            System.out.println(ex);
        }



        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MouseClicked

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked

        


        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
