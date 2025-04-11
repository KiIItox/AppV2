package com.example.aplicacionfinancierav2.Model;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.aplicacionfinancierav2.Presenter.TransaccionPresenter;

public class SharedPrefHelper {
    private static final String PREF_NAME = "users";
    private static final String KEY_PHONE = "phone";


    //Obtener telefono
    public static void savePhone(Context context, String phone) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(KEY_PHONE, phone);
        editor.apply();
    }

    public static String getPhone(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return prefs.getString(KEY_PHONE, null);
    }
}
