package models;

import models.Account;

public class Atm{
    //withdrawing , depositing , check balance

    public static double checkBalance(Account account){
        return account.fetechBalance();
    }
    
    public static boolean withdraw(Account account,double amount){
        boolean result = false;
        if(amount <= checkBalance(account)){
            result = account.debit(amount);         
        } 
        return result;
    }

    public static boolean deposit(Account account,double amount){
        boolean result = false;
        result = account.credit(amount);         
    
        return result;
    }
}

