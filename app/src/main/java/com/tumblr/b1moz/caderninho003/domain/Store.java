package com.tumblr.b1moz.caderninho003.domain;

public class Store {

    private String name;
    private Address address;
    private StoreAdministrator storeAdministrator;
    private int totalStoreClients;
    private float rating;
    private String[] specialities;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public StoreAdministrator getStoreAdministrator() {
        return storeAdministrator;
    }

    public void setStoreAdministrator(StoreAdministrator storeAdministrator) {
        this.storeAdministrator = storeAdministrator;
    }

    public int getTotalStoreClients() {
        return totalStoreClients;
    }

    public void setTotalStoreClients(int totalStoreClients) {
        this.totalStoreClients = totalStoreClients;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String[] getSpecialities() {
        return specialities;
    }

    public void setSpecialities(String[] specialities) {
        this.specialities = specialities;
    }

    public String specialitiesToString() {
        String especialidades = "";
        for (String especialidade: this.specialities)
            especialidades += especialidade + ", ";
        especialidades = especialidades.substring(0, especialidades.lastIndexOf(','));
        return especialidades;
    }

}
