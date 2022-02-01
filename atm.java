/***********
 Sample ATM application for java
start date :January 20, 2022
User : ale3x59 
*************/

import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

public class atm {

  private String act_num;
  private String name;
  private double balance= 0;
  private int pin;
  private int option;

  Scanner in = new Scanner (System.in);

  atm(String user, int psw){
    user=name;
    psw=pin;
  }
//creates acccount
  void create_act(){
      //System.out.println("Please Enter a New Account Number");
     // act_num =in.next();
      System.out.println("Please Enter a Name for the Account");
      name = in.next();
      System.out.println("Please Enter Current Balance");
      balance = in.nextLong();
      System.out.println("Please Enter PIN");
      pin = in.nextInt();
  }
  //displays account name and balance
  void show_act() {
      System.out.println(name+" $"+balance);
  }
  void login(){

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
