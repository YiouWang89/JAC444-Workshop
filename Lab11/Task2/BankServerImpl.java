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

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BankServerImpl extends UnicastRemoteObject implements AccountInterface{

    AccountHost host;

    AccountHost[] accountHosts = new AccountHost[]{
            new AccountHost("Anna Wang", "anna1234", "1234567890", (float) 5000.83),
            new AccountHost("Zac Cao", "zac1234", "2345678901", (float) 3000.32),
            new AccountHost("Milo Han", "milo1234", "3456789012", (float) 600.9)
    };

    protected BankServerImpl() throws RemoteException {
    }

    @Override
    public String login(String username, String pwd, String accountNo) throws RemoteException {
        String loginMessage ="Login Failed";

        for(AccountHost accountHost : accountHosts){
            if(username.equals(accountHost.getUsername())){
                if(pwd.equals(accountHost.getPassword())){
                    if(accountNo.equals(accountHost.getAccountNo())){
                        host = accountHost;
                        loginMessage = "Login Successes";
                    }
                }
            }
        }
        return loginMessage;
    }

    @Override
    public String getName() throws RemoteException {
        return host.getUsername();
    }

    @Override
    public float getBalance() throws RemoteException {
        return host.getAccountBalance();
    }

    @Override
    public void withdraw(float amt) throws RemoteException {
        float newBalance = host.getAccountBalance() - amt;
        host.setAccountBalance(newBalance);
    }

    @Override
    public void deposit(float amt) throws RemoteException {
        float newBalance = host.getAccountBalance() + amt;
        host.setAccountBalance(newBalance);
    }

    @Override
    public boolean transfer(String acc, float amt) throws RemoteException {
        boolean transferSuccess = false;
        for(AccountHost accountHost : accountHosts){
            if(acc.equals(accountHost.getAccountNo()) && !(acc.equals(host.getAccountNo()))){
                AccountHost transferHost = accountHost;
                transferHost.setAccountBalance(accountHost.getAccountBalance() + amt);
                host.setAccountBalance(host.getAccountBalance() - amt);
                transferSuccess = true;
            }
        }
        return transferSuccess;
    }
}
