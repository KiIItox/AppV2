package com.example.aplicacionfinancierav2.Model;

public class Voucher {


    private String nameReceiver;
    private String nameEmiter;
    private String phoneReceiber;
    private String phoneEmiter;
    private String coin;
    private int amount;
    private String description;
    private String date;
    public Voucher(String nameReceiver, String nameEmiter, String phoneReceiber,
                   String phoneEmiter, String coin, int amount, String description, String date) {

        this.nameReceiver = nameReceiver;
        this.nameEmiter = nameEmiter;
        this.phoneReceiber = phoneReceiber;
        this.phoneEmiter = phoneEmiter;
        this.coin = coin;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public String getNameReceiver() {
        return nameReceiver;
    }

    public void setNameReceiver(String nameReceiver) {
        this.nameReceiver = nameReceiver;
    }

    public String getNameEmiter() {
        return nameEmiter;
    }

    public void setNameEmiter(String nameEmiter) {
        this.nameEmiter = nameEmiter;
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

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
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
