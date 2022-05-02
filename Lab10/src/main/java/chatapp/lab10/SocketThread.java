/**********************************************
 *  Workshop 10
 *  Course:<JAC444> - Semester
 *  Last Name:<Wang>
 *  First Name:<Yiou(Anna)>
 *  ID:<151558194>
 *  Section:<NBB>
 *  This assignment represents my own work in accordance with Seneca Academic Policy. Signature
 *  Date:<2022-04-17>
 * **********************************************/
package chatapp.lab10;

import java.io.*;
import java.net.Socket;

public class SocketThread extends Thread{
    private Socket socket;
    private String messageFromClient;

    public SocketThread(Socket socket){
        this.socket = socket;
    }

    public String getMessageFromClient() {
        return messageFromClient;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream( )));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            while((messageFromClient = reader.readLine()) != null){
                System.out.println("Server: GetMessage");
                System.out.println("Server: Message: " + messageFromClient + ", ip address: " + socket.getInetAddress().getHostAddress()
                 + " port: " + socket.getPort());
            }

            writer.print("Receive the message");
            writer.flush();
            socket.shutdownOutput();
            writer.close();
            reader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
