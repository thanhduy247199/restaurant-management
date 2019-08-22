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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.FOOD;
import model.USERS;

/**
 *
 * @author Administrator
 */
public class FoodDAO {
    private ConnectDB connDB = new ConnectDB();
    
    public ArrayList<FOOD> getAllFood() {
        Connection conn = connDB.getConnect();
        ArrayList<FOOD> listFood = new ArrayList<FOOD>();
        
        PreparedStatement ptmt = null;
        String SQL = "select * from foods";
        
        try {
            ptmt = conn.prepareStatement(SQL);
           
            ResultSet rs = ptmt.executeQuery();
            
          while(rs.next())
          {
              FOOD food = new FOOD(
                      rs.getInt("id"), 
                      rs.getInt("orders"),
                      rs.getString("foodName"),
                      rs.getString("dateCreate"),
                      rs.getString("dateEdit"),
                      rs.getString("image"),
                      rs.getString("type"),
                      rs.getFloat("price"));
              
              listFood.add(food);
          }
          
          
            
            
        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return listFood;
    }
    
    
    public boolean insertFood(FOOD food){
            Connection conn = connDB.getConnect();
        
        PreparedStatement ptmt = null;
        String SQL = "Insert into foods values(?,?,?,?,?,?,?) ";
        
        try {
            ptmt = conn.prepareStatement(SQL);
            ptmt.setString(1, food.getFoodName());
            ptmt.setFloat(2, food.getPrice() );
            ptmt.setString(3, String.valueOf(java.time.LocalDate.now()));
            ptmt.setString(4, String.valueOf(java.time.LocalDate.now()));
            ptmt.setString(5, food.getImage());
            ptmt.setInt(6, 0 );
            ptmt.setString(7, food.getType());
            
           
            
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
    
        public boolean deleteFood(int id){
            Connection conn = connDB.getConnect();
        
        PreparedStatement ptmt = null;
        String SQL = "DELETE FROM foods WHERE id=? ";
        
        try {
            ptmt = conn.prepareStatement(SQL);
            ptmt.setInt(1, id);
         
           
            
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

        
    public boolean updateFood(FOOD food){
            Connection conn = connDB.getConnect();
        
        PreparedStatement ptmt = null;
        String SQL = "UPDATE foods SET foodName = ?, price = ?, type = ? , image = ?, dateEdit = ? Where id = ? ";
        
        try {
            ptmt = conn.prepareStatement(SQL);
            ptmt.setString(1, food.getFoodName());
            ptmt.setFloat(2, food.getPrice());
            ptmt.setString(3, food.getType());
            ptmt.setString(4, food.getImage());
            ptmt.setString(5,String.valueOf(java.time.LocalDate.now()));
            ptmt.setInt(6, food.getId());
         
           
            
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
    
    public ArrayList<String> getAllFoodName() {
        Connection conn = connDB.getConnect();
        ArrayList<String> listFood = new ArrayList<String>();
        
        PreparedStatement ptmt = null;
        String SQL = "select id, foodName from foods";
        
        try {
            ptmt = conn.prepareStatement(SQL);
           
            ResultSet rs = ptmt.executeQuery();
            
          while(rs.next())
          {
              String var = rs.getInt("id")+ " " + rs.getString("foodName") ;
              
              listFood.add(var);
          }
          
          
            
            
        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return listFood;
    }
        
       
    
    
    public static void main(String[] args) {
        FoodDAO f = new FoodDAO();
        System.out.print( "hello" + f.insertFood(new FOOD(0, 0, "Mì xào bò", "2019-8-12",  "2019-8-12", "img/logo.png", "món chính", 30000)));
      
    }
    
    
}
