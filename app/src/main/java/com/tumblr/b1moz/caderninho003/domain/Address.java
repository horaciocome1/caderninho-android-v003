package com.tumblr.b1moz.caderninho003.domain;

public class Address {

    private String ID;
    private boolean inCity; // eh na cidade ou nos bairros
    private String area; // bairo
    private int houseNumber; // numero da casa ou do apartamento/quarto

    // na cidade
    private String buildingName; // nome do predio
    private String street; // avenida
    private int floor; // piso

    // nos bairros
    private String block; // quarteirao
    private String busStopName; // nome da paragem

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Address(boolean inCity) {
        this.inCity = inCity;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        if (inCity)
            return area + ", " + street + ", " + buildingName + ", " + floor + "' piso, porta " + houseNumber;
        return area + ", " + ", " + busStopName + ", " + block + ", " + houseNumber;
    }

}
