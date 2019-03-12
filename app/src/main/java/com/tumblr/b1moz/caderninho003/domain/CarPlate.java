package com.tumblr.b1moz.caderninho003.domain;

public class CarPlate {

    private String letters; // primeiras 3 letras
    private String numbers; // os tres digitos
    private String province; // a sigla da provincia

    public CarPlate() {
    }

    public CarPlate(String letters, String numbers, String province) {
        this.letters = letters;
        this.numbers = numbers;
        this.province = province;
    }

    public String getLetters() {
        return letters;
    }

    public void setLetters(String letters) {
        this.letters = letters;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public String toString() {
        return letters + " - " + numbers + " - " + province;
    }
}
