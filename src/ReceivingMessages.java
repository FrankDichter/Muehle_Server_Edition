import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ReceivingMessages implements Runnable {

    private Socket socket;
    private BufferedReader input;

    public ReceivingMessages(Socket socket) throws IOException {
        this.socket = socket;
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    }


    @Override
    public void run() {
        String serverResponse = null;

        try {
            while(true){
                serverResponse = input.readLine();

                if(serverResponse == "quit") break;

                System.out.println(serverResponse);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
