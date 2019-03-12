package com.tumblr.b1moz.caderninho003.domain;

public class Carrier {

    private String name;
    private Address address1;
    private Address address2;
    private CarPlate carPlate;
    private int totalClients;
    private float rating;
    private int totalDelivers;
    private String email;
    private String birthday;
    private Character sex;
    private Phone phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress1() {
        return address1;
    }

    public void setAddress1(Address address1) {
        this.address1 = address1;
    }

    public Address getAddress2() {
        return address2;
    }

    public void setAddress2(Address address2) {
        this.address2 = address2;
    }

    public CarPlate getCarPlate() {
        return carPlate;
    }

    public void setCarPlate(CarPlate carPlate) {
        this.carPlate = carPlate;
    }

    public int getTotalClients() {
        return totalClients;
    }

    public void setTotalClients(int totalClients) {
        this.totalClients = totalClients;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getTotalDelivers() {
        return totalDelivers;
    }

    public void setTotalDelivers(int totalDelivers) {
        this.totalDelivers = totalDelivers;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Character getSex() {
        return sex;
    }

    public void setSex(Character sex) {
        this.sex = sex;
    }

    public String[] getMoreDetailsList() {
        if (sex.toString().equalsIgnoreCase("m"))
            return new String[]{phone.toString(), email, birthday, "Masculino"};
        return new String[]{phone.toString(), email, birthday, "Femenino"};
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

}
