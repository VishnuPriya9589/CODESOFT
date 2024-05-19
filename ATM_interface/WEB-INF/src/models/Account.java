package models;

import java.sql.*;

public class Account{
    private int accountNumber;
    private String name;
    private int pin;
    private double balance;

    public Account(){}

    public Account(int accountNumber){
        this.accountNumber = accountNumber;
    }

    public Account(String name,int pin){
        this.name = name;
        this.pin = pin;
    }

    public Account(int accountNumber,int pin,double balance){
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public double fetechBalance(){
        double balance = 0.0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm?user=root&password=2318");
            String query = "select balance from accounts where account_number=?";
            
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1,accountNumber);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                balance = rs.getDouble(1);
            }
        }catch(SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }
        return balance;
    }

    public boolean createAccount(String name,int pin){
         try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm?user=root&password=2318");
            String query = "insert into accounts (name,pin) values (?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,name);
            ps.setInt(2,pin);

            int x = ps.executeUpdate();
            if(x==1)
                return true;

         }catch(SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Account exists(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm?user=root&password=2318");
            String query = "select pin,balance from accounts where account_number=?";
            
            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1,accountNumber);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                this.pin = rs.getInt(1);
                this.balance = rs.getDouble(2);
                return this;
            }
        }catch(SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean credit(double amount){
        boolean result = false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm?user=root&password=2318");
            String query = "update accounts set balance = ? where account_number=?";
            
            PreparedStatement ps = con.prepareStatement(query);
            double newBalance = fetechBalance()+amount;
            ps.setDouble(1,newBalance);
            ps.setInt(2,accountNumber);

            int x = ps.executeUpdate();

            if(x == 1){
                result = true;
            }
        }catch(SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public boolean debit(double amount){
        boolean result = false;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm?user=root&password=2318");
            String query = "update accounts set balance = ? where account_number=?";
            
            PreparedStatement ps = con.prepareStatement(query);
            double newBalance = fetechBalance()-amount;
            ps.setDouble(1,newBalance);
            ps.setInt(2,accountNumber);

            int x = ps.executeUpdate();

            if(x == 1){
                result = true;
            }
        }catch(SQLException|ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void setBalance(int balance){
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public void setPin(int pin){
        this.pin = pin;
    }

    public int getPin(){
        return pin;
    }

    public void setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }

    public int getAccountNumber(){
        return accountNumber;
    }
}