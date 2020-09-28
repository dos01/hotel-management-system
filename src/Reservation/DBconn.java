/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reservation;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
/**
 *
 * @author Akila Fernando
 */
public class DBconn {
    
    
        public static java.sql.Connection connect() throws ClassNotFoundException, SQLException{
    java.sql.Connection con=null;
    
        try {
               Class.forName("com.mysql.jdbc.Driver");
    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/theterranova","root", "");
        } catch (Exception e) {
            System.out.println(e);
        }
    
        return con;
    }
    /*public static connection connect()
    {
        connection conn=null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = (connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/theterranova","root","");
            }catch(Exception e)
            {
                
            }
        
        return conn;
    }*/
}