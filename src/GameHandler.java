import java.io.BufferedReader;
import java.net.Socket;

public class GameHandler implements Runnable {

    private Socket socket;
    private BufferedReader input;
    private boolean playerColour;

    public Frame getFrame() {
        return frame;
    }

    public void setPlayerColour(boolean playerColour) {
        this.playerColour = playerColour;
    }

    private Frame frame;

    public GameHandler(Socket socket) {
        this.socket = socket;
    }

    public GameHandler(Socket socket, boolean playerColour) {
        this.socket = socket;
        this.playerColour = playerColour;
    }

    @Override
    public void run() {
        frame = new Frame();
    }
}
