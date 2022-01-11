import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Feld extends JButton /*implements ActionListener*/ {
    private final byte circle;
    private final byte positionOnCircle;
    private boolean isEmpty;
    private boolean colourOfStone;

    public Feld(byte circle, byte positionOnCircle) {
        setBackground(Color.WHITE);
        this.circle = circle;
        this.positionOnCircle = positionOnCircle;
        isEmpty = true;

    }

    public byte getCircle() {
        return circle;
    }

    public byte getPositionOnCircle() {
        return positionOnCircle;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public boolean isColourOfStone() {
        return colourOfStone;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public void setColourOfStone(boolean colourOfStone) {
        this.colourOfStone = colourOfStone;
    }
}
