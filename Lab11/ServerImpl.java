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
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.format.DateTimeFormatter;
import  java.time.LocalDateTime;

public class ServerImpl extends UnicastRemoteObject implements LocalDateTimeRemote{
    protected ServerImpl() throws RemoteException {
    }

//    public ServerImpl() throws RemoteException{
//        UnicastRemoteObject.exportObject(this, 0);
//    }

    @Override
    public String getDateTime() throws RemoteException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        return dtf.format(localDateTime);
    }
}
