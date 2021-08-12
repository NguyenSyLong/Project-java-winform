/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Lehait
 */
public class Product {
   
   private int pid;
   private String pname;
   private float price;
   private String origin;
   private Category cate;
   
    public Product() {
    }

    public Product(int pid, String pname, float price, String origin, Category cate) {
        this.pid = pid;
        this.pname = pname;
        this.price = price;
        this.origin = origin;
        this.cate = cate;
    }

   

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Category getCate() {
        return cate;
    }

    public void setCate(Category cate) {
        this.cate = cate;
    }

    @Override
    public String toString() {
        return "Product{" + "pid=" + pid + ", pname=" + pname + ", price=" + price + ", origin=" + origin + ", cate=" + cate + '}';
    }
        
    
   
  
   
    
    
}
