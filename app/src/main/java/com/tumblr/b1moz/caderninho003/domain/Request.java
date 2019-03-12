package com.tumblr.b1moz.caderninho003.domain;

import java.util.Date;
import java.util.List;

public class Request {

    private String ID;
    private List<Object[]> productQuantity; // o primeiro objecto sera o produto, o segundo sera a quantidade desejada;
    private Costumer costumer;
    private Store store;
    private String additionalInformation; // por exemplo se vai passar buscar, se prefere entregas a uma hora especifica, se deseja fazer vale
    private Date date; // data do pedido

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public List<Object[]> getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(List<Object[]> productQuantity) {
        this.productQuantity = productQuantity;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        String request = "";
        for (Object[] productAndQuantity: productQuantity) {
            Product product = (Product) productAndQuantity[0];
            Integer integer = (Integer) productAndQuantity[1];
            request = request + integer.toString() + " " + product.getName() + ", ";
        }
        return request;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

}
