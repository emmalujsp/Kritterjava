package com.company;

public class Sandra {
    static void myMethods(String names){
        System.out.println(names);
    }

    public static void main(String[] args) {
        System.out.println("Sandra");
        myMethods("Maria");
        int num1= 45;
        int num2= 59;
            if (num1>num2) {
                System.out.println("Number1 is greater than NUmber2");
            }
            else {
                System.out.println("NUmber2 is greater");

        }
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                continue;
            }
            System.out.println(i);
        }


    }
}
