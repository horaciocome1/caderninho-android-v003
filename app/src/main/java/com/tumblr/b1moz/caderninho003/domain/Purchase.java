package com.tumblr.b1moz.caderninho003.domain;

import java.util.Date;
import java.util.List;

public class Purchase {

    private String ID;
    private Store store;
    private List<Object[]> productAndQuantity; // o primeiro objecto sera o produto, o segundo sera a quantidade desejada
    private String date;
//    private Date date;
    private float total;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public List<Object[]> getProductAndQuantity() {
        return productAndQuantity;
    }

    public void setProductAndQuantity(List<Object[]> productAndQuantity) {
        this.productAndQuantity = productAndQuantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        String purchase = "";
        for (Object[] productAndQuantity: productAndQuantity) {
            Product product = (Product) productAndQuantity[0];
            Integer integer = (Integer) productAndQuantity[1];
            purchase = purchase + integer.toString() + " " + product.getName() + ", ";
        }
        purchase = purchase.substring(0, purchase.lastIndexOf(','));
        return purchase;
    }

}
