/*public class Action {
    private boolean actionWasPerformed;
    private Feld field;
    private int whichAction;

    public Action() {}

    public void setActionWasPerformed(boolean actionWasPerformed) {
        this.actionWasPerformed = actionWasPerformed;
    }

    public void setField(Feld field) {
        this.field = field;
    }

    public boolean wasPerformed() {
        return actionWasPerformed;
    }
    public Feld getField() {
        return field;
    }

    public int getWhichAction() {
        return whichAction;
    }

    public void setWhichAction(int whichAction) {
        this.whichAction = whichAction;
    }

    public void performedAction(int whichAction,GameHandler gameHandler) {
        switch (whichAction){
            case 1:{
                gameHandler.getFrame().firstPhaseMove(field);
                break;
            }
            case 2:{
                gameHandler.getFrame().secondPhaseMove(field);
                break;
            }
            case 3:{
                gameHandler.getFrame().thirdPhaseMove(field);
                break;
            }
            case 4:{
                gameHandler.getFrame().removeStone(field);
                break;
            }
        }
    }
}*/
