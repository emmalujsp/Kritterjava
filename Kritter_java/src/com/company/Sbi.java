package com.company;

import java.util.Scanner;

public class Sbi extends Bank {

    Sbi(int i) {
        super(i);
    }

    Sbi(int ind, String name, float bal, char gen) {
        super(ind, name, bal, gen);
    }

    enum Loan_percent {
        HOMELOAN(5), GOLDLOAN(8), AGRICULTURE(2), EDUCATION(3);

        private int value;
        //todo Add multiple values to enum

        private Loan_percent(int value) {
            this.value = value;
        }
    }



    static void loan() {
        System.out.println("Loan details");
        int i = 1;
        int ln = 0;
        for (Loan_percent s : Loan_percent.values()) {
            System.out.println(i + "." + s + " " + s.value + "%");
            i = i + 1;

        }
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your loan Type :");
        int x = sc.nextInt();
        i = 1;
        for (Loan_percent s : Loan_percent.values()) {
            if (x == i) {
                ln = s.value;
            }
            i = i + 1;

        }
        System.out.print("Enter the amount for loan :");
        int loan_amount = sc.nextInt();
        System.out.print("Enter the NUmber of years :");
        int loan_years = sc.nextInt();
        float interest = (float) (loan_amount * ln / 100.0f * loan_years);
        float Total = loan_amount + interest;
        System.out.println("AMount to be repaid :" + Total);
    }
}
