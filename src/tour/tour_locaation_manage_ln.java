/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tour;
import database.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author acer
 */
public class tour_locaation_manage_ln extends javax.swing.JInternalFrame {

    /**
     * Creates new form tour_locaation_manage_ln
     */
      Connection con = null;
    PreparedStatement pst = null; 
    ResultSet rs = null ; 
    
    public tour_locaation_manage_ln() {
        initComponents();
          con = DBconnect.connect();
        tableload();
    }

    
    
    
      public void tableload(){
        
        String sql = " select  place_id  ,name  , type,rate , cost ,description  from place "  ;
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField6 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jButton4 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));
        jPanel2.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(100, 90, 190, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Type");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 200, 70, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Rate");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 260, 60, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Cost");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 300, 70, 40);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBox1);
        jComboBox1.setBounds(100, 250, 190, 30);

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2);
        jTextField2.setBounds(100, 140, 190, 30);
        jPanel1.add(jTextField3);
        jTextField3.setBounds(100, 200, 190, 30);
        jPanel1.add(jTextField4);
        jTextField4.setBounds(100, 300, 190, 30);

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(100, 520, 90, 30);

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(200, 520, 90, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Name");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 130, 70, 40);

        jButton3.setText("Add");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(0, 520, 90, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Description");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 420, 130, 40);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("ID");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(10, 90, 70, 20);
        jPanel1.add(jSeparator2);
        jSeparator2.setBounds(0, 80, 200, 10);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(100, 360, 190, 96);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setText("Manage Locations ");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 20, 310, 40);

        jPanel2.add(jPanel1);
        jPanel1.setBounds(0, 0, 310, 790);

        jLabel10.setBackground(new java.awt.Color(0, 51, 51));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tuor_image/icon/Untitled-17.jpg"))); // NOI18N
        jLabel10.setText("jLabel6");
        jLabel10.setOpaque(true);
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel10);
        jLabel10.setBounds(800, 420, 220, 170);

        jLabel11.setBackground(new java.awt.Color(0, 51, 51));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tuor_image/icon/Untitled-10.jpg"))); // NOI18N
        jLabel11.setText("jLabel6");
        jLabel11.setOpaque(true);
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel11);
        jLabel11.setBounds(320, 420, 220, 170);

        jLabel12.setBackground(new java.awt.Color(0, 51, 51));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tuor_image/icon/Untitled-16.jpg"))); // NOI18N
        jLabel12.setText("jLabel6");
        jLabel12.setOpaque(true);
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel12);
        jLabel12.setBounds(560, 420, 220, 170);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jTable1.setCellSelectionEnabled(true);
        jTable1.setName(""); // NOI18N
        jTable1.setRowHeight(20);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(310, 170, 730, 220);

        jTextField6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField6MouseClicked(evt);
            }
        });
        jPanel2.add(jTextField6);
        jTextField6.setBounds(370, 90, 300, 30);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(490, 140, 0, 2);

        jButton4.setText("Search");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(690, 90, 80, 30);

        jLabel14.setBackground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("jLabel14");
        jLabel14.setOpaque(true);
        jPanel2.add(jLabel14);
        jLabel14.setBounds(830, 20, 180, 110);

        jButton5.setText("Add Image");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);
        jButton5.setBounds(830, 140, 180, 20);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1032, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 743, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int r = jTable1.getSelectedRow();
        String id = jTable1.getValueAt(r,0).toString();
        String name = jTable1.getValueAt(r,1).toString();

        String type  = jTable1.getValueAt(r,2).toString();
        String rate  = jTable1.getValueAt(r,3).toString();
        String cost   = jTable1.getValueAt(r,4).toString();
        String description   = jTable1.getValueAt(r,5).toString();

        jLabel2.setText(id);
        jTextField2.setText(name);
        jTextField3.setText(type);
        jComboBox1.setSelectedItem(rate);
        jTextField4.setText(cost);
        jTextArea1.setText(description);
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked

        String it160_name = jTextField2.getText();
        String it160_type = jTextField3.getText();
        String it160_rate = jComboBox1.getSelectedItem().toString();
        String it160_cost = jTextField4.getText();
        String it160_description = jTextArea1.getText() ;

        String it160_g = "INSERT INTO place (name,type,rate,cost,description ) values ('"+it160_name+"','"+it160_type+"','"+it160_rate+"','"+it160_cost+"','"+it160_description+"')";
        try {
            pst =con.prepareStatement(it160_g);
            pst.execute();
            tableload();

            // TODO add your handling code here:
        } catch (SQLException ex) {
            System.out.println(ex);

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

       int x =  JOptionPane.showConfirmDialog(null,"Do you want to delete  " );

        if (x==0 ) {
            try {
                String package_id = jLabel2.getText();
                String delete_sql = "delete from place where place_id ='"+package_id+"' " ;
                pst = con.prepareStatement(delete_sql);
                pst.execute() ;
                tableload();
            } catch (SQLException ex) {
                 System.out.println(ex);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int x =  JOptionPane.showConfirmDialog(null,"Do you want to Update" );

        if (x==0 ) {

            try {
                String it160_Uid =  jLabel2.getText();
                String it160_Uname = jTextField2.getText();
                String it160_Utype = jTextField3.getText();
                String it160_Urate = jComboBox1.getSelectedItem().toString();
                String it160_Ucost = jTextField4.getText();
                String it160_Udescription = jTextArea1.getText() ;

                String Update_sql = "update place set name='"+ it160_Uname+"' , rate ='"+it160_Urate +"' , type ='"+it160_Utype +"' , cost = '"+it160_Ucost+"',description ='"+it160_Udescription+"'  where place_ID = '"+it160_Uid+"'";
                pst = con.prepareStatement(Update_sql);
                pst.execute() ;
                tableload();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked


            this.dispose();


        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked


            tour_vehicle_manage_ln mv = new tour_vehicle_manage_ln();
            
            JDesktopPane n =getDesktopPane();
                    n.add(mv);
                     mv.show();
                    this.dispose();

            
            
            
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked

        String Sname= jTextField6.getText();
        
        String sql = " select  place_id  ,name  , type,rate , cost ,description  from place where name like  '%"+Sname+"%' "  ;
         try {
              pst = con.prepareStatement(sql);
             rs = pst.executeQuery();
              jTable1.setModel(DbUtils.resultSetToTableModel(rs));
             
         } catch (SQLException ex) {
             Logger.getLogger(tour_package_manage_in.class.getName()).log(Level.SEVERE, null, ex);
         }
            


        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MouseClicked

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

 int    clickCount = 0 ; 
    
    private void jTextField6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField6MouseClicked


        if(clickCount ==0){
        
    JFrame parent = new JFrame();

    JOptionPane.showMessageDialog(parent, "If you need to search a location  ... \n" + "Enter your location name");        
        }
        clickCount++;
            


        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked



            tour_guider_manage_ln mv = new tour_guider_manage_ln();
            
            JDesktopPane n =getDesktopPane();
                    n.add(mv);
                     mv.show();
                    this.dispose();



        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}