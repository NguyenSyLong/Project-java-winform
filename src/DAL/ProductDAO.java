/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import entity.Category;
import entity.Product;
import guitar.application.DBContext;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Lehait
 */
public class ProductDAO extends DBContext {

    public Product getProByID(int id) {
        Product pro = null;
        String sql = "select b.productid,b.productname,b.origin,b.price,a.categoryid ,a.Categoryname,a.[Description] from Category a join Product b\n"
                + " on a.categoryid = b.categoryid\n"
                + "where b.productID = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product pr = new Product();
                pr.setPid(rs.getInt("productid"));
                pr.setPname(rs.getString("productname"));
                pr.setPrice(rs.getFloat("price"));
                pr.setOrigin(rs.getString("origin"));
                Category ct = new Category(rs.getInt(1), rs.getString(2), rs.getString(3));
                pr.setCate(ct);
                pro = pr;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pro;
    }

    public ArrayList<Product> getPro(int caid) {
        ArrayList<Product> Pro = new ArrayList<>();
        String sql = "select b.productid,b.productname,b.origin,b.price,a.categoryid ,a.Categoryname,a.[Description] from Category a join Product b\n"
                + " on a.categoryid = b.categoryid\n"
                + "where b.categoryid = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, caid);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Product pr = new Product();
                pr.setPid(rs.getInt("productid"));
                pr.setPname(rs.getString("productname"));
                pr.setPrice(rs.getFloat("price"));
                pr.setOrigin(rs.getString("origin"));
                Category ct = new Category(rs.getInt(1), rs.getString(2), rs.getString(3));
                pr.setCate(ct);
                Pro.add(pr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Pro;
    }

    public ArrayList<Product> search(String txt) {
        ArrayList<Product> Pro = new ArrayList<>();
        String sql = "select productid,productname,price,origin from Product\n"
                + "where productname like '" + txt + "'";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                Product pr = new Product();

                pr.setPid(rs.getInt("productid"));
                pr.setPname(rs.getString("productname"));
                pr.setPrice(rs.getFloat("price"));
                pr.setOrigin(rs.getString("origin"));

                Pro.add(pr);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return Pro;
    }

    public void insert(String name, float price, String origin, int id) {
        String sql = "INSERT INTO [Product]\n"
                + "([productname]\n"
                + ",[price]\n"
                + ",[origin]\n"
                + ",[categoryid])\n"
                + "     VALUES\n"
                + "(?\n"
                + ",?\n"
                + ",?\n"
                + ",?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setFloat(2, price);
            statement.setString(3, origin);
            statement.setInt(4, id);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void update(String name, float price, String origin, int id, int pid) {
        String sql = "update Product set productname = ?,price= ?,origin=?,categoryid=? where productid=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);
            statement.setFloat(2, price);
            statement.setString(3, origin);
            statement.setInt(4, id);
            statement.setInt(5, pid);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void Delete(int pid) {
        String querry = "delete from Product where productid = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(querry);
            statement.setInt(1, pid);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
