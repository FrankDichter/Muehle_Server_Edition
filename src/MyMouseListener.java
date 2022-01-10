import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener {

    Frame frame;
    Feld field;

    public MyMouseListener(Frame frame, Feld field) {
        this.frame = frame;
        this.field = field;

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        if (!frame.isGameOver()) {
            if (frame.isaMillWasCreatedInThePreviousAction()) {
                frame.removeStone(field);
                if (frame.allStonesAreBlocked() || frame.lessThanThreeStonesOnBoard(frame.isPlayerColour())) {
                    frame.setGameOver(true);
                    frame.displayWinner(frame.isPlayerColour());
                }
            } else {
                if (frame.getAmountOfUnusedStones(frame.isPlayerColour()) > 0) {
                    frame.firstPhaseMove(field);
                } else if (frame.getAmountOfStonesOutOfGame(frame.isPlayerColour()) < 6) {
                    frame.secondPhaseMove(field);
                } else {
                    frame.thirdPhaseMove(field);
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
