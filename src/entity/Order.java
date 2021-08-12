/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Lehait
 */
public class Order {
   private int oid;
   private Date date;
   private float price;
   private Customer cusid;

    public Order() {
    }

    public Order(int oid, Date date, float price, Customer cusid) {
        this.oid = oid;
        this.date = date;
        this.price = price;
        this.cusid = cusid;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Customer getCusid() {
        return cusid;
    }

    public void setCusid(Customer cusid) {
        this.cusid = cusid;
    }
    
    
    

    @Override
    public String toString() {
        return "Order{" + "oid=" + oid + ", date=" + date + ", price=" + price + ", cusid=" + cusid + '}';
    }
   
   
    
}
