package com.tumblr.b1moz.caderninho003.domain;

public class Product {

    private String ID;
    private String name; // nome do produto
    private String type; // categoria
    private String size; // numero de sapato, tamanho da garafa, gramas de chocolate

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
