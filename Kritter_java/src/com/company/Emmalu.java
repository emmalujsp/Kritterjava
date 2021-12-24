package com.company;

import com.company.*;

import java.sql.*;
import java.io.*;
import java.util.*;

import emjdetails.*;

/**
 * @author Emmalu
 * @since 2021-11-29
 * java program
 */


//todo sort and write file
//here i am making changes
public class Emmalu {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String MySQLURL = "jdbc:mysql://localhost:3306/bank?useSSL=false";
        String databseUserName = "root";
        String databasePassword = "emmalujsp";

        Connection con = null;
        con = DriverManager.getConnection(MySQLURL, databseUserName, databasePassword);

        emdetails x = new emdetails();
        x.msg();
        ArrayList<Sbi> Sbiaccounts = new ArrayList<Sbi>();
        ArrayList<Csb> Csbaccounts = new ArrayList<Csb>();
        ArrayList<StateBank> Saccounts = new ArrayList<StateBank>();
        //LinkedList<Sbi> ll = new LinkedList<Sbi>();
        try {
            FileReader file = new FileReader("SBI.txt");
            BufferedReader br = new BufferedReader(file);
            String line;
            while ((line = br.readLine()) != null) {
                //Splits each line into words
                String[] words = line.split(" ");
                int ind = Integer.parseInt(words[0]);
                String name = words[1];
                float bal = Float.parseFloat(words[2]);
                char gen = words[3].charAt(0);
                Sbiaccounts.add(new Sbi(ind, name, bal, gen));

            }
        } catch (IOException e) {
            System.out.println("Error");
        }
        try {
            FileReader file = new FileReader("CSB.txt");
            BufferedReader br = new BufferedReader(file);
            String line;
            while ((line = br.readLine()) != null) {
                //Splits each line into words
                String[] words = line.split(" ");
                int ind = Integer.parseInt(words[0]);
                String name = words[1];
                float bal = Float.parseFloat(words[2]);
                char gen = words[3].charAt(0);
                Csbaccounts.add(new Csb(ind, name, bal, gen));

            }
        } catch (IOException e) {
            System.out.println("Error");
        }


        char ch = 'y';
        System.out.println("Welcome");

