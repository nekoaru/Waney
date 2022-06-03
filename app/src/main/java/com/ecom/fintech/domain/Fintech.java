package com.ecom.fintech.domain;

public class Fintech {

    private String category;
    private String cash;
    private String comment;
    private String date;

    public Fintech(String category, String cash, String comment, String date) {
        this.category = category;
        this.cash = cash;
        this.comment = comment;
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public String getCash() {
        return cash;
    }

    public String getComment() {
        return comment;
    }

    public String getDate() {
        return date;
    }
}
