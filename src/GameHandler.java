import javax.swing.event.MouseInputListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.net.Socket;

public class GameHandler implements Runnable{

    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private boolean playerColour;
    private Frame frame;
    public Frame getFrame() {
        return frame;
    }

    public GameHandler(Socket socket, boolean playerColour) throws IOException {
        this.socket = socket;
        this.playerColour = playerColour;
        input = new ObjectInputStream(socket.getInputStream());
        output = new ObjectOutputStream(socket.getOutputStream());
    }

    public GameHandler(Socket socket) throws IOException {
        this.socket = socket;
        input = new ObjectInputStream(socket.getInputStream());
        output = new ObjectOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {

        Frame frame = new Frame(playerColour,0);

    }


}
