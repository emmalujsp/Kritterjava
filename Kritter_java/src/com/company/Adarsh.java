package com.company;

import java.util.*;

class bank {
    Scanner sc=new Scanner(System.in);
    int age;
    String name;
    void createac() {
        System.out.println("Enter your name : ");
        name = sc.nextLine();
        System.out.println("Enter your age : ");
        age = sc.nextInt();
    }

    void acprint() {
    System.out.println("Your age = "+age);
    System.out.println("Name = "+name);
    }
}
public class Adarsh {
    public static void main(String[] args) {
        int a;
        char b;
        do {
           Scanner sc = new Scanner(System.in);
           bank c1 = new bank();
           System.out.println("Welcome\nPress 1 for creating an account\nPress 2 for display");
           a = sc.nextInt();
           switch (a) {
               case 1:
                   c1.createac();
                   break;
               case 2:
                   c1.acprint();
                   break;
               default:
                   System.out.println("Invalid entry");
                   break;
           }
           System.out.print("\nDo you wish to continue?(Y|N) : ");
           sc.nextLine();
           b=sc.next().charAt(0);
       }while(b=='Y' | b=='y');
    }
}
