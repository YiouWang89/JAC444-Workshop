/**********************************************
 *  Workshop 11
 *  Course:<JAC444> - Semester
 *  Last Name:<Wang>
 *  First Name:<Yiou(Anna)>
 *  ID:<151558194>
 *  Section:<NBB>
 *  This assignment represents my own work in accordance with Seneca Academic Policy. Signature
 *  Date:<2022-04-20>
 * **********************************************/

package Task2;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RunBankClient {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        int option;
        int count = 0;
        boolean transferSuccess;
        RMIBankClient client = new RMIBankClient();
        client.startBankClient();

        Scanner input = new Scanner(System.in);
        String loginMsg = null;
        do{
            System.out.println("Please Enter Your Name: ");
            String username = input.nextLine();
            System.out.println("Please Enter Your Account Number: ");
            String accountNo = input.nextLine();
            System.out.println("Please Enter Your Password: ");
            String password = input.nextLine();
            loginMsg =  client.login(username, password, accountNo);
            System.out.println(loginMsg);
        }while(loginMsg.equals("Login Failed"));

        System.out.println("Hello " + client.getName() + ", Welcome to Our Bank");

        do{
            option = client.showMenu();
            switch (option){
                case 1:
                    System.out.println("Balance: " + client.getBalance());
                    break;
                case 2:
                    System.out.println("Please Enter Withdraw Amount:");
                    float withdrawAmt = input.nextFloat();
                    input.nextLine();
                    client.withdraw(withdrawAmt);
                    System.out.println("Balance: " + client.getBalance());
                    break;
                case 3:
                    System.out.println("Please Enter Deposit Amount:");
                    float depositAmt = input.nextFloat();
                    input.nextLine();
                    client.deposit(depositAmt);
                    System.out.println("Balance: " + client.getBalance());
                    break;
                case 4:
                    do{
                        if(count > 0){
                            System.out.println("Cannot Complete Transfer. Please Enter the Account Number again:");
                        }
                        System.out.println("Please Enter the Account Number to Transfer:");
                        String transAcc = input.nextLine();
                        System.out.println("Please Enter Transfer Amount: ");
                        float transAmt = input.nextFloat();
                        input.nextLine();
                        transferSuccess = client.transfer(transAcc, transAmt);
                        count++;
                    }while(!transferSuccess);
                    if(transferSuccess){
                        System.out.println("Transfer Success!");
                        System.out.println("Balance: " + client.getBalance());
                    }
                    break;
            }
        }while(option != 5);
    }
}
