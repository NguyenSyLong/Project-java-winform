/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import entity.Customer;
import entity.Order;
import entity.Product;
import entity.Staff;
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
public class OrderDAO extends DBContext {

    public void insertOrder(String date, double totalprice, int cusid) {
        String sql = "INSERT INTO [Order]\n"
                + "([orderdate]\n"
                + ",[totalprice]\n"
                + ",[customerid])\n"
                + "VALUES\n"
                + "(?\n"
                + ",?\n"
                + ",?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, date);
            statement.setDouble(2, totalprice);
            statement.setInt(3, cusid);
            statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public int addOrderDetail(int orderID, int productID, int amount) {
        int result = 0;
        String txt = "INSERT INTO [OrderDetails]\n" +
                    "([productid]\n" +
                    ",[orderid]\n" +
                    ",[amount])\n" +
                    " VALUES\n" +
                    "(?\n" +
                    ",?\n" +
                    ",?)" ;
                  
                
        try {
            PreparedStatement statement = connection.prepareStatement(txt);
            statement.setInt(1, productID);
            statement.setInt(2, orderID);
            statement.setInt(3, amount);
            result = statement.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public int getLastOrderID() {
        try {
            String sql = "select TOP(1)orderid from [order] order by orderid DESC";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("orderid");
                return id;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
