/**********************************************
 *  Workshop 7
 *  Course:<JAC444> - Semester
 *  Last Name:<Wang>
 *  First Name:<Yiou(Anna)>
 *  ID:<151558194>
 *  Section:<NBB>
 *  This assignment represents my own work in accordance with Seneca Academic Policy. Signature
 *  Date:<2022-03-27>
 * **********************************************/
package com.example.lab7.Task2;

import java.util.Scanner;

public class UserInput {
    Scanner input = new Scanner(System.in);
    public double[] askArray(){
        System.out.println("Please input the number you want to insert into the array, " +
                "press Enter to finish");
        String temp = input.nextLine();
        String[] arrayStr = temp.split(" ");
        double[] arrayDou = new double[arrayStr.length];
        for(int i = 0; i< arrayDou.length; i++){
            arrayDou[i] = Double.parseDouble(arrayStr[i]);
        }
        return arrayDou;
    }

    public int askMethod(){
        int option;
        System.out.println("Please select which method to apply for the array:");
        System.out.println("1. Find the maximum value in the array");
        System.out.println("2. Find the minimum value in an array");
        System.out.println("3. Find the sum of the values in the array");
        System.out.println("4. Find the average of the values in the array.");
        System.out.println("5. Exit");
        option = input.nextInt();
        return option;
    }
}

