import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Objects;

public class ClientHandler implements Runnable {
    private Socket client;
    private BufferedReader input;
    private PrintWriter output;
    private String playerName;
    private ArrayList<ClientHandler> clients;
    public boolean playerColour;
    private static boolean WhitePlayerTurn=true;

    public static boolean isWhitePlayerTurn() {
        return WhitePlayerTurn;
    }
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
            //Dialog that asks for the name
            nameInteraction(Server.getClientThread().isPlayerColour());

            String request = input.readLine();
            while(!Objects.equals(request, "quit") && !Objects.equals(request, null)) {
                outToAll(request);
                request = input.readLine();
            }
            if (this.equals(clients.get(0))){
                clients.get(1).output.println(clients.get(0).getPlayerName()+" has left the game.");
            }
            else {
                clients.get(0).output.println(clients.get(1).getPlayerName()+" has left the game.");
            }
        } catch (IOException e){
            System.err.println("IOException in client handler");
            System.err.println(e.getStackTrace());
        }
        finally {
            output.close();
            clients.remove(this);
            try {
                input.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void outToAll(String message){
        clients.get(0).output.println("["+getPlayerName()+"]: "+message);
        clients.get(1).output.println("["+getPlayerName()+"]: "+message);
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
                "\nENTER 'quit' TO LEAVE THE GAME OR SEND A MESSAGE TO YOUR OPPONENT.\n");
        if (this.equals(clients.get(0))){
            clients.get(1).output.println(">"+getPlayerName()+" has entered the game.<");
        }
        else{
            clients.get(0).output.println(">"+getPlayerName()+" has entered the game.<");
        }
    }
}
