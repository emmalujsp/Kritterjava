package com.company;
import java.util.Scanner;
class SBI
{
    //changes by adarsh
    Scanner sc = new Scanner(System.in);
    int id;
 String name;
 float balance;
 char gender;
 void add()
 {
     System.out.print("Enter name :");
     name = sc.nextLine();
     System.out.print("Enter id :");
     id = sc.nextInt();
     System.out.print("Enter Balance :");
     balance = sc.nextFloat();
     System.out.print("Enter gender(m/f) :");
     gender = sc.next().charAt(0);
 }


}
public class Emmalu {
    public static void main(String[] args)
    {
        SBI client1=new SBI();
        client1.add();
        System.out.print("emmalu");
    }
}
