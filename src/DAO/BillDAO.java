/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import database.ConnectDB;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.BILL;
import model.BILLDetails;
import model.BillPrint;

/**
 *
 * @author Administrator
 */
public class BillDAO {
    
     private ConnectDB connDB = new ConnectDB();
     
     public boolean insertBill()
     {
         Connection conn = connDB.getConnect();
          PreparedStatement ptmt = null;
        String SQL = "Insert into billsss values(?,?,?) ";
        
        try {
            ptmt = conn.prepareStatement(SQL);
            ptmt.setString(1, String.valueOf(java.time.LocalDate.now()));
            ptmt.setString(2, "");
            ptmt.setInt(3, 0);
            
           
            
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
     
      public boolean insertDetailsBill(BILLDetails bILLDetails)
     {
         Connection conn = connDB.getConnect();
          PreparedStatement ptmt = null;
        String SQL = "Insert into billDetails values(?,?,?) ";
        
        try {
            ptmt = conn.prepareStatement(SQL);
            ptmt.setInt(1, bILLDetails.getIdBill());
            ptmt.setInt(2,bILLDetails.getIdFood());
            ptmt.setInt(3, bILLDetails.getAmount());
            
           
            
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
      
       public boolean updateDetailsBill(BILLDetails bILLDetails)
     {
         Connection conn = connDB.getConnect();
          PreparedStatement ptmt = null;
        String SQL = "UPDATE  billDetails SET amount = ? where idBill = ? AND idFood = ?";
        
        
        try {
            ptmt = conn.prepareStatement(SQL);
            ptmt.setInt(1, checkDetailsBillAvaiable(bILLDetails).getAmount() + 1 );
            ptmt.setInt(2,  bILLDetails.getIdBill());
            ptmt.setInt(3, bILLDetails.getIdFood());
            
           
            
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
      
       public BILLDetails checkDetailsBillAvaiable(BILLDetails bILLDetails)
     {
      Connection conn = connDB.getConnect();
          PreparedStatement ptmt = null;
        String SQL = "Select * from billDetails where idBill = ? and idFood = ? ";
        
        try {
            ptmt = conn.prepareStatement(SQL);
           ptmt.setInt(1, bILLDetails.getIdBill());
              ptmt.setInt(2, bILLDetails.getIdFood());
            ResultSet rs = ptmt.executeQuery();
           
           
           if(rs.next())
            {
                return new BILLDetails(rs.getInt("idBill"), rs.getInt("idFood"), rs.getInt("amount"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
        return null;
     }
      
      
      
       public int getIdBillNow()
     {
         Connection conn = connDB.getConnect();
          PreparedStatement ptmt = null;
        String SQL = "Select MAX(id) as id from billsss ";
        
        try {
            ptmt = conn.prepareStatement(SQL);
          
            ResultSet rs = ptmt.executeQuery();
            
           
            while(rs.next())
            {
                return rs.getInt("id");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
        return -1;
     }
       
       public int sumPriceBill(int ID)
       {
           Connection conn = connDB.getConnect();
           String SQL = "DECLARE	@return_value int,\n" +
"		@idBill int\n" +
"\n" +
"SELECT	@idBill = ?\n" +
"\n" +
"EXEC	@return_value = [dbo].[sumPriceInBill]\n" +
"		@idBill = @idBill OUTPUT";
         try {
             CallableStatement call = conn.prepareCall(SQL);
             call.setInt(1, ID);
             
             ResultSet rs = call.executeQuery();
             
             if(rs.next())
             {
                 return rs.getInt("sumprice");
             }
             
             
         } catch (SQLException ex) {
             Logger.getLogger(BillDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
           
           return 0;
       }
       
             public boolean updateBill(BILL bill)
     {
         Connection conn = connDB.getConnect();
          PreparedStatement ptmt = null;
        String SQL = "UPDATE  billsss SET tableOrder=?, status = ? where id=?";
        
        
        try {
            ptmt = conn.prepareStatement(SQL);
            ptmt.setString(1, bill.getTableOrder() );
            ptmt.setInt(2,  1);
            ptmt.setInt(3, bill.getId());
            
           
            
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
             
     public ArrayList<BillPrint> getBillInPrintPDF(int ID)
     {
         Connection conn = connDB.getConnect();
          PreparedStatement ptmt = null;
        String SQL = "Select f.*, bd.amount from billsss b, billDetails bd, foods f\n" +
        "where  b.id = bd.idBill and bd.idFood = f.id\n" +
        "and b.id = ? ";
        ArrayList<BillPrint> list = new ArrayList<BillPrint>();
        try {
            ptmt = conn.prepareStatement(SQL);
          ptmt.setInt(1, ID);
            ResultSet rs = ptmt.executeQuery();
            String s = "";
           
            while(rs.next())
            {
                BillPrint billPrint = new BillPrint(rs.getString("foodName"), rs.getInt("amount"),
                        rs.getFloat("price"), sumPriceBill(ID));
                list.add(billPrint);
            }
                                                         
            return list;
            
        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
        return list;
     }
     
     public float thongKeBill(){
         Connection conn = connDB.getConnect();
          PreparedStatement ptmt = null;
        String SQL = "Select SUM(bd.amount*f.price) as sumPrice from billDetails bd, foods f where bd.idFood = f.id";
        ArrayList<BillPrint> list = new ArrayList<BillPrint>();
        try {
            ptmt = conn.prepareStatement(SQL);
         
            ResultSet rs = ptmt.executeQuery();
            String s = "";
           
            while(rs.next())
            {
                return rs.getFloat("sumPrice");
            }
                                                         
           
            
        } catch (SQLException ex) {
            Logger.getLogger(userDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        
        return 0;
     }
       
   
    
}
