import java.io.BufferedReader;
import java.net.Socket;

public class Game implements Runnable {

    private Socket socket;
    private BufferedReader input;
    private boolean playerColour;

    public Frame getFrame() {
        return frame;
    }

    private Frame frame;

    public Game(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        frame = new Frame();
    }
}
