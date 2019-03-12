package com.tumblr.b1moz.caderninho003.domain;

public class StoreAdministrator {

    private String name;
    private String emailAddress;
    private Character gender; // M or F
    private String birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String[] getAdministratorDetailsList() {
        if (this.gender.toString().equalsIgnoreCase("m"))
            return new String[]{this.name, this.emailAddress, "Masculino", this.birthday};
        return new String[]{this.name, this.emailAddress, "Feminino", this.birthday};
    }

}
