package com.company;

import java.util.Formatter;
import java.util.Scanner;

public class Bank {
    static String Bname="Central Bank";
    static String CEO="K C JOSEPH";
    static int EST=1983;
    Scanner sc = new Scanner(System.in);
    int id = 1000;
    String name;
    float balance;
    char gender;

    Bank(int i)
    {
        id=id+i;
        System.out.print("Enter name :");
        name = sc.nextLine();
        try {
            System.out.print("Enter Balance :");
            balance = sc.nextFloat();
        }
        catch (Exception e)
        {
            System.out.println("Enter integer");
        }

        System.out.print("Enter gender(m/f) :");
        gender = sc.next().charAt(0);
    }
    Bank(int ind,String nm,Float bal,char gen)
    {
        id=ind;
        name=nm;
        balance=bal;
        gender=gen;
    }


    static void bankDetails() {
        System.out.println("\tBank Name:"+Bname);
        System.out.println("\tCEO :"+CEO);
        System.out.println("\tEST :"+EST);
        System.out.println("---------------------------");
    }

    void printDeatils() {
        Formatter fmt = new Formatter();
        fmt.format("%14s %14s %14s %14s\n", id, name, balance,gender);
        System.out.println(fmt);

    }
    void deposit()
    {
        System.out.print("Enter the AMount to deposit :");
        int b= sc.nextInt();
        balance=balance+b;
        System.out.println("New Balance :"+balance);
    }
}
