package com.example.aplicacionfinancierav2.Presenter;

import android.content.Context;
import android.util.Log;

import com.example.aplicacionfinancierav2.Interfaces.ModelMain;
import com.example.aplicacionfinancierav2.Interfaces.PresenterMain;
import com.example.aplicacionfinancierav2.Interfaces.ViewMain;
import com.example.aplicacionfinancierav2.Model.ModelImpl;
import com.example.aplicacionfinancierav2.Model.SharedPrefHelper;
import com.example.aplicacionfinancierav2.Model.UserDB;

public class HomePresenter implements PresenterMain {

    private ViewMain view;
    private ModelMain model;
    private UserDB userDB;
    private Context context;

    public HomePresenter(ViewMain view, Context c) {
        this.view = view;
        this.model = new ModelImpl(c);
        this.userDB = new UserDB(c);
        this.context = c;
    }

    public void saveUserPhone(String phone){
        if(context!= null){
            SharedPrefHelper.savePhone(context, phone);
        }
        else {
            Log.e("HomePresenter","Context is null");
        }
    }


    public void loadMoney(String phone) {
        double money = model.getMoney(phone);
        view.showMoney(money);
    }
    @Override
    public void saveUser(String name, String identification, String email, String phone, String password,String confirmPassword) {

    }
}
