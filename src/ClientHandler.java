import java.io.*;
import java.net.Socket;
import java.util.Objects;

public class ClientHandler implements Runnable {
    private Socket client;
    private BufferedReader input;
    private PrintWriter output;
    private String playerName;
    private boolean playerColour;

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }
    public boolean isPlayerColour() {
        return playerColour;
    }
    public void setPlayerColour(boolean playerColour) {
        this.playerColour = playerColour;
    }

    public ClientHandler (Socket clientSocket,boolean playerColour) throws IOException {
        this.client = clientSocket;
        //this.clients = clients;
        this.playerColour = playerColour;
        input = new BufferedReader(new InputStreamReader(client.getInputStream()));
        output = new PrintWriter(client.getOutputStream(),true);

    }

    public ClientHandler(Socket client) throws IOException{
        this.client = client;
        //this.clients = clients;
        input = new BufferedReader(new InputStreamReader(client.getInputStream()));
        output = new PrintWriter(client.getOutputStream(),true);
    }

    @Override
    public void run(){
        try{
            //Dialog that asks for the name
            nameInteraction(playerColour);


            String message = input.readLine();
            while(!Objects.equals(message, "quit") && !Objects.equals(message, null)) {
                if (this.equals(Server.getClients().get(0))) {
                    Server.getClients().get(1).output.println("["+getPlayerName()+"]: "+message);
                }
                else {
                    Server.getClients().get(0).output.println("["+getPlayerName()+"]: "+message);
                }
                message = input.readLine();
            }
            if(Server.getClients().get(2) != null) {
                Server.getClients().get(2).setPlayerColour(this.isPlayerColour());
            }
            if (this.equals(Server.getClients().get(0))){
                Server.getClients().get(1).output.println(Server.getClients().get(0).getPlayerName()+" has left the game.");
            }
            else {
                Server.getClients().get(0).output.println(Server.getClients().get(1).getPlayerName()+" has left the game.");
            }
        } catch (IOException e){
            System.err.println("IOException in client handler");
            System.err.println(e.getStackTrace());
        }
        finally {
            output.close();
            Server.getClients().remove(this);
            try {
                input.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
                "\nENTER 'quit' TO LEAVE THE GAME OR SEND A MESSAGE TO YOUR OPPONENT.\n");
        if (this.equals(Server.getClients().get(0))){
            Server.getClients().get(1).output.println(">"+getPlayerName()+" has entered the game.<");
        }
        else{
            Server.getClients().get(0).output.println(">"+getPlayerName()+" has entered the game.<");
        }
    }
}
