/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import database.ConnectDB;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.FOOD;
import model.MENUDetails;

/**
 *
 * @author Administrator
 */
public class MenuDAO {
    ConnectDB connDB = new ConnectDB();
    public ArrayList<String> getAllMenu() {
        Connection conn = connDB.getConnect();
        ArrayList<String> listFood = new ArrayList<String>();
        
        PreparedStatement ptmt = null;
        String SQL = "Select f.foodName, f.price from foods f,menuDetails m where f.id = m.idFood";
        
        try {
            ptmt = conn.prepareStatement(SQL);
           
            ResultSet rs = ptmt.executeQuery();
            
          while(rs.next())
          {
              MENUDetails mENUDetails = new MENUDetails(rs.getString("foodName"), rs.getFloat("price"));
              
              listFood.add(rs.getString("foodName") + " : " + rs.getFloat("price") + "đ");
          }
          
          
            
            
        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return listFood;
    }
    
       public boolean insertMenuDetails(int idFood){
            Connection conn = connDB.getConnect();
        
        PreparedStatement ptmt = null;
        String SQL = "Insert into menuDetails values(?,?) ";
        
        try {
            ptmt = conn.prepareStatement(SQL);
           ptmt.setInt(1, 1);
           ptmt.setInt(2, idFood);
            
           
            
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
       
        public boolean deleteMenu(){
            Connection conn = connDB.getConnect();
        
        PreparedStatement ptmt = null;
        String SQL = "DELETE FROM menuDetails WHERE idMenu = 1; ";
        
        try {
            ptmt = conn.prepareStatement(SQL);
        
            
           
            
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
