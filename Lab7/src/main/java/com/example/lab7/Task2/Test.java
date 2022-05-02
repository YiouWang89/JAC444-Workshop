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

public class Test {

    public static ArrayProcessor counter( double value ) {
        return array -> {
          int count = 0;
          for(int i=0; i< array.length; i++){
              if(array[i] == value)
                  count++;
          }
          return count;
        };
    }

    public static ArrayProcessor arrayMax = arr -> {
        double max = arr[0];
        for(int i=0; i<arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    };

    public static ArrayProcessor arrayMin = arr -> {
        double min = arr[0];
        for(int i=0; i<arr.length;i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    };

    public static ArrayProcessor arraySum = arr -> {
        double sum=0;
        for(int i = 0; i< arr.length; i++){
            sum +=arr[i];
        };
        return sum;
    };

    public static ArrayProcessor arrayAve = arr -> arraySum.apply(arr)/ arr.length;

    public static void main(String[] args) {
        UserInput user = new UserInput();
        Scanner input = new Scanner(System.in);

        double[] ar1= user.askArray();
        double searchNo;
        int option = user.askMethod();
        while (option !=5){
            switch (option){
                case 1:
                    System.out.print("The maximum value in the array is ");
                    System.out.println(arrayMax.apply(ar1));
                    break;
                case 2:
                    System.out.print("The minimum value in the array is ");
                    System.out.println(arrayMin.apply(ar1));
                    break;
                case 3:
                    System.out.print("The sum of the values in the array is ");
                    System.out.println(arraySum.apply(ar1));
                    break;
                case 4:
                    System.out.println("The average of the values in the array is");
                    System.out.println(arrayAve.apply(ar1));
                    break;
            }
            System.out.println("Please enter which element you want to search:");
            searchNo = input.nextDouble();
            input.nextLine();
            System.out.println(searchNo + " is occurs " + (int) counter(searchNo).apply(ar1) + " time");
            System.out.print("Press Enter to Continue");
            input.nextLine();
            option = user.askMethod();
        }
    }

}
