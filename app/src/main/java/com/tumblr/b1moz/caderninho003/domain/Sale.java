package com.tumblr.b1moz.caderninho003.domain;

import java.util.Date;
import java.util.List;

public class Sale {

    private String ID;
    private Date date;
    private List<Object[]> productQuantity; // o primeiro objecto sera o produto, o segundo sera a quantidade vendida
    private float total;
    private Costumer costumer;
    private boolean paid;
    private String[] topSoldProduct;
    private String dateString;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Object[]> getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(List<Object[]> productQuantity) {
        this.productQuantity = productQuantity;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public String[] getTopSoldProduct() {
        return topSoldProduct;
    }

    public void setTopSoldProduct(String[] topSoldProduct) {
        this.topSoldProduct = topSoldProduct;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }

    @Override
    public String toString() {
        StringBuilder sale = new StringBuilder();
        for (Object[] productAndQuantity: productQuantity) {
            Product product = (Product) productAndQuantity[0];
            sale.append(product.getName()).append(", ");
        }
        return sale.toString();
    }

}