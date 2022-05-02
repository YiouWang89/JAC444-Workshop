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

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RunBankServer {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        AccountInterface server = new BankServerImpl();
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.bind("BankServer", server);
        System.out.println("Server Started");
    }
}
