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
    void print()
    {
        System.out.println("Name :"+name);
        System.out.println("Id :"+id);
        System.out.println("Balance :"+balance);
        System.out.println("Gender :"+gender);
    }


}
public class Emmalu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SBI client1 = new SBI();
        char ch;
        System.out.println("Welcome To Bank");
        do {
            {
                System.out.print("1. Add Details\n2. Print Details\nEnter your Choice :");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        client1.add();
                        break;
                    case 2:
                        client1.print();
                        break;
                }
            }
            System.out.print("Do you want to continue(y/n)?  :");
            ch = sc.next().charAt(0);
        } while (ch == 'y' | ch == 'Y');
    }
}
