/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;


import database.DBconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author CJ
 */
public class SecurityIn extends javax.swing.JInternalFrame {

    Connection con=null;
    PreparedStatement pst=null;
    PreparedStatement pst2=null;
    ResultSet rs=null;
    /**
     * Creates new form SecurityIn
     */
    public static long getDifferenceDays(Date d1, Date d2) {
        long diff = d2.getTime() - d1.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
    

    
    
    public void reset(){
        snobox.setText("");
        lradio.setSelected(false);
        sradio.setSelected(false);
        //mnychk.setSelected(false);
        //docchk.setSelected(false);
        //gchk.setSelected(false);
        //jchk.setSelected(false);
        //ochk.setSelected(false);
        nobox.setText("");
        gidbox.setText("");
        gnamebox.setText("");
        //nicradio.setSelected(false);
        //passradio.setSelected(false);
        sidbox.setText("");
        cnobox.setText("");
        rdatebox.setCalendar(null);
        estdatebox.setCalendar(null);
        dubox.setText("");
        ecostbox.setText("");
        totalbox.setText("");
    }
    
    public void load_locker_info(){
        try{
            lbltitle.setVisible(true);
            lbltitle.setText("Locker Information");
            jPanel6.setVisible(true);
            searchbox.setVisible(true);
            sbtn.setVisible(true);
            rbtn.setVisible(true);
            String sql="select LNo,size,availability from locker_info";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            lbltitle.setText("Locker Information");
        }
        catch (Exception e){
            
        }
    }
    
    public void load_safe_info(){
        try{
            lbltitle.setVisible(true);
            
            jPanel6.setVisible(true);
            searchbox.setVisible(true);
            sbtn.setVisible(true);
            rbtn.setVisible(true);
            lbltitle.setText("Safe Information");
            String sql="select SNo,size,availability from safe_info";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch (Exception e){
            
        }
    }
    
    public void load_guest_info(){
        try{
            lbltitle.setVisible(true);
            
            jPanel6.setVisible(true);
            searchbox.setVisible(true);
            sbtn.setVisible(true);
            rbtn.setVisible(true);
            lbltitle.setText("Guest Information");
            String sql="select customerID,fname,lname,telephone,NIC from customer";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch (Exception e){
            
        }
    }
    
    public void load_security_history(){
        try{
            lbltitle.setVisible(true);
            
            jPanel6.setVisible(true);
            searchbox.setVisible(true);
            sbtn.setVisible(true);
            rbtn.setVisible(true);
            lbltitle.setText("Security Management History");
            //String sql="select SMNo,L/SNo,type,guestID,guestName,NIC,passport,contactNo,reservedDate,est_returnDate,duration,currentDate,cost,extraCost,total from security_management_history";
            String sql="select * from security_management_history";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            
        }
        catch (Exception e){
            
        }
    }
    
    public void load_security_cost(){
        try{
            lbltitle.setVisible(true);
            
            jPanel6.setVisible(true);
            searchbox.setVisible(true);
            sbtn.setVisible(true);
            rbtn.setVisible(true);
            String sql="select SCNo,type,cost from security_cost";
            pst=con.prepareStatement(sql);
            rs=pst.executeQuery();
            
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            lbltitle.setText("Security-Cost Information");
        }
        catch (Exception e){
            
        }
    }
    
    public SecurityIn() {
        initComponents();
        con=DBconnect.connect();
        
        searchbox.setVisible(false);
        sbtn.setVisible(false);
        rbtn.setVisible(false);
        
        jPanel6.setVisible(false);
       
        lbltitle.setVisible(false);
        //jPanel3.setVisible(true);
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
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cnobox = new javax.swing.JTextField();
        gidbox = new javax.swing.JTextField();
        ecostbox = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        dubox = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sradio = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        sidbox = new javax.swing.JTextField();
        totalbox = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        gnamebox = new javax.swing.JTextField();
        lradio = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        snobox = new javax.swing.JLabel();
        nobox = new javax.swing.JLabel();
        rdatebox = new com.toedter.calendar.JDateChooser();
        estdatebox = new com.toedter.calendar.JDateChooser();
        tduration = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        costbox = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        lbltitle = new javax.swing.JLabel();
        searchbox = new javax.swing.JTextField();
        sbtn = new javax.swing.JButton();
        rbtn = new javax.swing.JButton();

        setBackground(new java.awt.Color(90, 120, 183));
        setClosable(true);
        setForeground(new java.awt.Color(90, 120, 183));
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setFocusTraversalPolicyProvider(true);
        setPreferredSize(new java.awt.Dimension(1060, 750));

        jPanel1.setBackground(new java.awt.Color(90, 120, 183));
        jPanel1.setForeground(new java.awt.Color(90, 120, 183));
        jPanel1.setPreferredSize(new java.awt.Dimension(1060, 750));

        jPanel2.setBackground(new java.awt.Color(90, 120, 183));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Guest Security Management", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 24), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(90, 120, 183));
        jPanel2.setPreferredSize(new java.awt.Dimension(1060, 750));

        jPanel3.setBackground(new java.awt.Color(90, 120, 183));
        jPanel3.setForeground(new java.awt.Color(90, 120, 183));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(90, 120, 183));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Contact No");

        cnobox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cnoboxMouseClicked(evt);
            }
        });

