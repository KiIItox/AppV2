package com.example.aplicacionfinancierav2.Presenter;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.aplicacionfinancierav2.Interfaces.ModelMain;
import com.example.aplicacionfinancierav2.Interfaces.PresenterMain;
import com.example.aplicacionfinancierav2.Interfaces.ViewMain;
import com.example.aplicacionfinancierav2.Model.ModelImpl;

import com.example.aplicacionfinancierav2.Model.Voucher;
import com.example.aplicacionfinancierav2.Model.VoucherDB;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.xml.transform.Source;

public class VoucherPresenter implements PresenterMain {

    private ViewMain view;
    private Context context;
    private String date;
    private ModelMain model;
    private ModelImpl bdModel;
    int id;
    private VoucherDB voucherDb;
    public VoucherPresenter(ViewMain view, Context c) {
        this.view = view;
        this.model = new ModelImpl(c);
        this.bdModel = new ModelImpl(c);
        this.voucherDb = new VoucherDB(c);
        this.context = c;
    }
    public void dataFull(String phoneReceiver, double amount, String description, String phoneIssuer){
        String format = "yyyy-MM-dd HH:mm:ss";
        date = new SimpleDateFormat(format, Locale.getDefault()).format(new Date());
        Voucher voucher = new Voucher(phoneReceiver, phoneIssuer, amount, description, date);
        id = voucherDb.insertVoucher(voucher);
        String idParse = Integer.toString(id);
        view.voucherData(idParse, phoneReceiver, phoneIssuer, description, amount);

    }



    @Override
    public void saveUser(String name, String identification, String email, String phone, String password,String confirmPassword) {

    }


}