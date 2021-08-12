/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import entity.Category;
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
public class CategoryDAO extends  DBContext{
    public ArrayList<Category> getCate(){
        String sql = "select categoryid,categoryname,[Description] from Category";
        ArrayList<Category> Cate = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {                
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String des = rs.getString(3);
                Category ct = new Category(id, name, des);
                Cate.add(ct);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        return Cate; 
    }
}
