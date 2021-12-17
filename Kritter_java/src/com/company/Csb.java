package com.company;

import java.util.Scanner;

public class Csb extends Bank
{

    Csb(int i)
    {
        super(1000+i);
    }
    Csb(int ind,String name,float bal,char gen)
    {
        super(1000+ind,name,bal,gen);
    }
    static void loan()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Loan details");
        System.out.print("Enter the amount for loan :");
        int loan_amount=sc.nextInt();
        System.out.print("Enter the NUmber of years :");
        int loan_years=sc.nextInt();
        float interest= (float) (loan_amount*0.05*loan_years);
        float Total=loan_amount+interest;
        System.out.println("AMount to be repiad :"+Total);

    }
}
