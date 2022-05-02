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
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    private LocalDateTimeRemote server;

    public RMIClient(){}

    public void startClient () throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry("localhost", 8080);
        server = (LocalDateTimeRemote) registry.lookup("DateServer");
    }

     public String getDateTime(){
        String dateTime=null;
         try {
             dateTime = server.getDateTime();
         } catch (RemoteException e) {
             e.printStackTrace();
         }
         return dateTime;
     }
}