        gidbox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gidboxMouseClicked(evt);
            }
        });

        ecostbox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ecostboxMouseClicked(evt);
            }
        });
        ecostbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ecostboxActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Est. Return Date");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Duration(Then|Now)");

        jButton1.setBackground(new java.awt.Color(68, 145, 162));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("New");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(68, 145, 162));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        dubox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                duboxMouseClicked(evt);
            }
        });
        dubox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duboxActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Total");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("SNo");

        sradio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        sradio.setForeground(new java.awt.Color(255, 255, 255));
        sradio.setText("Safe");
        sradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sradioActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Guest ID");

        sidbox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sidboxMouseClicked(evt);
            }
        });

        totalbox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                totalboxMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Reserved Date");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Extra Cost");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Secondary ID");

        gnamebox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gnameboxMouseClicked(evt);
            }
        });
        gnamebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gnameboxActionPerformed(evt);
            }
        });

        lradio.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lradio.setForeground(new java.awt.Color(255, 255, 255));
        lradio.setText("Locker");
        lradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lradioActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Type");

        jButton2.setBackground(new java.awt.Color(68, 145, 162));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Guest Name");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Locker/Safe No");

        jButton3.setBackground(new java.awt.Color(68, 145, 162));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        snobox.setBackground(new java.awt.Color(255, 255, 255));
        snobox.setForeground(new java.awt.Color(255, 255, 255));
        snobox.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        snobox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                snoboxMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                snoboxMouseEntered(evt);
            }
        });

        nobox.setBackground(new java.awt.Color(255, 255, 255));
        nobox.setForeground(new java.awt.Color(255, 255, 255));
        nobox.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tduration.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tdurationMouseClicked(evt);
            }
        });
        tduration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tdurationActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cost");

        costbox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                costboxMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(snobox, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(62, 62, 62)
                        .addComponent(lradio)
                        .addGap(11, 11, 11)
                        .addComponent(sradio, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nobox, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(gidbox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(gnamebox, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(sidbox, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ecostbox, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rdatebox, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cnobox, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(totalbox)
                            .addComponent(estdatebox, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(dubox, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tduration))
                            .addComponent(costbox))))
                .addGap(20, 20, 20))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(snobox, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cnobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8))
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdatebox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(lradio)
                        .addComponent(sradio)
                        .addComponent(jLabel9)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(estdatebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(nobox, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                            .addComponent(jLabel4))))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dubox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tduration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(gidbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ecostbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(gnamebox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(costbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(sidbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addGap(83, 83, 83))
        );

        jPanel5.setBackground(new java.awt.Color(90, 120, 183));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itp/scost.png"))); // NOI18N
        jButton5.setToolTipText("security cost");
        jButton5.setMaximumSize(new java.awt.Dimension(98, 98));
        jButton5.setMinimumSize(new java.awt.Dimension(98, 98));
        jButton5.setPreferredSize(new java.awt.Dimension(98, 98));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itp/locker.png"))); // NOI18N
        jButton6.setToolTipText("locker info");
        jButton6.setMaximumSize(new java.awt.Dimension(98, 98));
        jButton6.setMinimumSize(new java.awt.Dimension(98, 98));
        jButton6.setPreferredSize(new java.awt.Dimension(98, 98));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itp/safe.png"))); // NOI18N
        jButton7.setToolTipText("safe info");
        jButton7.setMaximumSize(new java.awt.Dimension(98, 98));
        jButton7.setMinimumSize(new java.awt.Dimension(98, 98));
        jButton7.setPreferredSize(new java.awt.Dimension(98, 98));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/itp/smanage.png"))); // NOI18N
        jButton8.setToolTipText("security management history");
        jButton8.setMaximumSize(new java.awt.Dimension(98, 98));
        jButton8.setMinimumSize(new java.awt.Dimension(98, 98));
        jButton8.setPreferredSize(new java.awt.Dimension(98, 98));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(90, 120, 183));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setForeground(new java.awt.Color(255, 255, 255));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        lbltitle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbltitle.setForeground(new java.awt.Color(255, 255, 255));
        lbltitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        sbtn.setText("Search");
        sbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sbtnActionPerformed(evt);
            }
        });

        rbtn.setText("Reset");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(sbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rbtn)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbltitle, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(111, 111, 111))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbltitle, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchbox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sbtn)
                    .addComponent(rbtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1041, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 574, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1040, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ecostboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ecostboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ecostboxActionPerformed

    private void duboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_duboxActionPerformed

    private void gnameboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gnameboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_gnameboxActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String sno=snobox.getText();
        String type="";
        
        if(lradio.isSelected()){
            type="Locker";
        }
        if(sradio.isSelected()){
            type="Safe";
        }
        
        String lsno=nobox.getText();
        String gid=gidbox.getText();
        String gname=gnamebox.getText();
       
        
        String sndid=sidbox.getText();
        String tel=cnobox.getText();
        
        SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
        String rdate = dcn.format(rdatebox.getDate());
        SimpleDateFormat dcn2 = new SimpleDateFormat("yyyy-MM-dd");
        String estdate = dcn2.format(estdatebox.getDate());
        
        
        
        String days=dubox.getText();
        //ecostbox.getText();
        String cost=costbox.getText();
        String service="Security";

        try{
            String q="";
            q="insert into security_management_history (L/SNo,type,guestID,guestName,SID,contactNo,reservedDate,est_returnDate,duration,currentDate,cost) values ('"+lsno+"','"+type+"','"+gid+"','"+gname+"','"+sndid+"','"+tel+"','"+rdate+"','"+estdate+"','"+days+"','"+cost+"')";
            pst=con.prepareStatement(q);
            pst.execute();
            /*if(nicradio.isSelected()){
                q="insert into security_management_history (L/SNo,type,guestID,guestName,NIC,contactNo,reservedDate,est_returnDate,duration,currentDate,cost) values ('"+lsno+"','"+type+"','"+gid+"','"+gname+"','"+sndid+"','"+tel+"','"+rdate+"','"+estdate+"','"+days+"','"+cost+"')";
                pst=con.prepareStatement(q);
                pst.execute();
            }
            if(passradio.isSelected()){
                q="insert into security_management_history (L/SNo,type,guestID,guestName,passport,contactNo,reservedDate,est_returnDate,duration,currentDate,cost) values ('"+lsno+"','"+type+"','"+gid+"','"+gname+"','"+sndid+"','"+tel+"','"+rdate+"','"+estdate+"','"+days+"','"+cost+"')";
                pst=con.prepareStatement(q);
                pst.execute();
            }*/
            try {
            String q1="INSERT INTO servicemobil ( `name`, `desc`, `price`, `cusid`) VALUES ( ?, ?, ?,?) ";
            pst=con.prepareStatement(q1);
            pst.setString(1, type);
            pst.setString(2, type);
            pst.setString(3, cost);
            pst.setString(4, gid);
            pst.execute();
            } catch (Exception e) {
                System.out.println("service mobile"+e);
            }
            
        }
        catch(Exception e){

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int x=JOptionPane.showConfirmDialog(null, "Do you really want to delete this ?");

        if(x==0){
            String no=snobox.getText();
            String sql="delete from security_management_history where SMNo='"+no+"'";

            try{
                pst=con.prepareStatement(sql);
                pst.execute();

                //load table
                //load_order_table();
                reset();
                
                try {
                    String id=gidbox.getText();
                String s="delete from servicemobil where cusid=?";
                pst=con.prepareStatement(s);
                pst.setString(1, id);
                pst.execute();
                
                    } catch (Exception e) {
                        System.out.println("service"+e);
                    }
            }
            catch (Exception e){

            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void lradioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lradioActionPerformed
        // TODO add your handling code here:
        
        if(lradio.isSelected()){
            //gchk.setVisible(true);
            //gchk.setSelected(false);
            sradio.setSelected(false);
            jTable2.removeAll();
            jTable2.setVisible(true);
            load_locker_info();
        }
            
    }//GEN-LAST:event_lradioActionPerformed

    private void sradioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sradioActionPerformed
        // TODO add your handling code here:
        
        if(sradio.isSelected()){
            lradio.setSelected(false);
            jTable2.removeAll();
            jTable2.setVisible(true);
            load_safe_info();
        }
            /*//gchk.setVisible(false);
            //gchk.setSelected(false);
            mnychk.setVisible(true);
            mnychk.setSelected(false);
            docchk.setVisible(true);
            docchk.setSelected(false);
            jchk.setVisible(true);
            jchk.setSelected(false);
            ochk.setVisible(true);
            ochk.setSelected(false);
        }*/
        
    }//GEN-LAST:event_sradioActionPerformed

    private void snoboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_snoboxMouseClicked
        // TODO add your handling code here:
        
        try {
            //String sql = "select SMNo+1 from security_management_history";
            String sql = "SELECT SMNo+1 from security_management_history";
            pst=con.prepareStatement(sql);
            //pst.setString(1,EmployeeIDSearchField.getText());

            rs= pst.executeQuery(sql);
            while(rs.next()) {
                snobox.setText(rs.getString("SMNo+1"));
            }
        }
        catch (SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_snoboxMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void duboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_duboxMouseClicked
        // TODO add your handling code here:
        dubox.setText(Long.toString(getDifferenceDays(rdatebox.getDate(),estdatebox.getDate())));
    }//GEN-LAST:event_duboxMouseClicked

    private void snoboxMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_snoboxMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_snoboxMouseEntered

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int x=JOptionPane.showConfirmDialog(null,"Do you really want to update ?");
        
            if(x==0){
                String sno=snobox.getText();
                String type="";

                if(lradio.isSelected()){
                    type="Locker";
                }
                if(sradio.isSelected()){
                    type="Safe";
                }

                String lsno=nobox.getText();
                String gid=gidbox.getText();
                String gname=gnamebox.getText();


                String sndid=sidbox.getText();
                String tel=cnobox.getText();

                SimpleDateFormat dcn = new SimpleDateFormat("yyyy-MM-dd");
                String rdate = dcn.format(rdatebox.getDate());
                SimpleDateFormat dcn2 = new SimpleDateFormat("yyyy-MM-dd");
                String estdate = dcn2.format(estdatebox.getDate());



                String days=dubox.getText();

                String ecost=ecostbox.getText();
                String cost=costbox.getText();
                String tot=totalbox.getText();
                String t="";
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                String cdate=dateFormat.format(date);

                String sql="";
                sql="update security_management_history SET SMNo='"+sno+"',L/SNo='"+lsno+"',type='"+type+"',guestID='"+gid+"',guestName='"+gname+"',SID='"+sndid+"',contactNo='"+tel+"',reservedDate='"+rdate+"',est_returnDate='"+estdate+"',duration='"+days+"',currentDate='"+cdate+"',cost='"+cost+"',extraCost='"+ecost+"',total='"+tot+"' where SMNo='"+sno+"'";
                /*if(nicradio.isSelected()){
                    sql="update security_management_history SET SMNo='"+sno+"',L/SNo='"+lsno+"',type='"+type+"',guestID='"+gid+"',guestName='"+gname+"',NIC='"+sndid+"',passport='"+t+"',contactNo='"+tel+"',reservedDate='"+rdate+"',est_returnDate='"+estdate+"',duration='"+days+"',currentDate='"+cdate+"',cost='"+cost+"',extraCost='"+ecost+"',total='"+tot+"' where SMNo='"+sno+"'";
                }
                if(passradio.isSelected()){
                    sql="update security_management_history SET SMNo='"+sno+"',L/SNo='"+lsno+"',type='"+type+"',guestID='"+gid+"',guestName='"+gname+"',NIC='"+t+"',passport='"+sndid+"',contactNo='"+tel+"',reservedDate='"+rdate+"',est_returnDate='"+estdate+"',duration='"+days+"',currentDate='"+cdate+"',cost='"+cost+"',extraCost='"+ecost+"',total='"+tot+"' where SMNo='"+sno+"'";
                }*/

                try{
                    pst=con.prepareStatement(sql);
                    pst.execute();

                    //msgbox
                    JOptionPane.showMessageDialog(this,"Successfully upddated");

                    try {
                    String ss="update servicemobil set name=?,desc=?,price=? where cusid=?";
                    pst=con.prepareStatement(ss);
                    pst.setString(1, type);
                    pst.setString(2, type);
                    pst.setString(3, tot);
                    pst.setString(4, gid);
                    pst.execute();
                    
                } catch (Exception e1) {
                    System.out.println("service "+e1);
                }
                    //load table
                    load_security_history();
                }
            catch (Exception e){
                
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tdurationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tdurationActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tdurationActionPerformed

    private void tdurationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tdurationMouseClicked
        // TODO add your handling code here:
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String today=dateFormat.format(date);
        
        tduration.setText(Long.toString(getDifferenceDays(rdatebox.getDate(),date)));
    }//GEN-LAST:event_tdurationMouseClicked

    private void ecostboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ecostboxMouseClicked
        // TODO add your handling code here:
        int edays=Integer.parseInt(tduration.getText()) - Integer.parseInt(dubox.getText());
        if(edays>0){
            double ecost=edays*150;
            ecostbox.setText(Double.toString(ecost));
        }
        else{
            ecostbox.setText("0");
        }
        
        
    }//GEN-LAST:event_ecostboxMouseClicked

    private void totalboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_totalboxMouseClicked
        // TODO add your handling code here:
        double nc=Double.parseDouble(costbox.getText());
        double ec=Double.parseDouble(ecostbox.getText());
        double tot=nc+ec;
        totalbox.setText(Double.toString(tot));
    }//GEN-LAST:event_totalboxMouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
        String lblName1="Locker Information";
        String lblName2="Safe Information";
        
        String lblName3="Security-Cost Information";
        String lblName4="Security Management History";
        String lblName5="Guest Information";

        if(lblName1.equals(lbltitle.getText())){
            int r=jTable2.getSelectedRow();
            String lno=jTable2.getValueAt(r, 0).toString();
            String size=jTable2.getValueAt(r, 1).toString();
            String ava=jTable2.getValueAt(r, 2).toString();

            nobox.setText(lno);
            
        }

        if(lblName2.equals(lbltitle.getText())){
            int r=jTable2.getSelectedRow();
            String sno=jTable2.getValueAt(r, 0).toString();
            String size=jTable2.getValueAt(r, 1).toString();
            String ava=jTable2.getValueAt(r, 2).toString();

            nobox.setText(sno);

        }
        
        if(lblName3.equals(lbltitle.getText())){
            int r=jTable2.getSelectedRow();
            String scno=jTable2.getValueAt(r, 0).toString();
            String type=jTable2.getValueAt(r, 1).toString();
            String cost=jTable2.getValueAt(r, 2).toString();

            costbox.setText(cost);

        }
        
        if(lblName4.equals(lbltitle.getText())){
            int r=jTable2.getSelectedRow();
            String smno=jTable2.getValueAt(r, 0).toString();
            String lsno=jTable2.getValueAt(r, 1).toString();
            String type=jTable2.getValueAt(r, 2).toString();
            String gid=jTable2.getValueAt(r, 3).toString();
            String gname=jTable2.getValueAt(r, 4).toString();
            String nic=jTable2.getValueAt(r, 5).toString();
            //String pass=jTable2.getValueAt(r, 6).toString();
            String tel=jTable2.getValueAt(r, 6).toString();
            String rdate=jTable2.getValueAt(r, 7).toString();
            String estdate=jTable2.getValueAt(r, 8).toString();
            String due=jTable2.getValueAt(r, 9).toString();
            String cdate=jTable2.getValueAt(r, 10).toString();
            String cost=jTable2.getValueAt(r, 11).toString();
            String ecost=jTable2.getValueAt(r, 12).toString();
            String tcost=jTable2.getValueAt(r, 13).toString();

            snobox.setText(smno);
            nobox.setText(lsno);
            //nobox.setText(type);
            String lk="Locker";
            String sf="Safe";
            if(type.equals(lk)){
               sradio.setSelected(false);
               lradio.setSelected(true);
               
            }
            if(type.equals(sf)){
               lradio.setSelected(false);
               sradio.setSelected(true);
               
            }
            
            gidbox.setText(gid);
            gnamebox.setText(gname);
            String ntxt="";
            String blank=null;
            sidbox.setText(nic);
            /*if(nic.equals(ntxt)|nic.equals(blank)){
               nicradio.setSelected(false);
               passradio.setSelected(true);
               sidbox.setText(pass);
            }
            if(pass.equals(ntxt)|pass.equals(blank)){
               passradio.setSelected(false);
               nicradio.setSelected(true);
               sidbox.setText(nic);
            }*/
            cnobox.setText(tel);
            java.util.Date date;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(rdate);
                rdatebox.setDate(date);
            } catch (ParseException ex) {
            
            }
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(estdate);
                estdatebox.setDate(date);
            } catch (ParseException ex) {
            
            }
            
            dubox.setText(due);
            //nobox.setText(cdate);
            costbox.setText(cost);
            ecostbox.setText(ecost);
            totalbox.setText(tcost);
            

        }
        
        if(lblName5.equals(lbltitle.getText())){
            int r=jTable2.getSelectedRow();
            String gid=jTable2.getValueAt(r, 0).toString();
            String fname=jTable2.getValueAt(r, 1).toString();
            String lname=jTable2.getValueAt(r, 2).toString();
            String tel=jTable2.getValueAt(r, 3).toString();
            String nic=jTable2.getValueAt(r, 4).toString();
            //String pass=jTable2.getValueAt(r, 5).toString();

            gidbox.setText(gid);
            String full=fname + " " + lname;
            gnamebox.setText(full);
            
            cnobox.setText(tel);
            //only temp
            //nicradio.setSelected(true);
            sidbox.setText(nic);
            
            /*String ntxt="";
            String blank=null;
            if(nic.equals(ntxt)|nic.equals(blank)){
                nicradio.setSelected(false);
                sidbox.setText(pass);
                passradio.setSelected(true);
            }
            if(pass.equals(ntxt)|pass.equals(blank)){
                passradio.setSelected(false);
                sidbox.setText(nic);
                nicradio.setSelected(true);
            }*/

        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void gidboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gidboxMouseClicked
        // TODO add your handling code here:
        load_guest_info();
    }//GEN-LAST:event_gidboxMouseClicked

    private void gnameboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gnameboxMouseClicked
        // TODO add your handling code here:
        load_guest_info();
    }//GEN-LAST:event_gnameboxMouseClicked

    private void sidboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sidboxMouseClicked
        // TODO add your handling code here:
        load_guest_info();
    }//GEN-LAST:event_sidboxMouseClicked

    private void cnoboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cnoboxMouseClicked
        // TODO add your handling code here:
        load_guest_info();
    }//GEN-LAST:event_cnoboxMouseClicked

    private void costboxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_costboxMouseClicked
        // TODO add your handling code here:
        load_security_cost();
    }//GEN-LAST:event_costboxMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        load_security_cost();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        load_locker_info();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        load_safe_info();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        load_security_history();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void sbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sbtnActionPerformed
        // TODO add your handling code here:
        String h1="Locker Information";
        String h2="Safe Information";
        
        String h3="Security-Cost Information";
        String h4="Security Management History";
        String h5="Guest Information";

        String name=searchbox.getText();
        String ser="%" + name + "%";

        try{
            if(h1.equals(lbltitle.getText())){
                String sql="select LNo,size,availability from locker_info where LNo like '"+ser+"'";
                pst=con.prepareStatement(sql);
                rs=pst.executeQuery();
                jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            }
            if(h2.equals(lbltitle.getText())){
                String sql="select SNo,size,availability from safe_info where SNo like '"+ser+"'";
                pst=con.prepareStatement(sql);
                rs=pst.executeQuery();
                jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            }
            if(h3.equals(lbltitle.getText())){
                String sql="select SCNo,type,cost from security_cost where SCNo like '"+ser+"'";
                pst=con.prepareStatement(sql);
                rs=pst.executeQuery();
                jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            }
            if(h4.equals(lbltitle.getText())){
                String sql="select SMNo,L/SNo,type,guestID,guestName,NIC,passport,contactNo,reservedDate,est_returnDate,duration,currentDate,cost,extraCost,total from security_management_history where SMNo like '"+ser+"'";
                pst=con.prepareStatement(sql);
                rs=pst.executeQuery();
                jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            }
            if(h5.equals(lbltitle.getText())){
                String sql="select customerID,fname,lname,telephone,NIC,passport from customer where customerID like '"+ser+"'";
                pst=con.prepareStatement(sql);
                rs=pst.executeQuery();
                jTable2.setModel(DbUtils.resultSetToTableModel(rs));
            }

        }
        catch (Exception e){

        }
    }//GEN-LAST:event_sbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField cnobox;
    private javax.swing.JTextField costbox;
    private javax.swing.JTextField dubox;
    private javax.swing.JTextField ecostbox;
    private com.toedter.calendar.JDateChooser estdatebox;
    private javax.swing.JTextField gidbox;
    private javax.swing.JTextField gnamebox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JLabel lbltitle;
    private javax.swing.JRadioButton lradio;
    private javax.swing.JLabel nobox;
    private javax.swing.JButton rbtn;
    private com.toedter.calendar.JDateChooser rdatebox;
    private javax.swing.JButton sbtn;
    private javax.swing.JTextField searchbox;
    private javax.swing.JTextField sidbox;
    private javax.swing.JLabel snobox;
    private javax.swing.JRadioButton sradio;
    private javax.swing.JTextField tduration;
    private javax.swing.JTextField totalbox;
    // End of variables declaration//GEN-END:variables
}
