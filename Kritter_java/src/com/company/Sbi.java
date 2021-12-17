package com.company;

import java.util.Scanner;

public class Sbi extends Bank{

    Sbi(int i) {
        super(i);
    }
    Sbi(int ind,String name,float bal,char gen)
    {
        super(ind,name,bal,gen);
    }

    static void loan()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Loan details");
        System.out.print("Enter the amount for loan :");
        int loan_amount=sc.nextInt();
        System.out.print("Enter the NUmber of years :");
        int loan_years=sc.nextInt();
        float interest= (float) (loan_amount*0.04*loan_years);
        float Total=loan_amount+interest;
        System.out.println("AMount to be repiad :"+Total);
    }
}
