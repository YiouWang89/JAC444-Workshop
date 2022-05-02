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

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AccountInterface extends Remote {
        String login(String username, String pwd, String accountNo) throws RemoteException;

        String getName() throws RemoteException; // returns account holders name

        float getBalance() throws RemoteException; // return account balance

        // withdraw amount from balance. Consider validations for balance
        void withdraw(float amt) throws RemoteException;

        // Deposit amount to account. Deposit should not be more than a certain threshold that you can decide
        void deposit(float amt) throws RemoteException;

        // transfer amount to provide account. Proper validation should be followed.
//        void transfer(float amt, AccountInterface src) throws RemoteException;
        boolean transfer(String acc, float amt) throws RemoteException;
    }

