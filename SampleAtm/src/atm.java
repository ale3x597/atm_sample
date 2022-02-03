/***********
 Sample ATM application for java
start date :January 20, 2022
User : ale3x59 
*************/

import java.util.Random;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import javax.lang.model.util.ElementScanner6;


public class atm {
  private String act_num;
  private String name;
  private int balance= 0;
  private int pin;
  private int option;

  Scanner in = new Scanner (System.in);
public static void connect(){
  try {
      Class.forName("com.mysql.jdbc.Driver");
  } catch (ClassNotFoundException e) {
      System.out.println("No Driver Found");
      e.printStackTrace();
      return;
  }

  Connection connection=null;
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


  /* atm(String user, int psw){
    user=name;
    psw=pin;
  }*/
//creates acccount
  void create_act(){
      //System.out.println("Please Enter a New Account Number");
     // act_num =in.next();
      System.out.println("Please Enter a Name for the Account");
      name = in.next();
      System.out.println("Please Enter Current Balance");
      balance = in.nextInt();
      System.out.println("Please Enter PIN");
      pin = in.nextInt();
       //maybe assigning an account number is better, 6 digit so we have a slim chance of repeating account numbers
       act_num=accnt_num();
       System.out.println("Your account number is : "+ act_num);
  }
  public  String accnt_num(){
      Random rmd= new Random();
      int act_num=rmd.nextInt(999999);
      //make number 6 digits and a string
      return String.format("%06d",act_num);
  }
  //displays account name and balance
  //public  show_act() {
   //   return ("name", "balance");
  //}
  void login(){
      System.out.println("Please Enter Account Name");
      name=in.next();


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
      System.out.println("Welcome\n Please Choose an Option Below:\n 1: Create an Account\n 2. Login\n3.Cancel\n\n(choose number and click enter)");
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


public class login{

}
}
//im trying to fix the show account method, but maybe i can just get that info from the database