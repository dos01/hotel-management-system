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
public class tour_package_package_in extends javax.swing.JInternalFrame {

    /**
     * Creates new form tour_package_package_in
     */
    
    
      
     Connection con = null;
    PreparedStatement pst = null; 
    ResultSet rs = null ;
    public tour_package_package_in() {
        initComponents();
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(0, 0, 204));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 0, 51));
        jPanel2.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Location");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(20, 110, 120, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Location");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 160, 120, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Location");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(20, 210, 120, 20);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Location");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(20, 260, 120, 20);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Location");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(20, 310, 120, 20);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Location");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(20, 360, 120, 20);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Location");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(20, 410, 120, 20);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Location");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(20, 460, 120, 20);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Location");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(20, 510, 120, 20);
        jPanel2.add(jTextField1);
        jTextField1.setBounds(120, 550, 150, 30);
        jPanel2.add(jTextField2);
        jTextField2.setBounds(120, 100, 150, 30);
        jPanel2.add(jTextField3);
        jTextField3.setBounds(120, 150, 150, 30);
        jPanel2.add(jTextField4);
        jTextField4.setBounds(120, 200, 150, 30);
        jPanel2.add(jTextField5);
        jTextField5.setBounds(120, 250, 150, 30);
        jPanel2.add(jTextField6);
        jTextField6.setBounds(120, 300, 150, 30);
        jPanel2.add(jTextField7);
        jTextField7.setBounds(120, 350, 150, 30);
        jPanel2.add(jTextField8);
        jTextField8.setBounds(120, 400, 150, 30);
        jPanel2.add(jTextField9);
        jTextField9.setBounds(120, 450, 150, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Location");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 560, 120, 20);
        jPanel2.add(jTextField10);
        jTextField10.setBounds(120, 500, 150, 30);

        jTextField11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField11ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField11);
        jTextField11.setBounds(140, 10, 150, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Package Id");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(20, 20, 120, 22);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(0, 90, 180, 20);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("you need to enter location numbers by giving ");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(10, 50, 310, 20);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("  the suitable package id");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(0, 60, 330, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 300, 720);

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
        jScrollPane1.setBounds(300, 120, 740, 250);

        jLabel1.setBackground(new java.awt.Color(0, 51, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tuor_image/icon/Untitled-12.jpg"))); // NOI18N
        jLabel1.setOpaque(true);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1);
        jLabel1.setBounds(800, 410, 220, 170);

        jLabel14.setBackground(new java.awt.Color(0, 51, 51));
        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tuor_image/icon/Untitled-11.jpg"))); // NOI18N
        jLabel14.setOpaque(true);
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel14MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel14);
        jLabel14.setBounds(560, 410, 220, 170);

        jLabel15.setBackground(new java.awt.Color(0, 51, 51));
        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tuor_image/icon/Untitled-10.jpg"))); // NOI18N
        jPanel1.add(jLabel15);
        jLabel15.setBounds(320, 410, 220, 170);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 204, 204));
        jLabel13.setText("Select Location");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(570, 20, 290, 42);

        jTextField12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField12MouseClicked(evt);
            }
        });
        jPanel1.add(jTextField12);
        jTextField12.setBounds(430, 80, 340, 30);

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(800, 80, 90, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1037, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        String location_1 ; String location_id_1 ;
        String location_2 ; String location_id_2 ;
        String location_3 ; String location_id_3 ;
        String location_4 ; String location_id_4 ;
        String location_5 ; String location_id_5 ;
        String location_6 ; String location_id_6 ;
        String location_7 ; String location_id_7 ;
        String location_8 ; String location_id_8 ;
        String location_9 ;String location_id_9 ;
        String location_10 ; String location_id_10 ;
        int location_number = 0  ;
    
    
    
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        int r = jTable1.getSelectedRow();
        String id = jTable1.getValueAt(r,0).toString();
        String name = jTable1.getValueAt(r,1).toString();

        if(location_number == 0){
            location_id_1 = id;
            location_1 = name ;
            jTextField2.setText(name);
        }
        if(location_number == 1){
            location_id_2 = id;
            location_2 = name ;
            jTextField3.setText(name);
        }
        if(location_number == 2){
            location_id_3 = id;
            location_3 = name ;
            jTextField4.setText(name);
        }
        if(location_number == 3){
            location_id_4 = id;
            location_4 = name ;
            jTextField5.setText(name);
        }
        if(location_number == 4){
            location_id_5 = id;
            location_5 = name ;
            jTextField6.setText(name);

        }
        if(location_number == 5){
            location_id_6 = id;
            location_6 = name ;
            jTextField7.setText(name);
        }
        if(location_number == 6){
            location_id_7 = id;
            location_7 = name ;
            jTextField8.setText(name);
        }
        if(location_number == 7){
            location_id_8 = id;
            location_8 = name ;
            jTextField9.setText(name);
        }
        if(location_number == 8){
            location_id_9 = id;
            location_9 = name ;
            jTextField10.setText(name);
        }
        if(location_number == 9){
            location_id_10 = id;
            location_10 = name ;
            jTextField1.setText(name);
            
       
                 
        
    JFrame parent = new JFrame();

    JOptionPane.showMessageDialog(parent, "from this onwards if you add more locations it'll replace the previous locations into new selected locations ");        
        
       
            
        }

        if(location_number !=9){
            location_number++;
        }
        else{
            location_number=0;
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

        
        String package_id = jTextField11.getText();
        location_1 = jTextField2.getText();
        location_2 = jTextField3.getText();
        location_3 = jTextField4.getText();
        location_4 = jTextField5.getText();
        location_5 = jTextField6.getText();
        location_6 = jTextField7.getText();
        location_7 = jTextField8.getText();
        location_8 = jTextField9.getText();
        location_9 = jTextField10.getText();
        location_10=jTextField1.getText();

        String it160_g = "INSERT INTO it160_package_location_history (package_id,location_1,location_2,location_3,location_4,location_5,location_6,location_7,location_8,location_9,location_10 ) values ('"+package_id+"','"+location_1+"','"+location_2+"','"+location_3+"','"+location_4+"','"+location_5+"','"+location_6+"','"+location_7+"','"+location_8+"','"+location_9+"','"+location_10+"')";
        try {
            pst =con.prepareStatement(it160_g);
            pst.execute();
            tableload();

            // TODO add your handling code here:
        } catch (SQLException ex) {
            System.out.println(ex);

        }

        
        tour_package_vehicle_ln pv = new tour_package_vehicle_ln();
         JDesktopPane n =getDesktopPane();
                    n.add(pv);
                    pv.show();
                    this.dispose();

        
        
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jTextField11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField11ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

           String Sname = jTextField12.getText();
        String sql = " select  place_id  ,name  , type,rate , cost ,description  from place where name like '%"+Sname+"%' "  ;

         try {
             pst = con.prepareStatement(sql);
               rs = pst.executeQuery();
             jTable1.setModel(DbUtils.resultSetToTableModel(rs));
         } catch (SQLException ex) {
            System.out.println(ex);
         }


        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MouseClicked

            
  tour_package_list_ln pl = new tour_package_list_ln();                         
                    JDesktopPane n =getDesktopPane();
                    n.add(pl);
                    pl.show();
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel14MouseClicked

        int clickCount = 0;
    
    private void jTextField12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField12MouseClicked

         
        if(clickCount ==0){
        
    JFrame parent = new JFrame();

    JOptionPane.showMessageDialog(parent, "If you need to search a location  ... \n" + "Enter your location name");        
        }
        clickCount++;
            


        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField12MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
