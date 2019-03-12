package com.tumblr.b1moz.caderninho003.domain;

public class Review {

    private float review;
    private Costumer costumer;
    private String comment;
    private String date; // just for tests

    public float getReview() {
        return review;
    }

    public void setReview(float review) {
        this.review = review;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
