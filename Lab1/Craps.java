/**********************************************
 *  Workshop 1
 *  Course:<JAC444> - Semester
 *  Last Name:<Wang>
 *  First Name:<Yiou(Anna)>
 *  ID:<151558194>
 *  Section:<NBB>
 *  This assignment represents my own work in accordance with Seneca Academic Policy. Signature
 *  Date:<2022-01-25>
 * **********************************************/

import java.util.Random;

public class Craps {
    public static void main(String[] args) {
        int sum;
        Random roll = new Random();

        int roll1 = roll.nextInt(5) + 1;
        int roll2 = roll.nextInt(5) + 1;

        sum = roll1 + roll2;

        switch (sum){
            case 2, 4, 10, 7:
                System.out.println( "You rolled " +  roll1 + " + " + roll2 + " = " + sum);
                System.out.println("Craps, Better Luck Next Time, You lose\n");
                break;
            case 3, 11:
                System.out.println("You rolled " +  roll1 + " + " + roll2 + " = " + sum);
                System.out.println("Congratulations, You win\n");
                break;
            default:{
                int point = sum;
                System.out.println("You rolled " +  roll1 + " + " + roll2 + " = " + point);
                System.out.println("Point is (established) set to " + point);
                do{
                    roll1 = roll.nextInt(5) + 1;
                    roll2 = roll.nextInt(5) + 1;
                    sum = roll1 + roll2;
                    System.out.println("You rolled " +  roll1 + " + " + roll2 + " = " + sum);
                }while(sum !=7 && sum != point);
                if(sum == 7){
                    System.out.println("Craps, Better Luck Next Time, You lose\n");
                }else{
                    System.out.println("Congratulations, You win\n");
                }
            }
        }
    }
}
