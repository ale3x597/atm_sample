/***********
 Sample ATM application for java
start date :January 20, 2022
User : ale3x59 
*************/

import java.util.Random;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import javax.lang.model.util.ElementScanner6;
import java.sql.Statement;
//import com.mysql.cj.xdevapi.Statement;


public class atm {
  private int act_num;
  private String name;
  private int balance= 0;
  private int pin;
  private int option;

  Scanner in = new Scanner (System.in);
  private static Connection connection=null;
  Statement stmt= null;

public  void connect(){
  try {
      Class.forName("com.mysql.jdbc.Driver");
  } catch (ClassNotFoundException e) {
      System.out.println("No Driver Found");
      e.printStackTrace();
      return;
  }

  
  try{
      connection = DriverManager
      .getConnection("jdbc:mysql://localhost:3306/atm_log","root","uncp2022");
  } catch (SQLException p){
      System.out.println("Connection to database failed");
      p.printStackTrace();
      return;
  }
  if (connection!=null){
      System.out.println("You are Successfully Connected");
  }else {
      System.out.println("Failed to Connect");
  }
}

//creates acccount
  void create_act(){
      //System.out.println("Please Enter a New Account Number");
     // act_num =in.next();
     
      System.out.println("Please Enter a Name for the Account");
      name = in.next();
      System.out.println("Please Enter Current Balance");
      balance = in.nextInt();
      System.out.println("Please Enter PIN\n4 digit codes");
      pin = in.nextInt();
       //maybe assigning an account number is better, 6 digit so we have a minimal chance of repeating account numbers,
       //idealy we would check for repeating account numbers, but for simplicity we wont this time.
       act_num=accnt_num();
       System.out.println("Your account number is : "+ act_num);

       
       try {
        String sql= "Insert INTO log (act_num,pin,name,balance) VALUES(?,?,?,?)";
        PreparedStatement psmt = connection.prepareStatement(sql);
        psmt.setInt(1, act_num);
        psmt.setInt(2, pin);
        psmt.setString(3, name);
        psmt.setInt(4, balance);
        psmt.executeUpdate();
        System.out.println("\nAccount Created Successfully");
    } catch (SQLException e) {
        System.out.println("\nUnable to Create an Account.\nPlease Try Again Later");
        e.printStackTrace();
    }
      }

  public  int accnt_num(){
      Random rmd= new Random();
        act_num=rmd.nextInt(999999)+100000;
      //make number 6 digits and a string
      //return String.format("%06d",act_num);
    return act_num;
  }
  //displays account name and balance
  protected boolean login(){
      System.out.println("Please Enter Account Number");
      act_num=in.nextInt();
      System.out.println("Please Enter Account Pin");
      pin=in.nextInt();
      try {
        stmt = connection.createStatement();
        String sql = "SELECT * FROM log WHERE Act_Num= ' "+act_num+"'";
        ResultSet rs= stmt.executeQuery(sql);
        if (rs.next()){
            System.out.println("Account found");
            return true;
        }
        else{
            System.out.println("Account not found");
            return false;
        }
      }
      catch(Exception e){
          System.out.println("Account not found\n "+e.getMessage());
        return false;
      }
    

  }

  //deposit money 
  void deposit(int amount){
      System.out.println("Please Enter Amount You Wish to Deposit");
      amount = in.nextInt();
      if (amount !=0){
          balance= balance + amount;
      }
  }

  //withdraw money
  void withdraw(int amount){
      System.out.println("Please Enter Amount You Wish to Withdraw");
      amount =in.nextInt();
      if (amount !=0){
          balance = balance - amount;
      }
  }
  //starting Menu
  void menu(){
      System.out.println("\n\nWelcome\n Please Choose an Option Below:\n 1: Create an Account\n 2. Login\n 3. Cancel\n\n(choose a number and click enter)\n");
      option=in.nextInt();
      if (option==1){
          create_act();
      }
      else if (option==2){
          login();
      }
      else
         System.out.println("Option Not Avaiable");
    }
}
  