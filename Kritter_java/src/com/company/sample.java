package com.company;

import java.util.Scanner;

public class sample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of array :");
        int l = sc.nextInt();
        int a[] = new int[l];
        for (int i = 0; i < l; i++) {
            System.out.print("Enter elements :");
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < l ; i++) {
            for(int j=i+1;j<l;j++)
            {
                if(a[i]<a[j])
                {
                    int tamp=a[i];
                    a[i]=a[j];
                    a[j]=tamp;
                }
            }
        }
        for (int i = 0; i < l; i++) {
            System.out.println(a[i]);
        }

    }
}
