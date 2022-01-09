import java.io.*;
import java.net.Socket;
import java.util.Objects;

public class ClientHandler implements Runnable {
    private Socket client;
    private BufferedReader input;
    private PrintWriter output;
    private String playerName;
    private int indexSendingTo;
    private boolean playerColour;
    private boolean signedIn = false;
    private GameHandler gameHandler;

    public boolean isSignedIn() {return signedIn;}
    public String getPlayerName() {
        return playerName;
    }
    public boolean isPlayerColour() {
        return playerColour;
    }
    public void setPlayerColour(boolean playerColour) {
        this.playerColour = playerColour;}
    public GameHandler getGameHandler() {return gameHandler;}
    public void setGameHandler(GameHandler gameHandler) {
        this.gameHandler = gameHandler;}

    public ClientHandler (Socket clientSocket, boolean playerColour) throws IOException {
        this.client = clientSocket;
        this.playerColour = playerColour;
        input = new BufferedReader(new InputStreamReader(client.getInputStream()));
        output = new PrintWriter(client.getOutputStream(),true);

    }
    public ClientHandler(Socket client) throws IOException{
        this.client = client;
        input = new BufferedReader(new InputStreamReader(client.getInputStream()));
        output = new PrintWriter(client.getOutputStream(),true);
    }

    @Override
    public void run(){
        try{
            //Dialog that asks for the name
            nameInteraction(playerColour);
            if (this.equals(Server.getClients().get(0))){
                indexSendingTo = 1;
            }
            else {
                indexSendingTo = 0;
            }
            if (Server.getClients().size() > 1 && signedIn) {
                Server.getClients().get(indexSendingTo).output.println(">"+playerName+" has entered the game.<");
            }
            String message = input.readLine();

            while(!Objects.equals(message, "quit") && !Objects.equals(message, null)) {
                Server.getClients().get(indexSendingTo).output.println("["+playerName+"]: "+message);
                message = input.readLine();
            }
        } catch (IOException e){
            System.err.println("IOException in client handler");
            System.err.println(e.getStackTrace());
        }
        finally {
            if(Server.getClients().size() > 2) {
                Server.getClients().get(2).setPlayerColour(this.playerColour);
                Server.getGames().get(2).setPlayerColour(this.playerColour);
            }
            if(Server.getClients().size() > 1 && signedIn) {
                Server.getClients().get(indexSendingTo).output.println(">"+this.playerName+" has left the game.<");
            }
            output.close();
            Server.getClients().remove(this);
            Server.getGames().remove(this.gameHandler);

            if(Server.getClients().size() > 0) {
                Server.getClients().get(0).indexSendingTo = 1;
            }
            try {
                input.close();
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void nameInteraction (boolean playerColour) throws IOException {
        if (Server.getClients().size() > 1 && Server.getClients().get(0).isSignedIn()){
            this.output.println(">"+Server.getClients().get(0).getPlayerName()+" is waiting for you.<\n");
        }
        if (playerColour) {
            output.println("Hello player white! Please enter your name:");
        }
        else {
            output.println("Hello player black! Please enter your name:");
        }
        String nameRequest = input.readLine();
        playerName = nameRequest;
        signedIn = true;
        output.println("Welcome to the game, "+getPlayerName()+"!\n" +
                    "\nENTER 'quit' TO LEAVE THE GAME OR SEND A MESSAGE TO YOUR OPPONENT.\n");
    }
}
