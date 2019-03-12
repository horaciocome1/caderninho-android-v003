package com.tumblr.b1moz.caderninho003.domain;

public class Phone {

    private int prefix;
    private int number;

    public Phone(int prefix, int number) {
        this.prefix = prefix;
        this.number = number;
    }

    public int getPrefix() {
        return prefix;
    }

    public void setPrefix(int prefix) {
        this.prefix = prefix;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return prefix + " " + String.valueOf(number).substring(0, 3) + " " + String.valueOf(number).substring(3, 7);
    }
}