        while (ch == 'y' | ch == 'Y') {
            try {

                System.out.print("1. CENTRAL Bank\n2. STATE  Bank\nEnter your Choice :");
                int cho = sc.nextInt();
                switch (cho) {

                    case 1:
                        while (ch == 'y' | ch == 'Y') {
                            Bank.bankDetails();
                            System.out.print("1. STATE Bank OF INDIA \n2. CATHOLIC SYRIAN Bank\nEnter your Choice :");
                            int choi = sc.nextInt();
                            switch (choi) {

                                case 1:
                                    char conti1 = 'y';
                                    while (conti1 == 'y' | conti1 == 'Y') {
                                        System.out.println("Welcome to STATE Bank OF INDIA");
                                        System.out.println("-------------------------------------");
                                        System.out.print("1. Add Account\n2. Print Details\n3. Deposit Money\n4. Loan Calculator\n5. Download Details\n6. Get Details\n7. Insert into Database\nEnter your Choice :");
                                        int choice = sc.nextInt();
                                        switch (choice) {
                                            case 1:

                                                int ind = Sbiaccounts.size();
                                                Sbiaccounts.add(new Sbi(ind));
                                                break;
                                            case 2:
                                                Formatter fmt = new Formatter();
                                                System.out.print("Enter the id :");
                                                int temp = sc.nextInt();
                                                fmt.format("%14s %14s %14s %14s\n", "ID", "NAME", "BALANCE", "GENDER");
                                                System.out.println(fmt);
                                                System.out.println("------------------------------------------------------------------------------");
                                                int len = Sbiaccounts.size();
                                                for (int i = 0; i < len; i++) {
                                                    if (Sbiaccounts.get(i).id == temp)
                                                        Sbiaccounts.get(i).printDeatils();
                                                }

                                                break;
                                            case 3:
                                                System.out.print("Enter Account number to insert :");
                                                int acc = sc.nextInt();
                                                int flag = 0;
                                                for (Sbi i : Sbiaccounts) {
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
                                                Sbi.loan();
                                                break;
                                            case 5:
                                                try {
                                                    File new1 = new File("Sbi.txt");
                                                    OutputStream os = new FileOutputStream(new1);
                                                    PrintWriter pw = new PrintWriter(os);
                                                    for (Sbi i : Sbiaccounts) {
                                                        pw.print(+i.id);
                                                        pw.print(" " + i.name);
                                                        pw.print(" " + i.balance);
                                                        pw.println(" " + i.gender);

                                                    }
                                                    pw.close();
                                                    System.out.println("Success...");

                                                } catch (IOException e) {
                                                    System.out.println(e);
                                                }
                                                break;
                                            case 6:
                                                try {
                                                    File fr = new File("SBI.txt");
                                                    Scanner frsc = new Scanner(fr);
                                                    while (frsc.hasNextLine()) {
                                                        String data = frsc.nextLine();
                                                        System.out.println(data);

                                                    }

                                                } catch (FileNotFoundException e) {
                                                    System.out.println("Error occured");
                                                }
                                            case 7:
                                                try {

                                                    if (con != null) {
                                                        System.out.println("Database connection is successful !!!!");
                                                        String query = " insert into sbi (id, name, balance, gender)" + " values (?, ?, ?, ?)";
                                                        PreparedStatement preparedStmt = con.prepareStatement(query);
                                                        for (int i = 0; i < Sbiaccounts.size(); i++) {
                                                            preparedStmt.setInt(1, Sbiaccounts.get(i).id);
                                                            preparedStmt.setString(2, Sbiaccounts.get(i).name);
                                                            preparedStmt.setFloat(3, Sbiaccounts.get(i).balance);
                                                            preparedStmt.setString(4, String.valueOf(Sbiaccounts.get(i).gender));
                                                            preparedStmt.execute();

                                                        }


                                                    }
                                                } catch (Exception e) {
                                                    e.printStackTrace();
                                                } finally {
                                                    try {
                                                        if (con != null)
                                                            con.close();

                                                    } catch (Exception e) {
                                                        e.printStackTrace();
                                                    }
                                                }
                                        }

                                        System.out.print("Do you want to continue(y/n) :");
                                        conti1 = sc.next().charAt(0);
                                    }
                                    break;
                                case 2:
                                    char conti2 = 'y';
                                    while (conti2 == 'y' | conti2 == 'Y') {
                                        System.out.println("Welcome to CATHOLIC SYRIAN Bank");
                                        System.out.println("-------------------------------------");
                                        System.out.print("1. Add Account\n2. Print Details\n3. Deposit Money\n4. Loan Calculator\n5. Download Details\n6. Get Details\nEnter your Choice :");
                                        int choice2 = sc.nextInt();
                                        switch (choice2) {
                                            case 1:
                                                int ind = Csbaccounts.size();
                                                Csbaccounts.add(new Csb(ind));
                                                break;
                                            case 2:
                                                Formatter fmt = new Formatter();
                                                fmt.format("%14s %14s %14s %14s\n", "ID", "NAME", "BALANCE", "GENDER");
                                                System.out.println(fmt);
                                                System.out.println("---------------------------------------------------------------------------------------------");
                                                int len = Csbaccounts.size();
                                                for (int i = 0; i < len; i++) {
                                                    Csbaccounts.get(i).printDeatils();
                                                }
                                                break;
                                            case 3:
                                                System.out.print("Enter Account number to insert :");
                                                int acc = sc.nextInt();
                                                int flag = 0;
                                                for (Csb i : Csbaccounts) {
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
                                                Csb.loan();
                                                break;
                                            case 5:
                                                try {
                                                    File new1 = new File("CSB.txt");
                                                    OutputStream os = new FileOutputStream(new1);
                                                    PrintWriter pw = new PrintWriter(os);
                                                    for (Csb i : Csbaccounts) {
                                                        pw.print(+i.id);
                                                        pw.print(" " + i.name);
                                                        pw.print(" " + i.balance);
                                                        pw.println(" " + i.gender);

                                                    }
                                                    pw.close();
                                                    System.out.println("Success...");

                                                } catch (IOException e) {
                                                    System.out.println(e);
                                                }
                                                break;
                                            case 6:
                                                try {
                                                    File fr = new File("CSB.txt");
                                                    Scanner frsc = new Scanner(fr);
                                                    while (frsc.hasNextLine()) {
                                                        String data = frsc.nextLine();
                                                        System.out.println(data);

                                                    }

                                                } catch (FileNotFoundException e) {
                                                    System.out.println("Error occured");
                                                }

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
                            StateBank.bankDetails();
                            System.out.print("1. Add Details\n2. Print Details\nEnter your Choice :");
                            int choice = sc.nextInt();
                            switch (choice) {
                                case 1:
                                    int ind = Saccounts.size();
                                    Saccounts.add(new StateBank(ind));
                                    break;
                                case 2:
                                    int len = Saccounts.size();
                                    for (int i = 0; i < len; i++) {
                                        Saccounts.get(i).printDeatils();
                                    }
                                    break;
                            }
                            System.out.print("Do you want to continue(y/n) :");
                            ch = sc.next().charAt(0);
                        }
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invailid Format............");
            }

            System.out.print("Do you want to continue Main Menu(y/n) :");
            sc.nextLine();
            ch = sc.next().charAt(0);


        }
        /*Set<Bank> hSet1 = new HashSet<Bank>(Caccounts);
        hSet1.addAll(Caccounts);
        System.out.println(hSet1.size());

        Set<Bank> hSet2 = new HashSet<Bank>(Caccounts);
        hSet2.addAll(Caccounts);
        System.out.println(hSet2.size());


        Set<Bank> union = new HashSet<Bank>(hSet1);
        union.addAll(hSet1);
        System.out.print("Union of the two Set");
        System.out.println(union);*/

    }
}


