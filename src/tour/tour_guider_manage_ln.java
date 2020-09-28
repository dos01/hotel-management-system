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
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class tour_guider_manage_ln extends javax.swing.JInternalFrame {

    
    
      Connection con = null;
    PreparedStatement pst = null; 
    ResultSet rs = null ; 
    
    /**
     * Creates new form tour_guider_manage_ln
     */
    public tour_guider_manage_ln() {
        initComponents();
        con = DBconnect.connect();
        tableload();
    }

    
    
    
    
      public void tableload(){
        
        String sql = " select  id ,name,type,rate,cost,specilify,comment,pat_cost,4n from guider "  ;
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 153));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 0, 51));
        jPanel2.setLayout(null);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jLabel16);
        jLabel16.setBounds(120, 80, 170, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jLabel1);
        jLabel1.setBounds(140, 100, 90, 0);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Comment");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 360, 90, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Guider ID  ");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 90, 110, 20);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Name      ");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(10, 130, 90, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Rate        ");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(10, 170, 90, 20);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1);
        jTextField1.setBounds(150, 500, 140, 30);
        jPanel2.add(jTextField3);
        jTextField3.setBounds(120, 130, 170, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Type       ");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(10, 210, 90, 20);
        jPanel2.add(jTextField5);
        jTextField5.setBounds(120, 210, 170, 30);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jComboBox1);
        jComboBox1.setBounds(120, 170, 170, 30);

        jButton1.setText("Delete");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(200, 560, 90, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Cost");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(10, 260, 90, 20);

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField6);
        jTextField6.setBounds(120, 250, 170, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Part Time Cost    ");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(10, 500, 130, 20);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(120, 340, 166, 96);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Speciality  ");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(10, 300, 100, 20);

        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField7);
        jTextField7.setBounds(120, 290, 170, 30);

        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField8);
        jTextField8.setBounds(150, 460, 140, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Phone Number ");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(10, 470, 130, 20);

        jButton4.setText("Add");
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(10, 560, 80, 30);

        jButton5.setText("Update");
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });
        jPanel2.add(jButton5);
        jButton5.setBounds(100, 560, 90, 30);

        jLabel17.setBackground(new java.awt.Color(204, 204, 204));
        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 204, 204));
        jLabel17.setText("Manage Guiders ");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(10, 20, 300, 40);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(0, 70, 160, 20);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, -10, 300, 740);

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
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(300, 160, 750, 240);

        jLabel11.setBackground(new java.awt.Color(0, 51, 51));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tuor_image/icon/Untitled-26.jpg"))); // NOI18N
        jLabel11.setText("jLabel6");
        jLabel11.setOpaque(true);
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel11);
        jLabel11.setBounds(810, 420, 220, 170);

        jLabel12.setBackground(new java.awt.Color(0, 51, 51));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tuor_image/icon/Untitled-10.jpg"))); // NOI18N
        jLabel12.setText("jLabel6");
        jLabel12.setOpaque(true);
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel12);
        jLabel12.setBounds(320, 420, 220, 170);

        jLabel13.setBackground(new java.awt.Color(0, 51, 51));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tuor_image/icon/Untitled-16.jpg"))); // NOI18N
        jLabel13.setText("jLabel6");
        jLabel13.setOpaque(true);
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel13);
        jLabel13.setBounds(560, 420, 220, 170);

        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextField2);
        jTextField2.setBounds(360, 90, 320, 30);

        jLabel15.setBackground(new java.awt.Color(0, 0, 0));
        jLabel15.setOpaque(true);
        jPanel1.add(jLabel15);
        jLabel15.setBounds(850, 10, 180, 110);

        jButton2.setText("Add Image ");
        jPanel1.add(jButton2);
        jButton2.setBounds(850, 130, 180, 20);

        jButton3.setText("Search");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(700, 90, 90, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1051, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed


        







        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        
        
        String tem = jTextField3.getText();
         String tem1 = jTextField6.getText();
           String tem2 = jTextField1.getText();
             String tem3 = jTextField8.getText();
              
                       
           if(tem.isEmpty() || tem1.isEmpty() || tem2.isEmpty() || tem3.isEmpty())
      {
           JOptionPane.showMessageDialog(null, "Please enter All Data", "Error", JOptionPane.INFORMATION_MESSAGE);
      }
           
            else if(!tem3.matches ("[0-9]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]+[0-9]")){
          JOptionPane.showMessageDialog(null, "Contact Number should have 10 digits only.", "Error", JOptionPane.INFORMATION_MESSAGE);
       }
               else if(!tem1.matches ("[0-9]+[0-9]+[0-9]+[0-9]")){
          JOptionPane.showMessageDialog(null, "Cost should have 4 digits o.", "Error", JOptionPane.INFORMATION_MESSAGE);
       }
                 else if(!tem2.matches ("[0-9]+[0-9]+[0-9]")){
          JOptionPane.showMessageDialog(null, "Part Time Cost should have 3 digits .", "Error", JOptionPane.INFORMATION_MESSAGE);
       }
            
           
           else {   
        String it160_name = jTextField3.getText();
        String it160_type = jTextField5.getText();
        String it160_rate = jComboBox1.getSelectedItem().toString();
        String it160_cost = jTextField6.getText();
         String it160_specilify = jTextField7.getText();
          String it160_comment = jTextArea1.getText();
           String it160_pat_cost = jTextField1.getText();
        
        String it160_4n= jTextField8.getText() ; 
          
        
         String it160_g = "INSERT INTO guider (name,type,rate,cost,specilify,comment,pat_cost,4n ) values ('"+it160_name+"','"+it160_type+"','"+it160_rate+"','"+it160_cost+"','"+it160_specilify+"','"+it160_comment+"','"+it160_pat_cost+"','"+it160_4n+"')";
        
         try {
             pst =con.prepareStatement(it160_g);
             pst.execute();
             tableload();
             
             // TODO add your handling code here:
         } catch (SQLException ex) {
            System.out.println(ex);
            
         }

           }
        
    }//GEN-LAST:event_jButton4MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked


         int x =  JOptionPane.showConfirmDialog(null,"Do you want to Update" );

        if (x==0 ) {

            try {
                        String it160_Uid =  jLabel1.getText();     
        String it160_uname = jTextField3.getText();
        String it160_utype = jTextField5.getText();
        String it160_urate = jComboBox1.getSelectedItem().toString();
        String it160_ucost = jTextField6.getText();
         String it160_uspecilify = jTextField7.getText();
          String it160_ucomment = jTextArea1.getText();
           String it160_upat_cost = jTextField1.getText();
        
        String it160_4n= jTextField8.getText() ; 

                String Update_sql = "update guider set name='"+ it160_uname+"' , rate ='"+it160_urate +"' , type ='"+it160_utype +"' , cost = '"+it160_ucost+"',specilify ='"+it160_uspecilify+"' ,comment='"+it160_ucomment+"',pat_cost = '"+it160_upat_cost+"',4n='"+it160_4n+"' where id = '"+it160_Uid+"'";
                pst = con.prepareStatement(Update_sql);
                pst.execute() ;
                tableload();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        }
        


        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5MouseClicked

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked


       int r = jTable1.getSelectedRow();
        String id = jTable1.getValueAt(r,0).toString();
       String name = jTable1.getValueAt(r,1).toString();
        String type  = jTable1.getValueAt(r,2).toString();
      String rate  = jTable1.getValueAt(r,3).toString();
       String cost   = jTable1.getValueAt(r,4).toString();
        String specilify   = jTable1.getValueAt(r,5).toString();
         String comment   = jTable1.getValueAt(r,6).toString();
        String pat_cost   = jTable1.getValueAt(r,7).toString();
       String phone   = jTable1.getValueAt(r,8).toString();
         

          
        
           
        jLabel16.setText(id);
       jTextField3.setText(name);
        jTextField5.setText(type);
       jComboBox1.setSelectedItem(rate);
        jTextField6.setText(cost);
        jTextField7.setText(specilify);
        jTextArea1.setText(comment);
       jTextField8.setText(phone);  
       jTextField1.setText(pat_cost);


        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked


          int x =  JOptionPane.showConfirmDialog(null,"Do you want to delete  " );

        if (x==0 ) {
            try {
                String id = jLabel16.getText();
                String delete_sql = "delete from guider where id ='"+id+"' " ;
                pst = con.prepareStatement(delete_sql);
                pst.execute() ;
                tableload();
            } catch (SQLException ex) {
                  System.out.println(ex);
            }
        }


        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked

        
        String Sname= jTextField2.getText();
         String sql = " select  id ,name,type,rate,cost,specilify,comment,pat_cost,4n from guider  where name like  '%"+Sname+"%'"  ;
        
         try {
              pst = con.prepareStatement(sql);
             rs = pst.executeQuery();
              jTable1.setModel(DbUtils.resultSetToTableModel(rs));
             
         } catch (SQLException ex) {
             Logger.getLogger(tour_package_manage_in.class.getName()).log(Level.SEVERE, null, ex);
         }
            


        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3MouseClicked

        int clickCount = 0;
    
    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked

          if(clickCount ==0){
        
    JFrame parent = new JFrame();

    JOptionPane.showMessageDialog(parent, "If you need to search a guider  ... \n" + "Enter your guider name");        
        }
        clickCount++;
            

        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked

            tour_vehicle_manage_ln  pe = new tour_vehicle_manage_ln();                         
                    JDesktopPane n =getDesktopPane();
                    n.add(pe);
                    pe.show();
                    this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked

             tour_locaation_manage_ln  pe = new tour_locaation_manage_ln();                         
                    JDesktopPane n =getDesktopPane();
                    n.add(pe);
                    pe.show();
                    this.dispose();

            

        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
          this.dispose();


        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel12MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}