/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import database.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;
import model.USERS;

/**
 *
 * @author Administrator
 */
public class userDAO {
    private ConnectDB connDB = new ConnectDB();
    
    public USERS checkLogin(String email , String password) {
        Connection conn = connDB.getConnect();
        
        PreparedStatement ptmt = null;
        String SQL = "select * from users where email = ? AND password = ?";
        
        try {
            ptmt = conn.prepareStatement(SQL);
            ptmt.setString(1, email );
            ptmt.setString(2, password);
            ResultSet rs = ptmt.executeQuery();
            
          while(rs.next())
          {
              USERS userObj = new USERS(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
              return userObj;
          }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return null;
    }
    
    public boolean updateUser(USERS user){
            Connection conn = connDB.getConnect();
        
        PreparedStatement ptmt = null;
        String SQL = "UPDATE users SET password = ?, avatar = ? Where email = ? ";
        
        try {
            ptmt = conn.prepareStatement(SQL);
            ptmt.setString(1, user.getPassword());
             ptmt.setString(2, user.getAvatar());
              ptmt.setString(3, user.getEmail());
           
            
            int kt = ptmt.executeUpdate();
           if(kt == 1)
           {
               return true;
           }
            
        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
        return false;
    }
    
    
    
}
