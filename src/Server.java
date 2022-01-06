import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    //Liste, die die einzelnen Threads hält:
    private static ArrayList<ClientHandler> clients;
    private static ExecutorService pool = Executors.newFixedThreadPool(2);
    public static ArrayList GiveClients(){
        return clients;
    }

    public static ClientHandler getClientThread() {
        return clientThread;
    }

    private static ClientHandler clientThread;

    public static void main(String[] args) throws IOException {

        clients = new ArrayList<>();
        ServerSocket serverSocket = new ServerSocket(8080);


        while (clients.size() < 2) {

            System.out.println("[SERVER] Waiting for client connection...");
            Socket client = serverSocket.accept();
            System.out.println("[SERVER] Connected to client!");
            if (clients.size() == 0){

                clientThread = new ClientHandler(client, clients, true);

            }
            else {
                clientThread = new ClientHandler(client,clients,!clients.get(0).isPlayerColour());
            }
            clients.add(clientThread);

            pool.execute(clientThread);
        }
    }
}
