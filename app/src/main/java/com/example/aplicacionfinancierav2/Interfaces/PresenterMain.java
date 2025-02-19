package com.example.aplicacionfinancierav2.Interfaces;

public interface PresenterMain {

   void saveUser(String name, String identification, String email, String phone, String password,
                 String confirmPassword);
   interface transaccion{
      void sendAmount(String phone, double amount, String description);
   }
}
