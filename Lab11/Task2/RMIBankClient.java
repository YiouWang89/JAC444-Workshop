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
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class RMIBankClient{
    private AccountInterface server;

    Scanner input = new Scanner(System.in);

    public void startBankClient() throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        server = (AccountInterface) registry.lookup("BankServer");
    }

    public String login(String username, String pwd, String accountNo) {
        String message = null;
        try {
            message = server.login(username, pwd, accountNo);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return message;
    }

    public String getName(){
        String name = null;
        try {
            name = server.getName();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return name;
    }


    public int showMenu(){
        int option;
        System.out.println("Please Select the Service");
        System.out.println("1. Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Transfer");
        System.out.println("5. Exit");
        option = input.nextInt();
        while(option < 1 || option > 5){
            System.out.println("Please Select Option Between 1 - 4: ");
            option = input.nextInt();
        }
        return option;
    }

    public float getBalance() {
        float balance = -1;
        try {
            balance = server.getBalance();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return balance;
    }

    public void withdraw(float amt){
        try {
            server.withdraw(amt);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public void deposit(float amt){
        try {
            server.deposit(amt);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean transfer(String transferAcc, float transferAmt){
        boolean transferSuccess = false;
        try {
            transferSuccess = server.transfer(transferAcc, transferAmt);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return transferSuccess;
    }

}
