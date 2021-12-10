package com.company;
import java.lang.*;
import java.util.*;

class bank {
    Scanner sc=new Scanner(System.in);
    Random ra = new Random();
    int age,balance=0,withd=0;
    String name;
    int acno=ra.nextInt(123456),password= ra.nextInt(9999), id_temp,pass_temp;

    void createac() {
        System.out.print("\nEnter your name : ");
        name = sc.nextLine();
        System.out.print("\nEnter your age : ");
        age = sc.nextInt();
        System.out.print("\nEnter the amount you wish to deposite : ");
        balance = sc.nextInt();
        System.out.println("Your ac has been created. \nThis is your ac no : "+acno);
        System.out.println("This is your password : "+password+"\nPlease save this for future reference");
    }

    void withdraw(){
        System.out.print("Enter your ac no : ");
        id_temp= sc.nextInt();
        System.out.print("Enter your ac no : ");
        pass_temp= sc.nextInt();
        if((id_temp==acno) && (pass_temp==password)) {
            System.out.print("Enter amount to be withdrawed : ");
            withd = sc.nextInt();
            balance=balance-withd;
            System.out.println("Final balance = "+balance);
        }
        else{
            System.out.println("No account found");
        }
    }

    void depo(){
        System.out.print("Enter your ac no : ");
        id_temp= sc.nextInt();
        System.out.print("Enter your ac no : ");
        pass_temp= sc.nextInt();
        if((id_temp==acno) && (pass_temp==password)) {
            System.out.print("Enter amount to deposit : ");
            withd = sc.nextInt();
            balance=balance+withd;
            System.out.println("Final balance = "+balance);
        }
        else{
            System.out.println("No account found");
        }
    }

    void acprint() {
        System.out.print("Enter your ac no : ");
        id_temp= sc.nextInt();
        System.out.print("Enter your ac no : ");
        pass_temp= sc.nextInt();
        if((id_temp==acno) && (pass_temp==password)) {
            System.out.println("Name = " + name);
            System.out.println("Your age = " + age);
            System.out.println("Balance = " + balance);
            System.out.println("Would you like to withdraw : ");
        }
        else{
            System.out.println("No account found");
        }
    }


}
public class Adarsh {
    public static void main(String[] args) {
        int a;
        char b;
        Scanner sc = new Scanner(System.in);
        bank c1 = new bank();
        do {
           System.out.print("\n\nWelcome\nPress 1 for creating an account\n" +
                   "Press 2 for display\n" +
                   "Press 3 to withdraw"+
                   "\nPress 4 to deposite"+
                   "\nPress 5 to exit" +
                   "\n\n Please enter your response : ");
           a = sc.nextInt();
           switch (a) {
               case 1:
                   c1.createac();
                   break;
               case 2:
                   c1.acprint();
                   break;
               case 3:
                   c1.withdraw();
                   break;
               case 4:
                   c1.depo();
                   break;
               case 5:
                   System.exit(0);
               default:
                   System.out.println("Invalid entry");
                   break;
           }
           System.out.print("\nDo you wish to continue?(Y|N) : ");
           sc.nextLine();
           b=sc.next().charAt(0);
       }while(b=='Y' | b=='y');
        System.out.println("Thank you for using our service. Have a nice day!");
    }
}
