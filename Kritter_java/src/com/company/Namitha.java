package com.company;
import java.util.*;

class Customer
{
    Scanner sc = new Scanner(System.in);
    String name;
    int age;
    String gender;
    String place;

    void details()
    {
        System.out.print("Enter the Name: ");
        name=sc.nextLine();
        System.out.print("Enter the age: ");
        age=sc.nextInt();
        gender=sc.nextLine();
        System.out.print("Enter the Gender: ");
        gender=sc.nextLine();
        System.out.print("Enter the place: ");
        place = sc.nextLine();
    }

    void display()
    {
        System.out.println("Welcome, " +name+"!");
        System.out.println("Age: "+age);
        System.out.println("Gender: "+gender);
        System.out.println("City: "+place);
    }
}
public class Namitha {
    public static void main(String[] args) {
        Customer cust = new Customer();
        cust.details();
        cust.display();
    }
}
