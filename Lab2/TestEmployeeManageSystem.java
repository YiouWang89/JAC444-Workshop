/**********************************************
 *  Workshop 2
 *  Course:<JAC444> - Semester
 *  Last Name:<Wang>
 *  First Name:<Yiou(Anna)>
 *  ID:<151558194>
 *  Section:<NBB>
 *  This assignment represents my own work in accordance with Seneca Academic Policy. Signature
 *  Date:<2022-02-10>
 * **********************************************/

import java.util.Scanner;

public class TestEmployeeManageSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CompanyHR hr = new CompanyHR();
        int option;

        System.out.println("Welcome to the Employee Manage System");
        do{
            hr.printMenu();
            option = input.nextInt();
            input.nextLine();
            while(option < 1 || option > 7){
                System.out.println("Invalid option, please select from 1-7:");
                option = input.nextInt();
                input.nextLine();
            }
            hr.handleOption(option);
            System.out.println("Please press \"ENTER\" to continue...");
            input.nextLine();

        }while(option !=7);
    }
}
