/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkout;

import com.mysql.jdbc.Connection;
import database.DBconnect;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Akila Sachin
 */
public class CheckOut extends javax.swing.JInternalFrame {
    Connection con=null;
    PreparedStatement pst = null;
    Connection con1=null;
    PreparedStatement pst1 = null;
    ResultSet rst=null;
    ArrayList name1=new ArrayList();
    ArrayList CID=new ArrayList();
    String cusID=null;
    /**
     * Creates new form CheckOut
     */
    
    
    public CheckOut() {
        initComponents();
        
        getContentPane().setBackground(new Color(90, 120, 183));
        
        con=DBconnect.connect();
        con1=DBconnect.connect();
        
        checkindate();
        checkout.setMinSelectableDate(Calendar.getInstance().getTime());
        
        getciddetails();
        
        
        jPanel1.setOpaque(false);
        jPanel2.setOpaque(false);
        jPanel3.setOpaque(false);
        
        jPanel7.setOpaque(false);
    }
    
    public void clear(){
        cID.setText("");
        name.setText("");
        NIC.setText("");
        conn.setText("");
        ppday.setText("");
        type.setText("");
        days.setText("");
        roomidbox.setText("");
        rdtot.setText("");
        broom.setText("");
        rarrangement.setText("");
        food.setText("");
        otheritems.setText("");
        tourcharges.setText("");
        othechag.setText("");
        dis.setText("0");
        totc.setText("");
        deposit.setText("");
        nettot.setText("");
        checkin.setDate(null);
    }
    
    public void checkindate(){
        
        Date today = Calendar.getInstance().getTime();
        checkout.setDate(today);
    }
    
