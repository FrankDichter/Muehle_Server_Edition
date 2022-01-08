import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Objects;

public class ReceivingMessages implements Runnable {

    private Socket socket;
    private BufferedReader input;

    public ReceivingMessages(Socket socket) throws IOException {
        this.socket = socket;
        input = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    }


    @Override
    public void run() {
        try {
            String serverResponse = input.readLine();
            while(!(serverResponse == null)) {
                System.out.println(serverResponse);
                serverResponse = input.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                input.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
