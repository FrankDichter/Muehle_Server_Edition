import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Objects;

public class ClientHandler implements Runnable {
    private Socket client;
    private BufferedReader input;
    private PrintWriter output;

    public ArrayList<ClientHandler> getClients() {
        return clients;
    }

    private ArrayList<ClientHandler> clients;
    public boolean playerColour;
    private static boolean WhitePlayerTurn=true;
    public static boolean isWhitePlayerTurn() {
        return WhitePlayerTurn;
    }


    private String playerName;

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }



    public boolean isPlayerColour() {
        return playerColour;
    }

    public ClientHandler (Socket clientSocket, ArrayList<ClientHandler> clients, boolean playerColour) throws IOException {
        this.client = clientSocket;
        this.clients = clients;
        this.playerColour = playerColour;
        input = new BufferedReader(new InputStreamReader(client.getInputStream()));
        output = new PrintWriter(client.getOutputStream(),true);

    }
    @Override
    public void run(){
        try{
            Frame frame = new Frame();

            nameInteraction(Server.getClientThread().isPlayerColour());

            while(true){
                String request = input.readLine();
                if (Objects.equals(request, "quit")) {
                    if (this.equals(clients.get(0))){
                        clients.get(1).output.println(clients.get(0).getPlayerName()+" has left the game.");
                    }
                    else {
                        clients.get(0).output.println(clients.get(1).getPlayerName()+" has left the game.");
                    }
                    clients.remove(this);
                    break;
                }
                else {
                    outToAll(request);
                }

            }
        } catch (IOException e){
            System.err.println("IOException in client handler");
            System.err.println(e.getStackTrace());
        }
        finally {
            output.close();
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    private void outToAll(String message){
        for (ClientHandler clientHandler : clients){
            clientHandler.output.println("["+getPlayerName()+"]: "+message);
        }
    }
    private void nameInteraction (boolean playerColour) throws IOException {
        if (playerColour) {
            output.println("Hello player white! Please enter your name:");
        }
        else {
            output.println("Hello player black! Please enter your name:");
        }
        String nameRequest = input.readLine();
        setPlayerName(nameRequest);
        output.println("Welcome to the game, "+getPlayerName()+"!\n" +
                "Enter 'quit' to leave the game or send a message to " +
                "your opponent.");
    }
}
