package com.tumblr.b1moz.caderninho003.domain;

public class Category {
    
    private int resourseID; // string url
    private String name;
    private int quantity;
    
    public Category(int resourseID, String name, int quantity) {
        this.resourseID = resourseID;
        this.name = name;
        this.quantity = quantity;
    }
    
    public int getResourseID() {
        return resourseID;
    }
    
    public void setResourseID(int resourseID) {
        this.resourseID = resourseID;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
}
