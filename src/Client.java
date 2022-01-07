import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {


    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1",8080);
        ReceivingMessages receivingMessages = new ReceivingMessages(socket);
        //BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(socket.getOutputStream(),true);

        /*String askingForName = input.readLine();
        System.out.println(askingForName);

        String giveNameToServer = keyboard.readLine();
        output.println(giveNameToServer);

        String greeting = input.readLine();
        System.out.println(greeting);*/
        new Thread(receivingMessages).start();
        while(true){
            String message = keyboard.readLine();
            output.println(message);
            if (message.equals("quit")) {
                break;
            }
        }
        output.close();
        socket.close();
        System.exit(0);
    }
}
