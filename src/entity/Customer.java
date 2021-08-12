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
public class Customer {
    private int cusid;
    private String cusname;
    private String date;
    private boolean gender;
    private String phone;
    private String address;
    private int staid;

    public Customer() {
    }

    public Customer(int cusid, String cusname, String date, boolean gender, String phone, String address, int staid) {
        this.cusid = cusid;
        this.cusname = cusname;
        this.date = date;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.staid = staid;
    }

    public Customer(int cusid, String cusname, String phone) {
        this.cusid = cusid;
        this.cusname = cusname;
        this.phone = phone;
    }

    
   
    
    

    public int getCusid() {
        return cusid;
    }

    public void setCusid(int cusid) {
        this.cusid = cusid;
    }

    public String getCusname() {
        return cusname;
    }

    public void setCusname(String cusname) {
        this.cusname = cusname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

   

    public String isGender() {
        if(gender==true){
            return"Male";
        }else{
            return"FeMale";
        }
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getStaid() {
        return staid;
    }

    public void setStaid(int staid) {
        this.staid = staid;
    }

    @Override
    public String toString() {
        return "Customer{" + "cusid=" + cusid + ", cusname=" + cusname + ", date=" + date + ", gender=" + gender + ", phone=" + phone + ", address=" + address + ", staid=" + staid + '}';
    }
    
}
