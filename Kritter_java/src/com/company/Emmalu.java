package com.company;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import emjdetails.*;
class SBI
{
    //changes by adarsh
    /*hi all
    im adarsh Suresh editing this doc*/
    Scanner sc = new Scanner(System.in);
    int id=21;
    SBI()
    {
        System.out.print("Enter name :");
        name = sc.nextLine();
        System.out.print("Enter Balance :");
        balance = sc.nextFloat();
        System.out.print("Enter gender(m/f) :");
        gender = sc.next().charAt(0);
    }

    String name;
 float balance;
 char gender;
 void adddetails()
 {
     System.out.print("Enter name :");
     name = sc.nextLine();
     System.out.print("Enter Balance :");
     balance = sc.nextFloat();
     System.out.print("Enter gender(m/f) :");
     gender = sc.next().charAt(0);
 }
 void printdeatils()
 {
     System.out.println("Name :"+name);
     System.out.println("Id :"+id);
     System.out.println("Balance :"+balance);
     System.out.println("Gender :"+gender);
 }



}
public class Emmalu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);;
        emdetails x=new emdetails();
        ArrayList<SBI> accounts = new ArrayList<SBI>();
        //LinkedList<SBI> ll = new LinkedList<SBI>();
        x.msg();
        char ch;
        System.out.println("Welcome");
        do {


            System.out.print("1. Add Details\n2. Print Details\nEnter your Choice :");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    accounts.add(new SBI());
                    break;
                case 2:int len=accounts.size();
                    for(int i=0;i<len;i++)
                    {
                    accounts.get(i).printdeatils();
                    }
                    break;
            }
            System.out.print("Do you want to continue(y/n) :");
            ch = sc.next().charAt(0);
        }while(ch=='y' | ch=='Y');
    }
}
