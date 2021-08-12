/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import entity.Account;
import entity.Staff;
import guitar.application.DBContext;
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
public class StaffDAO  extends DBContext{
      public void insertCustomer(String name, String date, boolean gender, String phone, String address, int staffid ){
        String sql = "INSERT INTO [Staff]\n" +
                    "([staffname]\n" +
                    ",[staffdob]\n" +
                    ",[staffgender]\n" +
                    ",[staffphone]\n" +
                    ",[staffaddress])\n" +
                    " VALUES\n" +
                    " (?\n" +
                    ",?\n" +
                    ",?\n" +
                    ",?\n" +
                    ",?)";
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
      public Staff loadStaffs(String account){
           String sql = "select staffname from Staff a join Account b on a.staffid = b.StaffId where b.Accountname like ?";
            Staff sta = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, account);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {                
              String name = rs.getString("staffname");
               sta = new Staff(name);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
       return sta;
        
      }
      
    public ArrayList<Staff> addStaff() {

        ArrayList<Staff> sf = new ArrayList<>();
        String sql = "select staffid, staffname from Staff";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);

                Staff st = new Staff(id, name);
                sf.add(st);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return sf;
    }
      public static void main(String[] args) {
          StaffDAO dao = new StaffDAO();
       Staff sta = dao.loadStaffs("sa");
          System.out.println(sta.getName());
    }
}