    public void getciddetails(){
        try {
            String sql = "select * from reservation";
            pst=con.prepareStatement(sql);
            rst=pst.executeQuery();
            
            while(rst.next()){
                String Name=rst.getString("roomid");
                CID.add(Name);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog( this, " Failed to load Guest ID ","Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
    
     public void autoComplete1(String txt){
        String complete = "";
        int start= txt.length();
        int last=txt.length();
        int a;
        
        for (a=0;a<CID.size();a++){
            if(CID.get(a).toString().startsWith(txt)){
                complete = CID.get(a).toString();
                last = complete.length();
                break;
            }
        }
        if (last>start){
            cID.setText(complete);
            cID.setCaretPosition(last);
            cID.moveCaretPosition(start);
        }
    }
      
     public void loadguestdeatils1(){
       
        String roomnum=cID.getText();
        String dep=null;
        
        try {
             String sql1="select * from reservation where roomid=?";
            pst=con.prepareStatement(sql1);
            pst.setString(1, roomnum);
            rst=pst.executeQuery();
            
            if(rst.next()){
                String r=(rst.getString("checkindate"));
                DateFormat f=new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                Date d=f.parse(r);
                checkin.setDate(d);

                cusID=rst.getString("customerID");
                dep=rst.getString("deposit");
                deposit.setText(dep);
                
            }
         } catch (Exception e) {
              JOptionPane.showMessageDialog( this, " Failed to load Checkin Details"+ e,"Error", JOptionPane.ERROR_MESSAGE);
         }
        
        try {
            String sql="select * from customer where customerID=?";
            pst=con.prepareStatement(sql);
            pst.setString(1,cusID);
            rst=pst.executeQuery();
            
            if(rst.next()){
                NIC.setText(rst.getString("NIC"));
                String f=(rst.getString("fname"));
                String l=(rst.getString("lname"));
                conn.setText(rst.getString("telephone"));
                name.setText(f+" "+l);  
            }
  
        } catch (Exception e) {
             JOptionPane.showMessageDialog( this, " Failed to load Guest Details","Error", JOptionPane.ERROR_MESSAGE);
        }  
        

         
         try {
             String sql2="select * from room where roomID=?";
             pst= con.prepareStatement(sql2);
             pst.setString(1, roomnum);
             rst=pst.executeQuery();
             
             if(rst.next()){
                 type.setText(rst.getString("type"));
                ppday.setText(rst.getString("price"));
                roomidbox.setText(roomnum);
                getdaye();
             
            String s=days.getText();
       
             double day= Double.parseDouble(s);
            double p= Double.parseDouble(ppday.getText());
            Double tot=day*p;
            rdtot.setText(Double.toString(tot));   
            broom.setText(Double.toString(tot));
            
            
             }
             
             
         } catch (Exception e) {
             JOptionPane.showMessageDialog( this, " Failed to load room Details","Error", JOptionPane.ERROR_MESSAGE);
         }
         deliverycharges();
         foodbeverage();
         roomarrangements();
         tourcharges();
         othercharges();
         total();
         
    }
     
     public void getdaye(){
        Date in=checkin.getDate();  
        Date out=checkout.getDate();
        long ind = in.getTime();
        long outd = out.getTime();        
        long days=outd -ind;
         
           int x= (int) TimeUnit.DAYS.convert(days, TimeUnit.MILLISECONDS);
           
        this.days.setText(Integer.toString(x));
    }
     
     public void foodbeverage(){
         try {
              String que="select sum(totcost) from food where customerID=?";
               pst=con.prepareStatement(que);
               pst.setString(1, cusID);
               rst=pst.executeQuery();
                            
               if(rst.next()){
                   String tot=rst.getString("sum(totcost)");
                   food.setText(tot);
               }
               else{
                   food.setText("0");
               }
  
         } catch (Exception e) {
             JOptionPane.showMessageDialog( this, " Failed to load Food & Beverage Chargers"+e,"Error", JOptionPane.ERROR_MESSAGE);            
         } 
     }
     
     public void roomarrangements(){
         try {
              String que="select * from guest_ra_cost where guestID=?";
               pst=con.prepareStatement(que);
               pst.setString(1, cusID);
               rst=pst.executeQuery();
                            
               if(rst.next()){
                   String c=rst.getString("cost");
                   rarrangement.setText(c);
               }
               else{
                   rarrangement.setText("0");
               }
  
         } catch (Exception e) {
             JOptionPane.showMessageDialog( this, " Failed to load Room Arrangements Chargers"+e,"Error", JOptionPane.ERROR_MESSAGE);            
         } 
     }
     
     public void deliverycharges(){
         try {
              String que="select sum(cost) from delivery where customerID=?";
               pst=con.prepareStatement(que);
               pst.setString(1, cusID);
               rst=pst.executeQuery();
                            
               if(rst.next()){
                   String d=rst.getString("sum(cost)");
                   otheritems.setText(d);
                            if(otheritems.getText()==""){
                                otheritems.setText("0");
                             }
               }

         } catch (Exception e) {
             JOptionPane.showMessageDialog( this, " Failed to load Other Item Chargers"+e,"Error", JOptionPane.ERROR_MESSAGE);            
         } 
     }
     
      public void tourcharges(){
         try {
              String que="select * from it160_customer_selection_package_2 where customer__id=?";
               pst=con.prepareStatement(que);
               pst.setString(1, cusID);
               rst=pst.executeQuery();
                            
               if(rst.next()){
                   String d=rst.getString("A_cost");
                   tourcharges.setText(d);
               }
               else{
                   tourcharges.setText("0");
               }
  
         } catch (Exception e) {
             JOptionPane.showMessageDialog( this, " Failed to load Tour Package Chargers"+e,"Error", JOptionPane.ERROR_MESSAGE);            
         } 
     }
      
      public void othercharges(){
          String security=null;
          String laundary=null;
          
         try {
              String que="select * from security_management_history where guestID=?";
               pst=con.prepareStatement(que);
               pst.setString(1, cusID);
               rst=pst.executeQuery();
                            
               if(rst.next()){
                   security=rst.getString("total");
                   
               }
               else{
                   security="0";
               }

         } 
         catch (Exception e) {
             JOptionPane.showMessageDialog( this, " Failed to load Security Chargers"+e,"Error", JOptionPane.ERROR_MESSAGE);            
         }
         
          try {
              String que="select * from laundry_orders where guestID=?";
               pst=con.prepareStatement(que);
               pst.setString(1, cusID);
               rst=pst.executeQuery();
                            
               if(rst.next()){
                   laundary=rst.getString("totalCost");
                   
               }
               else{
                   laundary="0";
               }

         } 
         catch (Exception e) {
             JOptionPane.showMessageDialog( this, " Failed to load Laundary Chargers"+e,"Error", JOptionPane.ERROR_MESSAGE);            
         }
          
          double tot=Double.valueOf(security)+ Double.valueOf(laundary);
          othechag.setText(Double.toString(tot));
     }
     
     public void total(){
         Double room=Double.parseDouble(broom.getText());
         Double rarang=Double.parseDouble(rarrangement.getText());
         Double foodc=Double.parseDouble(food.getText());
         Double iother=Double.parseDouble(otheritems.getText());
         Double tour=Double.parseDouble(tourcharges.getText());
         Double sother=Double.parseDouble(othechag.getText());
         
         Double sub=room+rarang+foodc+iother+tour+sother;
         subtotal.setText(Double.toString(sub));
         
         Double disc=Double.parseDouble(dis.getText());
         
         Double totdisc=(sub/100)*disc;
         Double total=sub-totdisc;
         
         totc.setText(Double.toString(total));
         
         Double dep=Double.parseDouble(deposit.getText());
         
         Double net=total-dep;
         nettot.setText(Double.toString(net));
     } 
     
      public void roomstatus(String stat,String id){
         try {
             String sql= "Update room set status=? where roomID=?";
            pst1=con1.prepareStatement(sql);         
            pst1.setString(1, stat);
            pst1.setString(2, id);
            pst1.execute();
            
         } catch (Exception e) {
             JOptionPane.showMessageDialog( this, " Failed to load room satatus"+e,"Error", JOptionPane.ERROR_MESSAGE);   
             
         }
         
     }
      
      public void deletereservation(){
          
          try {
              
               String que="delete from reservation where customerID=?";
                pst=con.prepareStatement(que);
                pst.setString(1, cusID);
                pst.execute();
                
                String que1="delete from food where customerID=?";
                pst=con.prepareStatement(que1);
                pst.setString(1, cusID);
                pst.execute();
                
                 String que2="delete from guest_ra_cost where guestID=?";
                pst=con.prepareStatement(que2);
                pst.setString(1, cusID);
                pst.execute();
                
                String que3="delete from delivery where customerID=?";
                pst=con.prepareStatement(que3);
                pst.setString(1, cusID);
                pst.execute();
                
                String que4="delete from security_management_history where guestID=?";
                pst=con.prepareStatement(que4);
                pst.setString(1, cusID);
                pst.execute();
                
                String que5="delete from it160_customer_selection_package_2 where customer__id=?";
                pst=con.prepareStatement(que5);
                pst.setString(1, cusID);
                pst.execute();
                
                String que6="delete from laundry_orders where guestID=?";
                pst=con.prepareStatement(que6);
                pst.setString(1, cusID);
                pst.execute();
                
                
          } catch (Exception e) {
              JOptionPane.showMessageDialog( this, " Failed to delete reser"+e,"Error", JOptionPane.ERROR_MESSAGE);   
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
        jLabel22 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cID = new javax.swing.JTextField();
        name = new javax.swing.JLabel();
        conn = new javax.swing.JLabel();
        NIC = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        checkin = new com.toedter.calendar.JDateChooser();
        checkout = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        days = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        ppday = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        rdtot = new javax.swing.JLabel();
        roomidbox = new javax.swing.JLabel();
        type = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        broom = new javax.swing.JLabel();
        rarrangement = new javax.swing.JLabel();
        food = new javax.swing.JLabel();
        otheritems = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        tourcharges = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        deposit = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        nettot = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        dis = new javax.swing.JTextField();
        subtotal = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        othechag = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        totc = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Guest Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Name");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("NIC/Passport");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Contact Number");

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Room No");

        cID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cIDKeyPressed(evt);
            }
        });

        name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        conn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        conn.setForeground(new java.awt.Color(255, 255, 255));
        conn.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        NIC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        NIC.setForeground(new java.awt.Color(255, 255, 255));
        NIC.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22)
                    .addComponent(jLabel25)
                    .addComponent(jLabel26))
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cID, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(conn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NIC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cID, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel25)
                    .addComponent(NIC, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(conn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Reservation Dates", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        checkin.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        checkout.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Check Out");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Check In");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(checkin, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(checkout, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(70, 70, 70))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(checkout, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                    .addComponent(checkin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Room Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        days.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        days.setForeground(new java.awt.Color(255, 255, 255));
        days.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        days.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("No. of Days");

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Price per Day");

        ppday.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ppday.setForeground(new java.awt.Color(255, 255, 255));
        ppday.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        ppday.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Total");

        rdtot.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rdtot.setForeground(new java.awt.Color(255, 255, 255));
        rdtot.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rdtot.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        roomidbox.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        roomidbox.setForeground(new java.awt.Color(255, 255, 255));
        roomidbox.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        roomidbox.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        type.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        type.setForeground(new java.awt.Color(255, 255, 255));
        type.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        type.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rdtot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ppday, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(days, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(roomidbox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(type, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(roomidbox, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ppday, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(days, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdtot, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Bill Calculation", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Room Rental");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Other Requsted Items");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Food & Beverage Charges");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Tour Charges");

        broom.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        broom.setForeground(new java.awt.Color(255, 255, 255));
        broom.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        broom.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        rarrangement.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rarrangement.setForeground(new java.awt.Color(255, 255, 255));
        rarrangement.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        rarrangement.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        food.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        food.setForeground(new java.awt.Color(255, 255, 255));
        food.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        food.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        otheritems.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        otheritems.setForeground(new java.awt.Color(255, 255, 255));
        otheritems.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        otheritems.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Total Charges");

        tourcharges.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tourcharges.setForeground(new java.awt.Color(255, 255, 255));
        tourcharges.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tourcharges.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Deposit");

        deposit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deposit.setForeground(new java.awt.Color(255, 255, 255));
        deposit.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        deposit.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Subtotal");

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Discount");

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Total");

        nettot.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nettot.setForeground(new java.awt.Color(255, 255, 255));
        nettot.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        nettot.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setBackground(new java.awt.Color(68, 145, 162));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Print Bill");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        dis.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dis.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        dis.setText("0");
        dis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                disKeyReleased(evt);
            }
        });

        subtotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        subtotal.setForeground(new java.awt.Color(255, 255, 255));
        subtotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        subtotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("Room Arrangment Charges");

        othechag.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        othechag.setForeground(new java.awt.Color(255, 255, 255));
        othechag.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        othechag.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Other Service Charges");

        totc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        totc.setForeground(new java.awt.Color(255, 255, 255));
        totc.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totc.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton3.setBackground(new java.awt.Color(68, 145, 162));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Check Out");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel32)
                    .addComponent(jLabel31)
                    .addComponent(jLabel23)
                    .addComponent(jLabel30)
                    .addComponent(jLabel37)
                    .addComponent(jLabel34)
                    .addComponent(jLabel39)
                    .addComponent(jLabel24)
                    .addComponent(jLabel38)
                    .addComponent(jLabel43)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tourcharges, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(otheritems, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dis, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deposit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nettot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(broom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rarrangement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(food, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(subtotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(othechag, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(totc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(60, 60, 60))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(jButton3)
                .addContainerGap(149, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23)
                            .addComponent(broom, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rarrangement, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38))
                        .addGap(18, 18, 18)
                        .addComponent(food, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(otheritems, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel31)
                    .addComponent(tourcharges, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(othechag, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel37)
                    .addComponent(dis, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(totc, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deposit, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nettot, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(24, 24, 24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cIDKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cIDKeyPressed
        // TODO add your handling code here:
        switch(evt.getKeyCode()){
                case KeyEvent.VK_BACK_SPACE:                    
                    break;
                case KeyEvent.VK_ENTER:
                    loadguestdeatils1();
                    break;
                case KeyEvent.VK_V:
                    loadguestdeatils1();
                default:
                   EventQueue.invokeLater(new Runnable(){
                        @Override
                        public void run(){
                    String txt =cID.getText();
                            autoComplete1(txt);            
                }
                    });
                            }   
    }//GEN-LAST:event_cIDKeyPressed

    private void disKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_disKeyReleased
        // TODO add your handling code here:
            total();    
    }//GEN-LAST:event_disKeyReleased

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
         DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date cin=checkin.getDate();
            Date cout=checkout.getDate();
            
            String Checkin=df.format(cin);
            String Checkout=df.format(cout);
        String romid=roomidbox.getText();
        String disc=dis.getText();
        String subt=subtotal.getText();
        String netot=nettot.getText();
          try {
            String que="insert into reservation_history (customerID,checkinDate,checkoutdate,roomid,discount,subtotal,total) values (?,?,?,?,?,?,?)";
            pst=con.prepareStatement(que);
            pst.setString(1,cusID);
            pst.setString(2,Checkin);
            pst.setString(3,Checkout);
            pst.setString(4,romid);
            pst.setString(5,disc);
            pst.setString(6,subt);
            pst.setString(7,netot);
            pst.execute();
            
            try {
                String stat="Available";
                
             String sql1= "Update room set status=? where roomID=?";
            pst1=con1.prepareStatement(sql1);         
            pst1.setString(1, stat);
            pst1.setString(2, romid);
            pst1.execute();
            } catch (Exception e) {
             JOptionPane.showMessageDialog( this, " Failed to load room satatus"+e,"Error", JOptionPane.ERROR_MESSAGE);   
             
            }
            
              
              deletereservation();
            JOptionPane.showMessageDialog(this,"Check Out Successful","Reservation Status",JOptionPane.INFORMATION_MESSAGE);
            clear();
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog( this, " Failed to Checkout "+e,"Error", JOptionPane.ERROR_MESSAGE);            
         
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NIC;
    private javax.swing.JLabel broom;
    private javax.swing.JTextField cID;
    private com.toedter.calendar.JDateChooser checkin;
    private com.toedter.calendar.JDateChooser checkout;
    private javax.swing.JLabel conn;
    private javax.swing.JLabel days;
    private javax.swing.JLabel deposit;
    private javax.swing.JTextField dis;
    private javax.swing.JLabel food;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel name;
    private javax.swing.JLabel nettot;
    private javax.swing.JLabel othechag;
    private javax.swing.JLabel otheritems;
    private javax.swing.JLabel ppday;
    private javax.swing.JLabel rarrangement;
    private javax.swing.JLabel rdtot;
    private javax.swing.JLabel roomidbox;
    private javax.swing.JLabel subtotal;
    private javax.swing.JLabel totc;
    private javax.swing.JLabel tourcharges;
    private javax.swing.JLabel type;
    // End of variables declaration//GEN-END:variables
}
