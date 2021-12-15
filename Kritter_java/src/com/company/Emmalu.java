package com.company;
import java.io.FileWriter;
import java.util.*;
import emjdetails.*;
class BANK {
    //changes by adarsh and emmalu
    //Emmalu Change
    static String Bname="Central Bank";
    static String CEO="K C JOSEPH";
    static int EST=1983;
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


    static void Bankdetails() {
        System.out.println("\tBank Name:"+Bname);
        System.out.println("\tCEO :"+CEO);
        System.out.println("\tEST :"+EST);
        System.out.println("---------------------------");
    }

    void printdeatils() {
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
    class STATEBANK
    {
        //changes by adarsh and emmalu
        //Emmalu Change
        static String Bname="State Bank";
        static String CEO="Emmalu JOSEPH";
        static int EST=2000;
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


        static void Bankdetails()
        {
            System.out.println("\tBank Name:"+Bname);
            System.out.println("\tCEO :"+CEO);
            System.out.println("\tEST :"+EST);
            System.out.println("---------------------------");
        }
        void printdeatils()
        {
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
class SBI extends BANK
{

    SBI(int i) {
        super(i);
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
class CSB extends BANK
{

    CSB(int i)
    {
        super(1000+i);
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
public class Emmalu
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        emdetails x = new emdetails();
        x.msg();
        ArrayList<SBI> Sbiaccounts = new ArrayList<SBI>();
        ArrayList<CSB> Csbaccounts = new ArrayList<CSB>();
        ArrayList<STATEBANK> Saccounts = new ArrayList<STATEBANK>();
        //LinkedList<SBI> ll = new LinkedList<SBI>();


        char ch='y';
        System.out.println("Welcome");

        while (ch == 'y' | ch == 'Y')
        {
            try {

                System.out.print("1. CENTRAL BANK\n2. STATE  BANK\nEnter your Choice :");
                int cho = sc.nextInt();
                switch (cho) {

                    case 1:
                        while (ch == 'y' | ch == 'Y') {
                            BANK.Bankdetails();
                            System.out.print("1. STATE BANK OF INDIA \n2. CATHOLIC SYRIAN BANK\nEnter your Choice :");
                            int choi = sc.nextInt();
                            switch (choi) {

                                case 1:
                                    char conti1 = 'y';
                                    while (conti1 == 'y' | conti1 == 'Y') {
                                        System.out.println("Welcome to STATE BANK OF INDIA");
                                        System.out.println("-------------------------------------");
                                        System.out.print("1. Add Account\n2. Print Details\n3. Deposit Money\n4. Loan Calculator\n5. Download Details\nEnter your Choice :");
                                        int choice = sc.nextInt();
                                        switch (choice) {
                                            case 1:
                                                int ind = Sbiaccounts.size();
                                                Sbiaccounts.add(new SBI(ind));
                                                break;
                                            case 2:
                                                Formatter fmt = new Formatter();
                                                fmt.format("%14s %14s %14s %14s\n", "ID", "NAME", "BALANCE", "GENDER");
                                                System.out.println(fmt);
                                                System.out.println("------------------------------------------------------------------------------");
                                                int len = Sbiaccounts.size();
                                                for (int i = 0; i < len; i++) {
                                                    Sbiaccounts.get(i).printdeatils();
                                                }
                                                break;
                                            case 3:
                                                System.out.print("Enter Account number to insert :");
                                                int acc = sc.nextInt();
                                                int flag = 0;
                                                for (SBI i : Sbiaccounts) {
                                                    if (i.id == acc) {
                                                        i.deposit();
                                                        flag = 1;
                                                    }
                                                }
                                                if (flag == 0) {
                                                    System.out.println("Enter valid Account Number");
                                                }
                                                break;
                                            case 4:
                                                SBI.loan();
                                                break;
                                            case 5:
                                                FileWriter fw=new FileWriter("output.txt");
                                                for (SBI i:Sbiaccounts )
                                                {
                                                    fw.write(i.name);

                                                }

                                        }
                                        System.out.print("Do you want to continue(y/n) :");
                                        conti1 = sc.next().charAt(0);
                                    }
                                    break;
                                case 2:
                                    char conti2 = 'y';
                                    while (conti2 == 'y' | conti2 == 'Y') {
                                        System.out.println("Welcome to CATHOLIC SYRIAN BANK");
                                        System.out.println("-------------------------------------");
                                        System.out.print("1. Add Account\n2. Print Details\n3. Deposit Money\n4. Loan Calculator\nEnter your Choice :");
                                        int choice2 = sc.nextInt();
                                        switch (choice2) {
                                            case 1:
                                                int ind = Csbaccounts.size();
                                                Csbaccounts.add(new CSB(ind));
                                                break;
                                            case 2:
                                                Formatter fmt = new Formatter();
                                                fmt.format("%14s %14s %14s %14s\n", "ID", "NAME", "BALANCE", "GENDER");
                                                System.out.println(fmt);
                                                System.out.println("---------------------------------------------------------------------------------------------");
                                                int len = Csbaccounts.size();
                                                for (int i = 0; i < len; i++) {
                                                    Csbaccounts.get(i).printdeatils();
                                                }
                                                break;
                                            case 3:
                                                System.out.print("Enter Account number to insert :");
                                                int acc = sc.nextInt();
                                                int flag = 0;
                                                for (CSB i : Csbaccounts) {
                                                    if (i.id == acc) {
                                                        i.deposit();
                                                        flag = 1;
                                                    }
                                                }
                                                if (flag == 0) {
                                                    System.out.println("Enter valid Account Number");
                                                }
                                                break;
                                            case 4:
                                                CSB.loan();
                                                break;

                                        }
                                        System.out.print("Do you want to continue(y/n) :");
                                        conti2 = sc.next().charAt(0);
                                    }
                                    break;
                            }
                            System.out.print("Do you want to continue(Cnetral bank menu)(y/n) :");
                            ch = sc.next().charAt(0);
                        }
                        break;

                    case 2:
                        while (ch == 'y' | ch == 'Y') {
                            STATEBANK.Bankdetails();
                            System.out.print("1. Add Details\n2. Print Details\nEnter your Choice :");
                            int choice = sc.nextInt();
                            switch (choice) {
                                case 1:
                                    int ind = Saccounts.size();
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
                        }
                        break;
                }
            }
            catch(Exception e)
            {
                System.out.println("Invailid Format............");
            }

            System.out.print("Do you want to continue Main Menu(y/n) :");
            sc.nextLine();
            ch = sc.next().charAt(0);


        }
        /*Set<BANK> hSet1 = new HashSet<BANK>(Caccounts);
        hSet1.addAll(Caccounts);
        System.out.println(hSet1.size());

        Set<BANK> hSet2 = new HashSet<BANK>(Caccounts);
        hSet2.addAll(Caccounts);
        System.out.println(hSet2.size());


        Set<BANK> union = new HashSet<BANK>(hSet1);
        union.addAll(hSet1);
        System.out.print("Union of the two Set");
        System.out.println(union);*/

    }
}


