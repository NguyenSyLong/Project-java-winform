/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import entity.Customer;
import guitar.application.DBContext;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lehait
 */
public class CustomerDAO extends DBContext {
       public void insertCustomer(String name, String date, boolean gender, String phone, String address, int staffid ){
        String sql = "INSERT INTO [Customers]\n" +
                    "           ([customername]\n" +
                    "           ,[customerdob]\n" +
                    "           ,[customergender]\n" +
                    "           ,[customerphone]\n" +
                    "           ,[customeraddress]\n" +
                    "           ,[staffid])\n" +
                    "     VALUES\n" +
                    "           (?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?\n" +
                    "           ,?)";
         try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, date);
            statement.setBoolean(3, gender);
            statement.setString(4, phone);
            statement.setString(5, address);
            statement.setInt(6, staffid);
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
    public void LoadCustomer(int staff){
             
        String sql = "select customerid,customername,customerdob,customergender,customerphone,customeraddress from Customers";
         try {
            PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery();
            rs.getInt(1);
            rs.getString(2);
            rs.getDate(3);
            rs.getBoolean(4);
            rs.getString(5);
            rs.getString(6);
            
            statement.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public ArrayList<Customer> LoadCustomer2(){
        ArrayList<Customer> cus = new ArrayList<>();
        String sql = "select customerid, customername,customerphone from Customers";
        
       try {
            PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet rs = statement.executeQuery();
             while(rs.next()){
            Customer cust = new Customer(rs.getInt("customerid"),rs.getString("customername"), rs.getString("customerphone"));
            cus.add(cust);
             }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
  
        return cus;
    }
     public ArrayList<Customer>  Search(String phone){
             
        String sql = "select customerid,customername,customerphone from Customers where customerphone = ?";
         ArrayList<Customer> cus = new ArrayList<>();
         try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, phone);
             ResultSet rs = statement.executeQuery();
             while (rs.next()) {                 
                 rs.getInt(1);
            rs.getString(2);
            rs.getString(3);
            Customer cust = new Customer(rs.getInt("customerid"),rs.getString("customername"), rs.getString("customerphone"));
            cus.add(cust);
             }
        
            
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cus;
    }

}
