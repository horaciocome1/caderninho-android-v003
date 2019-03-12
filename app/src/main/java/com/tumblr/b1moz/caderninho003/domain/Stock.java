package com.tumblr.b1moz.caderninho003.domain;

public class Stock {

    private Product product;
    private int availableQuantity; // quantidade disponivel desse produto

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }
}
