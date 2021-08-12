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
public class Category {
    private int caid;
    private String caname;
    private String Description;

    public Category() {
    }

    public Category(int caid) {
        this.caid = caid;
    }
    

    public Category(int caid, String caname, String Description) {
        this.caid = caid;
        this.caname = caname;
        this.Description = Description;
    }

   
    public int getCaid() {
        return caid;
    }

    public void setCaid(int caid) {
        this.caid = caid;
    }

    public String getCaname() {
        return caname;
    }

    public void setCaname(String caname) {
        this.caname = caname;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    @Override
    public String toString() {
        return caname;
    }
    
}
