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

import java.util.Scanner;

public class TestCalculator {
    public static void main(String[] args) {
        int newBalance, option;

        CreditLimitCalculator cal = new CreditLimitCalculator();

        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Credit Limit Calculator: \n ");
        do {
                cal.printMenu();
                option=input.nextInt();
            if(option == 1 ){
                cal.askDetail(cal);
                newBalance = cal.calBalance(cal);
                cal.isExceed(newBalance, cal);
            }else if(option == 2){
                if(cal.getAccountNo() != 0){
                    cal.displayDetail(cal);
                }else{
                    System.out.println("Please choose option1 to input information first.\n");
                }
            }
        }while ( option < 3);
    }
}
