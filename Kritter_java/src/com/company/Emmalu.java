package com.company;
import java.util.*;

import emjdetails.*;
class BANK {
    //changes by adarsh and emmalu
    //Emmalu Change
    Scanner sc = new Scanner(System.in);
    int id = 1000;
    String name;
    float balance;
    char gender;

    BANK(int i)
    {
        id=id+i;
        System.out.print("Enter name :");
        name = sc.nextLine();
        System.out.print("Enter Balance :");
        balance = sc.nextFloat();
        System.out.print("Enter gender(m/f) :");
        gender = sc.next().charAt(0);
    }


    void adddetails() {
        System.out.print("Enter name :");
        name = sc.nextLine();
        System.out.print("Enter Balance :");
        balance = sc.nextFloat();
        System.out.print("Enter gender(m/f) :");
        gender = sc.next().charAt(0);
    }

    void printdeatils() {
        System.out.println("Name :" + name);
        System.out.println("Id :" + id);
        System.out.println("Balance :" + balance);
        System.out.println("Gender :" + gender);
    }
}
    class STATEBANK
    {
        //changes by adarsh and emmalu
        //Emmalu Change
        Scanner sc = new Scanner(System.in);
        int id=1000;
        String name;
        float balance;
        char gender;
        STATEBANK(int i)
        {
            id=id+i;
            System.out.print("Enter name :");
            name = sc.nextLine();
            System.out.print("Enter Balance :");
            balance = sc.nextFloat();
            System.out.print("Enter gender(m/f) :");
            gender = sc.next().charAt(0);
        }


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
public class Emmalu
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ;
        emdetails x = new emdetails();
        x.msg();
        ArrayList<BANK> Caccounts = new ArrayList<BANK>();
        ArrayList<STATEBANK> Saccounts = new ArrayList<STATEBANK>();
        //LinkedList<SBI> ll = new LinkedList<SBI>();


        char ch;
        System.out.println("Welcome");

        do
        {
            System.out.print("1. CENTRAL BANK\n2. STATE  BANK\nEnter your Choice :");
            int cho = sc.nextInt();
            switch (cho) {

                case 1:
                         do {
                                    System.out.print("1. Add Details\n2. Print Details\nEnter your Choice :");
                                    int choice = sc.nextInt();
                                    switch (choice) {
                                        case 1:
                                            int ind=Caccounts.size();
                                            Caccounts.add(new BANK(ind));
                                            break;
                                        case 2:
                                            int len = Caccounts.size();
                                            for (int i = 0; i < len; i++) {
                                                Caccounts.get(i).printdeatils();
                                            }
                                            break;
                                    }
                                    System.out.print("Do you want to continue(y/n) :");
                                    ch = sc.next().charAt(0);
                                } while (ch == 'y' | ch == 'Y');
                         break;

                case 2:do {
                                        System.out.print("1. Add Details\n2. Print Details\nEnter your Choice :");
                                int choice = sc.nextInt();
                                switch (choice) {
                                    case 1:
                                        int ind=Caccounts.size();
                                        Saccounts.add(new STATEBANK(ind));
                                        break;
                                    case 2:
                                        int len = Saccounts.size();
                                        for (int i = 0; i < len; i++) {
                                            Saccounts.get(i).printdeatils();
                                        }
                                        break;
                                }
                                System.out.print("Do you want to continue(y/n) :");
                                ch = sc.next().charAt(0);
                            } while (ch == 'y' | ch == 'Y');
                    break;
            }

            System.out.print("Do you want to continue(y/n) :");
            ch = sc.next().charAt(0);

        } while (ch == 'y' | ch == 'Y');
        Set<BANK> hSet1 = new HashSet<BANK>(Caccounts);
        hSet1.addAll(Caccounts);
        System.out.println(hSet1.size());

        Set<BANK> hSet2 = new HashSet<BANK>(Caccounts);
        hSet2.addAll(Caccounts);
        System.out.println(hSet2.size());


        Set<BANK> union = new HashSet<BANK>(hSet1);
        union.addAll(hSet1);
        System.out.print("Union of the two Set");
        System.out.println(union);

    }
}


