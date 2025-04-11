package com.example.aplicacionfinancierav2.Model;

public class Voucher {



    private int id;
    private String phoneReceiber;
    private String phoneEmiter;
    private double amount;
    private String description;
    private String date;
    public Voucher(String phoneReceiber,String phoneEmiter,double amount,
                   String description, String date) {

        this.phoneReceiber = phoneReceiber;
        this.phoneEmiter = phoneEmiter;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneReceiber() {
        return phoneReceiber;
    }

    public void setPhoneReceiber(String phoneReceiber) {
        this.phoneReceiber = phoneReceiber;
    }

    public String getPhoneEmiter() {
        return phoneEmiter;
    }

    public void setPhoneEmiter(String phoneEmiter) {
        this.phoneEmiter = phoneEmiter;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
