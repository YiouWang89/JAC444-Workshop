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
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class RunClient {
    public static void main(String[] args) throws NotBoundException, RemoteException {
        RMIClient client = new RMIClient();
        client.startClient();

        Scanner input = new Scanner(System.in);
        String read = "";
        while(true){
            System.out.println("Would you like to check the local Date and the Time? ");
            read = input.nextLine();
            if(read.equalsIgnoreCase("no")) break;
            System.out.println(client.getDateTime());
            System.out.println();
        }
    }
}
